package chess;

import bordgame.Board;

public class Chessmatch {
//regras do jogo
	
	private Board board;
	public Chessmatch() {
		board= new Board(8, 8); //TABULEIRO
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
	
	
}
