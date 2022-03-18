package boardgame;

public class Position {
	private int row;
	private int collun;
	public Position(int row, int collun) {
		this.row = row;
		this.collun = collun;
	}
	public int getRow() {
		return row;
	}
	public void setRow(int row) {
		this.row = row;
	}
	public int getCollun() {
		return collun;
	}
	public void setCollun(int collun) {
		this.collun = collun;
	}
	
	@Override
	public String toString() {
		return row + ", " + collun; 
	}

}
