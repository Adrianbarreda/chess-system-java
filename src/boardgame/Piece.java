package boardgame;

public class Piece {
	
	protected Position position;
	private Board board;
	
	public Piece(Board board) {		
		this.board = board;
		position = null; // The JAVA pattern already assigns the null value
	}

	protected Board getBoard() {
		return board;
	}
	
}
