package chess.pieces;

import bordgame.Board;
import bordgame.Position;
import chess.ChessPiece;
import chess.ChessMatch;
import chess.Collor;

public class Knight extends ChessPiece {

	public Knight(Board board, Collor collor) {
		super(board, collor);

	}

	@Override
	public String toString() {
		return "N";
	}

	private boolean canMove(Position position) {
		ChessPiece p = (ChessPiece) getBoard().piece(position);
		return p == null || p.getCollor() != getCollor();
	}

	@Override
	public boolean[][] possibleMoves() {
		boolean[][] mat = new boolean[getBoard().getRows()][getBoard().getColumns()];

		Position p = new Position(0, 0);
		
		p.setValues(position.getRow() - 1, position.getCollumn()-2);
		
		if (getBoard().positionExists(p) && canMove(p)) {
			mat[p.getRow()][p.getCollumn()] = true;
		}
		
		p.setValues(position.getRow() -2, position.getCollumn()-1);
	
		if (getBoard().positionExists(p) && canMove(p)) {
			mat[p.getRow()][p.getCollumn()] = true;
		}
		
		p.setValues(position.getRow()-2, position.getCollumn() + 1);
		
		if (getBoard().positionExists(p) && canMove(p)) {
			mat[p.getRow()][p.getCollumn()] = true;
		}
		
		p.setValues(position.getRow()-1, position.getCollumn() + 2);
		
		if (getBoard().positionExists(p) && canMove(p)) {
			mat[p.getRow()][p.getCollumn()] = true;
		}
		
		p.setValues(position.getRow() +1, position.getCollumn() +2);
		
		if (getBoard().positionExists(p) && canMove(p)) {
			mat[p.getRow()][p.getCollumn()] = true;
		}
		
		p.setValues(position.getRow() + 2, position.getCollumn() + 1);
		
		if (getBoard().positionExists(p) && canMove(p)) {
			mat[p.getRow()][p.getCollumn()] = true;
		}
		
		p.setValues(position.getRow() +2, position.getCollumn() -1);
		
		if (getBoard().positionExists(p) && canMove(p)) {
			mat[p.getRow()][p.getCollumn()] = true;
		}
		
		p.setValues(position.getRow() + 1, position.getCollumn() -2);
		
		if (getBoard().positionExists(p) && canMove(p)) {
			mat[p.getRow()][p.getCollumn()] = true;
		}

		return mat;
	}
}
