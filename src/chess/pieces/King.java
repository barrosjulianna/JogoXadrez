package chess.pieces;

import bordgame.Board;
import bordgame.Position;
import chess.ChessPiece;
import chess.Chessmatch;
import chess.Collor;

public class King extends ChessPiece {

	public King(Board board, Collor collor) {
		super(board, collor);

	}

	@Override
	public String toString() {
		return "K";
	}

	private boolean canMove(Position position) {
		ChessPiece p = (ChessPiece) getBoard().piece(position);
		return p == null || p.getCollor() != getCollor();
	}

	@Override
	public boolean[][] possibleMoves() {
		boolean[][] mat = new boolean[getBoard().getRows()][getBoard().getColumns()];

		Position p = new Position(0, 0);
		// above
		p.setValues(position.getRow() - 1, position.getCollumn());
		// se existir posição e der pra mover
		if (getBoard().positionExists(p) && canMove(p)) {
			mat[p.getRow()][p.getCollumn()] = true;
		}
		// below
		p.setValues(position.getRow() + 1, position.getCollumn());
		// se existir posição e der pra mover
		if (getBoard().positionExists(p) && canMove(p)) {
			mat[p.getRow()][p.getCollumn()] = true;
		}
		// left
		p.setValues(position.getRow(), position.getCollumn() - 1);
		// se existir posição e der pra mover
		if (getBoard().positionExists(p) && canMove(p)) {
			mat[p.getRow()][p.getCollumn()] = true;
		}
		// right
		p.setValues(position.getRow(), position.getCollumn() + 1);
		// se existir posição e der pra mover
		if (getBoard().positionExists(p) && canMove(p)) {
			mat[p.getRow()][p.getCollumn()] = true;
		}
		// noroeste
		p.setValues(position.getRow() - 1, position.getCollumn() - 1);
		// se existir posição e der pra mover
		if (getBoard().positionExists(p) && canMove(p)) {
			mat[p.getRow()][p.getCollumn()] = true;
		}
		// nordeste
		p.setValues(position.getRow() - 1, position.getCollumn() + 1);
		// se existir posição e der pra mover
		if (getBoard().positionExists(p) && canMove(p)) {
			mat[p.getRow()][p.getCollumn()] = true;
		}
		// sudoeste
		p.setValues(position.getRow() + 1, position.getCollumn() - 1);
		// se existir posição e der pra mover
		if (getBoard().positionExists(p) && canMove(p)) {
			mat[p.getRow()][p.getCollumn()] = true;
		}
		// sudeste
		p.setValues(position.getRow() + 1, position.getCollumn() + 1);
		// se existir posição e der pra mover
		if (getBoard().positionExists(p) && canMove(p)) {
			mat[p.getRow()][p.getCollumn()] = true;
		}

		return mat;
	}
}
