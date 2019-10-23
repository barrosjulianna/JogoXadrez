package chess.pieces;

import bordgame.Board;
import chess.ChessPiece;
import chess.Collor;
//PEÇA TORRE
public class Rook extends ChessPiece{

	public Rook(Board board, Collor collor) {
		super(board, collor);
		
	}
	
	@Override
	public String toString() {
		return "R";
	}

}
