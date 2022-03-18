package boardgame;

public class Board {

	private int rows;
	private int columns;
	private Piece[][] pieces;

	public Board(int rows, int columns) {
		if (rows < 1 || columns < 1) {
			throw new BoardException("ERRO AO CRIAR TABULEIRO: É necessário que tenha pelo menos 1 linha e 1 coluna");
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
			throw new BoardException("Posição fora do tabuleiro");
		}
		return pieces[row][column];
	}

	public Piece piece(Position position) {
		if (!positionExists(position)) {
			throw new  BoardException("Posição fora do tabuleiro");
		}
		return pieces[position.getRow()][position.getCollumn()];
	}

	public void placePiece(Piece piece, Position position) {
		if (thereIsApiece(position)) {
			throw new  BoardException("Já contém peça nessa posição");
		}
		pieces[position.getRow()][position.getCollumn()] = piece;
		piece.position = position;	
	}

	private boolean positionExists(int row, int column) {
		return row >= 0 && row < rows && column >= 0 && column < columns;
	}

	public boolean positionExists(Position position) {
		return positionExists(position.getRow(), position.getCollumn());
	}

	public boolean thereIsApiece(Position position) {
		if (!positionExists(position)) {
			throw new  BoardException("Posição fora do tabuleiro");
		}
		return piece(position) != null;
	}

}
