package bordgame;

public abstract class Piece {
	// protected pra n ser visivel na camada de xadrez (somente od mesmo pacote pode acessa)
	// posição de matriz

	protected Position position;
	// associação da peça com o tabuleiro
	private Board board;
	
	public Piece(Board board) {
		
		this.board = board;
		position =null;
	}

	protected Board getBoard() {
		return board;
	}
	
	public abstract boolean[][] possibleMoves ();
	//É POSSIVEL A PEÇA MOVER RA POSIÇÃO?
	public boolean possibleMove(Position position) {
		return possibleMoves()[position.getRow()][position.getCollumn()];
	}
	
	//existe um movimento valido pra peça?
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
