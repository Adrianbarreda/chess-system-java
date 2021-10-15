package boardgame;

public class Board {
	
	private int rows;
	private int columns;
	private Piece[][] pieces;
	
	public Board(int rows, int columns) {
		if (rows < 1 || columns < 1) {
			throw new BoardException("Error creating board: there must be at least 1 row and 1 column");
		}
		this.rows = rows;
		this.columns = columns;
		pieces = new Piece[rows][columns];
	}

	public int getRows() {
		return rows;
	}

	public int getColumns() {
		return columns;
	}
	
	public Piece piece(int row, int column) {
		if (!positionExists(row, column)) {
			throw new BoardException("Position not on the board");
		}
		return pieces[row][column]; // return the matrix pieces in line "row" and column "column".
	}
	
	public Piece piece(Position position) { // doing overrider in "public Piece piece" method "retorna a pieza pela posição"
		if (!positionExists(position)) {
			throw new BoardException("Position not on the board");
		}
		return pieces[position.getRow()][position.getColumn()];
	}
	
	public void placePiece(Piece piece, Position position) {
		if (thereIsAPiece(position)) {
			throw new BoardException("There is already a piece on position " + position);
		}
		pieces[position.getRow()][position.getColumn()] = piece;
		piece.position = position;
	}
	
	public Piece removePiece(Position position) {
		//Defensive Programming
		if (!positionExists(position)) { 
			throw new BoardException("Position not on the board");
		}		
		if(piece(position) == null) {
			return null;
		} //Not Piece in this position
		Piece aux = piece(position);// "Auxiliary variable" receive the piece on the board in that position
		aux.position = null; // remove the piece from the board 
		pieces[position.getRow()][position.getColumn()] = null; //Not more position IN THE MATRIX
		return aux;
	}
	
	public boolean positionExists(int row, int column) {
		return row >= 0 && row < rows && column >= 0 && column < columns;
	}
	
	public boolean positionExists(Position position) {
		return positionExists(position.getRow(), position.getColumn());
	}
	
	public boolean thereIsAPiece(Position position) {
		if (!positionExists(position)) {
			throw new BoardException("Position not on the board");
		}
		return piece(position) != null;
	}
}
