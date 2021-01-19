package boardgame;

public abstract class Piece {

	protected Position position;
	private Board board;
	
	public Piece() {
		
	}

	public Piece(Board board) {
		this.board = board;
		position = null;
	}

	protected Board getBoard() {
		return board;
	}
	
	public abstract boolean[][] possibleMoves();
	
	//Hook method: M�todo que faz um gancho com a subclasse. Dessa forma, esse m�todo s� ser� chamado pela outra classe que
	//herdar essa classe abstrata.
	//H� um padr�o de projeto chamado Template Method, em que um m�todo concreto utiliza um m�todo abstrato.
	public boolean possibleMove(Position position) {
		return possibleMoves()[position.getRow()][position.getColumn()];
	}
	
	public boolean isThereAnyPossibleMoves() {
		for (int i = 0; i < possibleMoves().length; i++) {
			for (int j = 0; j < possibleMoves().length; j++) {
				if (possibleMoves()[i][j]) 
					return true;
			}
		}
		return false;
	}
}
