package bordgame;

public abstract class Piece {
	// protected pra n ser visivel na camada de xadrez (somente od mesmo pacote pode acessa)
	// posi��o de matriz

	protected Position position;
	// associa��o da pe�a com o tabuleiro
	private Board board;
	
	public Piece(Board board) {
		
		this.board = board;
		position =null;
	}

	protected Board getBoard() {
		return board;
	}
	
	public abstract boolean[][] possibleMoves ();
	//� POSSIVEL A PE�A MOVER RA POSI��O?
	public boolean possibleMove(Position position) {
		return possibleMoves()[position.getRow()][position.getCollumn()];
	}
	
	//existe um movimento valido pra pe�a?
	public boolean isThereAnyPossibleMove() {
		boolean[][]mat=possibleMoves();
		for(int i=0;i<mat.length;i++) {
			for (int j=0;j<mat.length;j++) {
				if(mat[i][j]) {
					return true;
				}
			}
		}return false;
	}
	
	
	
	
}
