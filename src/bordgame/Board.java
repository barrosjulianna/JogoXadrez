package bordgame;

public class Board {
	private int rows; //linhas
	private int columns;
	private Piece[][] pieces; //matriz de peças
	
	public Board(int rows, int columns) {
		if(rows<1 || columns<1) {
			throw new BoardException("Error creating board: there must be at least 1 row and 1 columns.");
		}
		this.rows = rows;
		this.columns = columns;
		pieces = new Piece[rows][columns]; //as peças vao ser criadas conforme as linhas e colunas
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
	//retornar pela posição
	
	public Piece piece(Position position) {
		if(!positionExists(position)) {
			throw new BoardException("Position not on the board");
		}
		return pieces[position.getRow()][position.getCollumn()];
	}
	
	
	public void placePiece(Piece piece, Position position) {
		//TESTAR SE JA TEM PEÇA NA POSIÇÃO
		if(thereIsaPiece(position)) {
			throw new BoardException("The is alredy a piece on position "+ position);
		}
		//pegar a matriz na posição dada e atribuir a peça a posição dada
		//colocar a peça em uma posição
		pieces[position.getRow()][position.getCollumn()]=piece;
		piece.position=position;
	}
	public Piece removePiece(Position position) {
		if(!positionExists(position)) {
			throw new BoardException("Position not on the board");
		}//n tem peça na posição
		if(piece(position)==null) {
			return null;
		}
		Piece aux= piece(position);
		aux.position=null; 
		pieces[position.getRow()][position.getCollumn()]= null;//n tem mais peça na psição
		return aux;
	}
	
	
	//VERIFICA SE A POSIÇÃO EXISTE OU NÃO
	private boolean positionExists(int row, int column) {
		return row>=0 && row<rows && column>=0 && column<columns;
	}
	
	public boolean positionExists(Position position) {
		return positionExists(position.getRow(),position.getCollumn());
	}
	//VERIFICA SE NA POSIÇÃO EXISTE UMA PEÇA
	public boolean thereIsaPiece(Position position) {
		if(!positionExists(position)) {
			throw new BoardException("Position not on the board");
		}
		return piece(position) !=null; //tem peça na posição
	}
	
	
}
