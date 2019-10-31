package chess.pieces;

import bordgame.Board;
import bordgame.Position;
import chess.ChessPiece;
import chess.Collor;

public class Pawn extends ChessPiece{

	public Pawn(Board board, Collor collor) {
		super(board, collor);
		// TODO Auto-generated constructor stub
	}

	@Override
	public boolean[][] possibleMoves() {
		boolean[][] mat = new boolean[getBoard().getRows()][getBoard().getColumns()];
		Position p = new Position(0, 0);
		
		if(getCollor() ==Collor.WHITE) {
			//andar pra cima -1
			p.setValues(position.getRow() -1, position.getCollumn());
			//se existir						//tiver vazia
			if(getBoard().positionExists(p)&& !getBoard().thereIsaPiece(p)) {
			mat[p.getRow()][p.getCollumn()]=true;
			}
			p.setValues(position.getRow() -2, position.getCollumn());				//se for o primeiro movimento
			Position p2= new Position(position.getRow() -1, position.getCollumn());
			if(getBoard().positionExists(p)&& !getBoard().thereIsaPiece(p)&& getBoard().positionExists(p2)&& !getBoard().thereIsaPiece(p2) && getMoveCount()==0) {
			mat[p.getRow()][p.getCollumn()]=true;
			}
			p.setValues(position.getRow() -1, position.getCollumn()-1 );	
			//se posição existe e se tem uma peça adversaria lá
			if(getBoard().positionExists(p)&& isThereOpponentPiece(p)) {
			mat[p.getRow()][p.getCollumn()]=true;
			}
			p.setValues(position.getRow() -1, position.getCollumn()+1 );	
			//se posição existe e se tem uma peça adversaria lá
			if(getBoard().positionExists(p)&& isThereOpponentPiece(p)) {
			mat[p.getRow()][p.getCollumn()]=true;
			}
			
			
		}
		else { //peça preta
			p.setValues(position.getRow() +1, position.getCollumn());					
			if(getBoard().positionExists(p)&& !getBoard().thereIsaPiece(p)) {
			mat[p.getRow()][p.getCollumn()]=true;
			}
			p.setValues(position.getRow() +2, position.getCollumn());				
			Position p2= new Position(position.getRow() -1, position.getCollumn());
			if(getBoard().positionExists(p)&& !getBoard().thereIsaPiece(p)&& getBoard().positionExists(p2)&& !getBoard().thereIsaPiece(p2) && getMoveCount()==0) {
			mat[p.getRow()][p.getCollumn()]=true;
			}
			p.setValues(position.getRow() +1, position.getCollumn()-1 );	
			if(getBoard().positionExists(p)&& isThereOpponentPiece(p)) {
			mat[p.getRow()][p.getCollumn()]=true;
			}
			p.setValues(position.getRow() +1, position.getCollumn()+1 );	
			if(getBoard().positionExists(p)&& isThereOpponentPiece(p)) {
			mat[p.getRow()][p.getCollumn()]=true;
			}
		}
		
		
		return mat;
	}
//LOGICAS POSSIVEIS DO PEAO
	
	
	@Override
	public String toString() {
		return "P";
	}
	
}
