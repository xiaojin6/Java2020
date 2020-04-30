public class SimpleMul {

	private Matrix first;
	private Matrix second;
	private double[][] firstM;
	private double[][] secondM;

	public SimpleMul() {
		// TODO Auto-generated constructor stub
	}

	public SimpleMul(Matrix first, Matrix second, double[][] firstM, double[][] secondM) {
		super();
		this.first = first;
		this.second = second;
		this.firstM = firstM;
		this.secondM = secondM;
	}

	public double[][] simpleMulMethod() {
		Matrix first = this.first;
		Matrix second = this.second;
		double[][] firstM = this.firstM;
		double[][] secondM = this.secondM;

		double startTime = System.currentTimeMillis();
		double[][] result = new double[first.getRow()][second.getCol()];
		for (int i = 0; i < first.getRow(); i++) {
			for (int j = 0; j < second.getCol(); j++) {
				for (int k = 0; k < second.getRow(); k++) {
					result[i][j] += firstM[i][k] * secondM[k][j];
				}
			}
		}
		double endTime = System.currentTimeMillis();
		double time = endTime - startTime;
		System.out.println("串行运行时间：" + time);
		
//		System.out.println("串行运行结果：" + Arrays.deepToString(result));

		return result;
	}

}
