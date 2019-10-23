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
	//INICIA  PARTIDA DE XADREZ COLOCANDO AS PEÇAS NO TABULEIRO
	private void initialSetup() {
		board.placePiece(new Rook(board, Collor.WHITE), new Position(2, 1));
		board.placePiece(new King(board, Collor.BLACK), new Position(0, 4));
		board.placePiece(new King(board, Collor.BLACK), new Position(7, 4));
	}
	
	
}
