package chess;

import bordgame.Board;
import bordgame.Piece;

public class ChessPiece extends Piece {
	//subclasse de Piece
	private Collor collor;

	public ChessPiece(Board board, Collor collor) {
		super(board);
		this.collor = collor;
	}

	public Collor getCollor() {
		return collor;
	}

	//SET N TEM PQ A COR N É ALTERADA
	

}
