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
	
	//Hook method: Método que faz um gancho com a subclasse. Dessa forma, esse método só será chamado pela outra classe que
	//herdar essa classe abstrata.
	//Há um padrão de projeto chamado Template Method, em que um método concreto utiliza um método abstrato.
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
