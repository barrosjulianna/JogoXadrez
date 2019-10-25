package chess.pieces;

import bordgame.Board;
import bordgame.Position;
import chess.ChessPiece;
import chess.Collor;

//PE�A TORRE
public class Rook extends ChessPiece {

	public Rook(Board board, Collor collor) {
		super(board, collor);

	}

	@Override
	public String toString() {
		return "R";
	}

	@Override
	public boolean[][] possibleMoves() {
		boolean[][] mat = new boolean[getBoard().getRows()][getBoard().getColumns()];
		Position p = new Position(0, 0);
		// verificar acima da pe�a / mesma coluna mas linha muda/above
		p.setValues(position.getRow() - 1, position.getCollumn());
		// enquanto a posi��o p existir n hovuer uma pe�a l�
		while (getBoard().positionExists(p) && !getBoard().thereIsaPiece(p)) {
			// pode mover
			mat[p.getRow()][p.getCollumn()] = true;
			// pode mvoer novamente enquanto exisir casa vazia
			p.setRow(p.getRow() - 1);
		} // testar s existe pa� adversaria, se existir pode andar mais uma pra capturar
		if (getBoard().positionExists(p) && isThereOpponentPiece(p)) {
			mat[p.getRow()][p.getCollumn()] = true;
		}

		// esquerda/left
		p.setValues(position.getRow(), position.getCollumn() - 1);

		while (getBoard().positionExists(p) && !getBoard().thereIsaPiece(p)) {
			// pode mover
			mat[p.getRow()][p.getCollumn()] = true;
			// pode mvoer novamente enquanto exisir casa vazia
			p.setCollumn(p.getCollumn() - 1);
		} // testar s existe pe�a adversaria, se existir pode andar mais uma pra capturar
		if (getBoard().positionExists(p) && isThereOpponentPiece(p)) {
			mat[p.getRow()][p.getCollumn()] = true;
		}
		//direita //right
		p.setValues(position.getRow(), position.getCollumn() + 1);

		while (getBoard().positionExists(p) && !getBoard().thereIsaPiece(p)) {
			// pode mover
			mat[p.getRow()][p.getCollumn()] = true;
			// pode mvoer novamente enquanto exisir casa vazia
			p.setCollumn(p.getCollumn() + 1);
		} // testar s existe pe�a adversaria, se existir pode andar mais uma pra capturar
		if (getBoard().positionExists(p) && isThereOpponentPiece(p)) {
			mat[p.getRow()][p.getCollumn()] = true;
		}
		
		//below PRA BAIXO
		p.setValues(position.getRow() + 1, position.getCollumn());
		// enquanto a posi��o p existir n hovuer uma pe�a l�
		while (getBoard().positionExists(p) && !getBoard().thereIsaPiece(p)) {
			// pode mover
			mat[p.getRow()][p.getCollumn()] = true;
			// pode mvoer novamente enquanto exisir casa vazia
			p.setRow(p.getRow() + 1);
		} // testar s existe pa� adversaria, se existir pode andar mais uma pra capturar
		if (getBoard().positionExists(p) && isThereOpponentPiece(p)) {
			mat[p.getRow()][p.getCollumn()] = true;
		}
		
		return mat;
	}

}
