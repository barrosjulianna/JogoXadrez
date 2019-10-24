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
	//metodo retorna matriz de pe�as de xadrez correspondete a partida
	public ChessPiece[][] getpieces(){
		ChessPiece[][]mat = new ChessPiece[board.getRows()][ board.getColumns()];
		//percorrer a matriz e pra cada pe�a fazer um 
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
	
	
	//INICIA  PARTIDA DE XADREZ COLOCANDO AS PE�AS NO TABULEIRO PELA MATRIZ
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
	
	

