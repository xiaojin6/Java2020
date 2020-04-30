public class firstComMul extends ComMul implements Runnable {

	public firstComMul() {
		// TODO Auto-generated constructor stub
	}

	public firstComMul(Matrix first, Matrix second, double[][] firstM, double[][] secondM) {
		super(first, second, firstM, secondM);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void run() {
		Matrix first = this.getFirst();
		Matrix second = this.getSecond();
		double[][] firstM = this.getFirstM();
		double[][] secondM = this.getSecondM();

		for (int i = 0; i < first.getRow(); i++) {
			if (i % 2 == 1) {
				for (int j = 0; j < second.getCol(); j++) {
					for (int k = 0; k < second.getRow(); k++) {
						ComMul.result[i][j] += firstM[i][k] * secondM[k][j];
					}
				}
			}
		}
	}
}
