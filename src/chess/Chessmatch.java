package chess;

import com.sun.prism.paint.Color;

import bordgame.Board;
import bordgame.Piece;
import bordgame.Position;
import chess.pieces.King;
import chess.pieces.Rook;

public class Chessmatch {
//regras do jogo
	
	private Board board;
	private int turn;
	private Collor currentPlayer;
	
	public int getTurn() {
		return turn;		
	}
	public Collor getCurrentPlayer() {
		return currentPlayer;
	}
	
	
	public Chessmatch() {
		board= new Board(8, 8); //TABULEIRO
		turn=1;
		currentPlayer=Collor.WHITE;
		initialSetup();
	}
	//metodo retorna matriz de peças de xadrez correspondete a partida
	public ChessPiece[][] getpieces(){
		ChessPiece[][]mat = new ChessPiece[board.getRows()][ board.getColumns()];
		//percorrer a matriz e pra cada peça fazer um 
		for(int i=0;i<board.getRows();i++) {
			for (int j=0;j<board.getColumns();j++) {
				mat[i][j]=(ChessPiece) board.piece(i,j);
			}
		}return mat;
	}
	
	//INDICAÇÃO DE MOVIMENTOS POSSIVEIS, PRA ONDE A PEÇA PODE MEXER
	public boolean[][] possibleMoves(ChessPosition sourcePosition){
		Position position= sourcePosition.toPosition();
		validateSorcePosition(position);
		return board.piece(position).possibleMoves();
	}
	
	
	public ChessPiece performChessMove(ChessPosition sourcePosition, ChessPosition targetPosition) {
		Position source= sourcePosition.toPosition();
		Position target= targetPosition.toPosition();
		//verificar se há uma peça
		validateSorcePosition(source);//VALIDAR POSIÇÃO DE DESTINO
		validateTargetPosition(source,target);//VALIDAR PSIÇÃO DE ORIGEM
		Piece capturedPiece=makeMove(source,target);
		nextTurn();
		return (ChessPiece)capturedPiece;
	}
	private Piece makeMove(Position source, Position target) {
		Piece p= board.removePiece(source);
		Piece capturedPiece=board.removePiece(target);
		board.placePiece(p, target);
		return capturedPiece;
	}
	private void validateSorcePosition(Position position) {
		if(!board.thereIsaPiece(position)) {
			throw new ChessException("There is no piece on source position");
		}//validar se a peça e do jogador da mesma cor
		if(currentPlayer != ((ChessPiece)board.piece(position)).getCollor()){
			throw new ChessException("The chosen piece is not yous");
		}
		//VER SE EXISTE MOVIMENTOS POSSIVEIS, SE N IMPRIMIR MENSAGEM
		if(!board.piece(position).isThereAnyPossibleMove()) {
			throw new ChessException("There is no possible moves for the chosen piece");
		}
		//validar se a peça e do jogador da mesma cor
		
	}
	
	private void validateTargetPosition(Position source, Position target) {
		//se pra peça de origem a posição destino n é possivel n pode mexer
		if(!board.piece(source).possibleMove(target)) {
			throw new ChessException("The chosen piece can't move to target position");
		}
	}
	
	//quem joga
	private void nextTurn() {
		turn++;
		currentPlayer= (currentPlayer==Collor.WHITE)? Collor.BLACK: Collor.WHITE;
	}
	
	
	
	//RECECE CORDENADAS DO XADREZ A1 H8
	private void placeNewPiece(char column, int row, ChessPiece piece) {
		board.placePiece(piece, new ChessPosition(column, row).toPosition());
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
	
	

