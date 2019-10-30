package chess;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import bordgame.Board;
import bordgame.Piece;
import bordgame.Position;
import chess.pieces.King;
import chess.pieces.Rook;



public class ChessMatch {

	private int turn;
	private Collor currentPlayer;
	private Board board;
	private boolean check;
	
	private List<Piece> piecesOnTheBoard = new ArrayList<>();
	private List<Piece> capturedPieces = new ArrayList<>();
	
	public ChessMatch() {
		board = new Board(8, 8);
		turn = 1;
		currentPlayer = Collor.WHITE;
		initialSetup();
	}
	
	public int getTurn() {
		return turn;
	}
	
	public Collor getCurrentPlayer() {
		return currentPlayer;
	}
	
	public boolean getCheck() {
		return check;
	}
	//metodo retorna matriz de peças de xadrez correspondete a partida
	public ChessPiece[][] getPieces() {
		ChessPiece[][] mat = new ChessPiece[board.getRows()][board.getColumns()];
		for (int i=0; i<board.getRows(); i++) {
			for (int j=0; j<board.getColumns(); j++) {
				mat[i][j] = (ChessPiece) board.piece(i, j);
			}
		}
		return mat;
	}
	//INDICAÇÃO DE MOVIMENTOS POSSIVEIS, PRA ONDE A PEÇA PODE MEXER
	public boolean[][] possibleMoves(ChessPosition sourcePosition) {
		Position position = sourcePosition.toPosition();
		validateSourcePosition(position);
		return board.piece(position).possibleMoves();
	}
	
	public ChessPiece performChessMove(ChessPosition sourcePosition, ChessPosition targetPosition) {
		Position source = sourcePosition.toPosition();//VALIDAR POSIÇÃO DE DESTINO
		Position target = targetPosition.toPosition();
		validateSourcePosition(source);
		validateTargetPosition(source, target);
		Piece capturedPiece = makeMove(source, target);
		
		if (testCheck(currentPlayer)) {
			undoMove(source, target, capturedPiece);
			throw new ChessException("You can't put yourself in check");
		}
		
		check = (testCheck(opponent(currentPlayer))) ? true : false;
		
		nextTurn();
		return (ChessPiece)capturedPiece;
	}
	
	private Piece makeMove(Position source, Position target) {
		Piece p = board.removePiece(source);
		Piece capturedPiece = board.removePiece(target);
		board.placePiece(p, target);
		
		if (capturedPiece != null) {
			piecesOnTheBoard.remove(capturedPiece);
			capturedPieces.add(capturedPiece);
		}
		
		return capturedPiece;
	}
	//desfazer movimento pra qnd jogador der check na sua peça
	private void undoMove(Position source, Position target, Piece capturedPiece) {
		//pega a peça de destino e coloca na origem
		Piece p = board.removePiece(target);
		board.placePiece(p, source);

		//se tiver sido capturada
		if (capturedPiece != null) {
			//volta a peça captujrada pra posiç~çao e tira da lista de capturadas
			//e volta pra lista de jogo
			board.placePiece(capturedPiece, target);
			capturedPieces.remove(capturedPiece);
			piecesOnTheBoard.add(capturedPiece);
		}
	}
	
	private void validateSourcePosition(Position position) {
		if (!board.thereIsaPiece(position)) {
			throw new ChessException("There is no piece on source position");
		}//validar se a peça e do jogador da mesma cor
		if (currentPlayer != ((ChessPiece)board.piece(position)).getCollor()) {
			throw new ChessException("The chosen piece is not yours");
		}//VER SE EXISTE MOVIMENTOS POSSIVEIS, SE N IMPRIMIR MENSAGEM
		if (!board.piece(position).isThereAnyPossibleMove()) {
			throw new ChessException("There is no possible moves for the chosen piece");
		}
	}
	//se pra peça de origem a posição destino n é possivel n pode mexer
	private void validateTargetPosition(Position source, Position target) {
		if (!board.piece(source).possibleMove(target)) {
			throw new ChessException("The chosen piece can't move to target position");
		}
	}
	//quem joga
	private void nextTurn() {
		turn++;
		currentPlayer = (currentPlayer == Collor.WHITE) ? Collor.BLACK : Collor.WHITE;
		//validar se a peça e do jogador da mesma cor
	}
	
	private Collor opponent(Collor color) {
		return (color == Collor.WHITE) ? Collor.BLACK : Collor.WHITE;
	}
	//Varrer pra localizar o rei da determinada cor
	private ChessPiece king(Collor collor) {
		List<Piece> list = piecesOnTheBoard.stream().filter(x -> ((ChessPiece)x).getCollor() == collor).collect(Collectors.toList());
		for (Piece p : list) {
			if (p instanceof King) {
				return (ChessPiece)p;
			}
		}
		throw new IllegalStateException("There is no " + collor + " king on the board");
	}
	//TESTAR SE ESTA EM XEQUE
	private boolean testCheck(Collor collor) {
		Position kingPosition = king(collor).getChessPosition().toPosition();
		List<Piece> opponentPieces = piecesOnTheBoard.stream().filter(x -> ((ChessPiece)x).getCollor() == opponent(collor)).collect(Collectors.toList());
		for (Piece p : opponentPieces) {
			boolean[][] mat = p.possibleMoves();
			if (mat[kingPosition.getRow()][kingPosition.getCollumn()]) {
				return true;
			}
		}
		return false;
	}
	//RECECE CORDENADAS DO XADREZ A1 H8 INSTANCIAR NOVA PEÇA
	private void placeNewPiece(char column, int row, ChessPiece piece) {
		board.placePiece(piece, new ChessPosition(column, row).toPosition());
		piecesOnTheBoard.add(piece);
	}
	//INICIA  PARTIDA DE XADREZ COLOCANDO AS PEÇAS NO TABULEIRO PELA MATRIZ
	private void initialSetup() {
		placeNewPiece('c', 1, new Rook(board, Collor.WHITE));
        placeNewPiece('c', 2, new Rook(board, Collor.WHITE));
        placeNewPiece('d', 2, new Rook(board, Collor.WHITE));
        placeNewPiece('e', 2, new Rook(board, Collor.WHITE));
        placeNewPiece('e', 1, new Rook(board, Collor.WHITE));
        placeNewPiece('d', 1, new King(board, Collor.WHITE));

        placeNewPiece('c', 7, new Rook(board, Collor.BLACK));
        placeNewPiece('c', 8, new Rook(board, Collor.BLACK));
        placeNewPiece('d', 7, new Rook(board, Collor.BLACK));
        placeNewPiece('e', 7, new Rook(board, Collor.BLACK));
        placeNewPiece('e', 8, new Rook(board, Collor.BLACK));
        placeNewPiece('d', 8, new King(board, Collor.BLACK));
	}
}