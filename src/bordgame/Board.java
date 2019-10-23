package bordgame;

public class Board {
	private int rows; //linhas
	private int columns;
	private Piece[][] pieces; //matriz de peças
	
	public Board(int rows, int columns) {
		this.rows = rows;
		this.columns = columns;
		pieces = new Piece[rows][columns]; //as peças vao ser criadas conforme as linhas e colunas
	}

	public int getRows() {
		return rows;
	}

	public void setRows(int rows) {
		this.rows = rows;
	}

	public int getColumns() {
		return columns;
	}

	public void setColumns(int columns) {
		this.columns = columns;
	}
	
	
	public Piece piece (int row, int column) {
		return pieces[row][column];
	}
	//sobrecarga
	//retornar pela posição
	public Piece piece(Position position) {
		return pieces[position.getRow()][position.getCollumn()];
	}
	
	
}
