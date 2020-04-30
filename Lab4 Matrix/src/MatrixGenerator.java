public class MatrixGenerator {

	private int row;
	private int col;

	public MatrixGenerator() {
		// TODO Auto-generated constructor stub
	}

	public MatrixGenerator(int row, int col) {
		super();
		this.row = row;
		this.col = col;
	}

	public double[][] Create() {
		double[][] create = new double[row][col];
		for (int i = 0; i < row; i++) {
			for (int j = 0; j < col; j++) {
				create[i][j] = (Math.random() * 10);
			}
		}
		return create;
	}
	
	public int getRow() {
		return this.row;
	}
	

	public int getCol() {
		return this.col;
	}

	public void setRow(int row) {
		this.row = row;
	}

	public void setCol(int col) {
		this.col = col;
	}
}
