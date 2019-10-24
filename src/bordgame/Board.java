package bordgame;

public class Board {
	private int rows; //linhas
	private int columns;
	private Piece[][] pieces; //matriz de pe�as
	
	public Board(int rows, int columns) {
		if(rows<1 || columns<1) {
			throw new BoardException("Error creating board: there must be at least 1 row and 1 columns.");
		}
		this.rows = rows;
		this.columns = columns;
		pieces = new Piece[rows][columns]; //as pe�as vao ser criadas conforme as linhas e colunas
	}

	public int getRows() {
		return rows;
	}

	public int getColumns() {
		return columns;
	}
		
	public Piece piece (int row, int column) {
		if(!positionExists(row,column)) {
			throw new BoardException("Position not on the board");
		}
		return pieces[row][column];
	}
	//sobrecarga
	//retornar pela posi��o
	
	public Piece piece(Position position) {
		if(!positionExists(position)) {
			throw new BoardException("Position not on the board");
		}
		return pieces[position.getRow()][position.getCollumn()];
	}
	
	
	public void placePiece(Piece piece, Position position) {
		//TESTAR SE JA TEM PE�A NA POSI��O
		if(thereIsaPiece(position)) {
			throw new BoardException("The is alredy a piece on position "+ position);
		}
		//pegar a matriz na posi��o dada e atribuir a pe�a a posi��o dada
		//colocar a pe�a em uma posi��o
		pieces[position.getRow()][position.getCollumn()]=piece;
		piece.position=position;
	}
	public Piece removePiece(Position position) {
		if(!positionExists(position)) {
			throw new BoardException("Position not on the board");
		}//n tem pe�a na posi��o
		if(piece(position)==null) {
			return null;
		}
		Piece aux= piece(position);
		aux.position=null; 
		pieces[position.getRow()][position.getCollumn()]= null;//n tem mais pe�a na psi��o
		return aux;
	}
	
	
	//VERIFICA SE A POSI��O EXISTE OU N�O
	private boolean positionExists(int row, int column) {
		return row>=0 && row<rows && column>=0 && column<columns;
	}
	
	public boolean positionExists(Position position) {
		return positionExists(position.getRow(),position.getCollumn());
	}
	//VERIFICA SE NA POSI��O EXISTE UMA PE�A
	public boolean thereIsaPiece(Position position) {
		if(!positionExists(position)) {
			throw new BoardException("Position not on the board");
		}
		return piece(position) !=null; //tem pe�a na posi��o
	}
	
	
}
