package bordgame;

public class Piece {
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

	
	
	
	
}
