package chess;

import com.sun.prism.paint.Color;

import bordgame.Board;
import bordgame.Position;
import chess.pieces.King;
import chess.pieces.Rook;

public class Chessmatch {
//regras do jogo
	
	private Board board;
	public Chessmatch() {
		board= new Board(8, 8); //TABULEIRO
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
	//RECECE CORDENADAS DO XADREZ A1 H8
	private void placeNewPiece(char column, int row, ChessPiece piece) {
		board.placePiece(piece, new ChessPosition(column, row).toPosition());
	}
	
	
	//INICIA  PARTIDA DE XADREZ COLOCANDO AS PEÇAS NO TABULEIRO PELA MATRIZ
	private void initialSetup() {
		// SISTEMA MATRIZ board.placePiece(new Rook(board, Collor.WHITE), new Position(2, 1));
		placeNewPiece('b',6, new Rook ( board, Collor.BLACK));
		placeNewPiece('e', 8, new King(board, Collor.WHITE));
	}
	
	
}
