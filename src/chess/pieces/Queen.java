package chess.pieces;

import bordgame.Board;
import bordgame.Position;
import chess.ChessPiece;
import chess.Collor;

//PEÇA TORRE
public class Queen extends ChessPiece {

	public Queen(Board board, Collor collor) {
		super(board, collor);

	}

	@Override
	public String toString() {
		return "Q";
	}

	@Override
	public boolean[][] possibleMoves() {
		boolean[][] mat = new boolean[getBoard().getRows()][getBoard().getColumns()];
		Position p = new Position(0, 0);
		//above
		p.setValues(position.getRow() - 1, position.getCollumn());
		while (getBoard().positionExists(p) && !getBoard().thereIsaPiece(p)) {
			mat[p.getRow()][p.getCollumn()] = true;
			p.setRow(p.getRow() - 1);
		} 
		if (getBoard().positionExists(p) && isThereOpponentPiece(p)) {
			mat[p.getRow()][p.getCollumn()] = true;
		}

		//esquerda
		p.setValues(position.getRow(), position.getCollumn() - 1);

		while (getBoard().positionExists(p) && !getBoard().thereIsaPiece(p)) {
			mat[p.getRow()][p.getCollumn()] = true;
			p.setCollumn(p.getCollumn() - 1);
		} 
		if (getBoard().positionExists(p) && isThereOpponentPiece(p)) {
			mat[p.getRow()][p.getCollumn()] = true;
		}
		//direita
		p.setValues(position.getRow(), position.getCollumn() + 1);

		while (getBoard().positionExists(p) && !getBoard().thereIsaPiece(p)) {
			mat[p.getRow()][p.getCollumn()] = true;
			p.setCollumn(p.getCollumn() + 1);
		} 
		if (getBoard().positionExists(p) && isThereOpponentPiece(p)) {
			mat[p.getRow()][p.getCollumn()] = true;
		}		
		p.setValues(position.getRow() + 1, position.getCollumn());
		//bellow
		while (getBoard().positionExists(p) && !getBoard().thereIsaPiece(p)) {
			mat[p.getRow()][p.getCollumn()] = true;
			p.setRow(p.getRow() + 1);
		} 
		if (getBoard().positionExists(p) && isThereOpponentPiece(p)) {
			mat[p.getRow()][p.getCollumn()] = true;
		}
		// noroeste nw
		p.setValues(position.getRow() - 1, position.getCollumn() -1);
		while (getBoard().positionExists(p) && !getBoard().thereIsaPiece(p)) {
			mat[p.getRow()][p.getCollumn()] = true;
			p.setValues(p.getRow() -1, p.getCollumn() -1);
		} // testar s existe paç adversaria, se existir pode andar mais uma pra capturar
		if (getBoard().positionExists(p) && isThereOpponentPiece(p)) {
			mat[p.getRow()][p.getCollumn()] = true;
		}

		// nordeste 
		p.setValues(position.getRow() -1, position.getCollumn() + 1);

		while (getBoard().positionExists(p) && !getBoard().thereIsaPiece(p)) {
			mat[p.getRow()][p.getCollumn()] = true;
			p.setValues(p.getRow() -1, p.getCollumn() +1);
		} 
		if (getBoard().positionExists(p) && isThereOpponentPiece(p)) {
			mat[p.getRow()][p.getCollumn()] = true;
		}
		//se sudeste
		p.setValues(position.getRow()+1 , position.getCollumn() + 1);

		while (getBoard().positionExists(p) && !getBoard().thereIsaPiece(p)) {		
			mat[p.getRow()][p.getCollumn()] = true;	
			p.setValues(p.getRow()+1, p.getCollumn()+ 1);
		}
		if (getBoard().positionExists(p) && isThereOpponentPiece(p)) {
			mat[p.getRow()][p.getCollumn()] = true;
		}
		
		//sudoeste sw
		p.setValues(position.getRow() + 1, position.getCollumn() -1);
	
		while (getBoard().positionExists(p) && !getBoard().thereIsaPiece(p)) {
			mat[p.getRow()][p.getCollumn()] = true;
			p.setValues(p.getRow()+1, p.getCollumn()-1);
		} 
		if (getBoard().positionExists(p) && isThereOpponentPiece(p)) {
			mat[p.getRow()][p.getCollumn()] = true;
		}
		
		return mat;
	}

}
