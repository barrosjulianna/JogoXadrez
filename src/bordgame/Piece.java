package bordgame;

public class Piece {
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

	
	
	
	
}
