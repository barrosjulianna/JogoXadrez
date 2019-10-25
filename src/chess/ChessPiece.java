package chess;

import bordgame.Board;
import bordgame.Piece;
import bordgame.Position;

public abstract class ChessPiece extends Piece {
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
	
	//pra ver se tem uma peça adversaria em uma dada posição/casa
	//se for adversaria pode mover pra matar
	//classe generica pois vai ser aproveitada
	protected boolean isThereOpponentPiece(Position position) {
		ChessPiece p=(ChessPiece) getBoard().piece(position);
		//se a cor for diverente da minha peça é peça adversaria
		return p != null && p.getCollor() != collor;
	}
	

}
