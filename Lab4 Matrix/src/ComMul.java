public class ComMul {

	private Matrix first;
	private Matrix second;
	private double[][] firstM;
	private double[][] secondM;
	static double[][] result = new double[1000][1001];
//	static double[][] result = new double[3][4];

	public ComMul() {
		// TODO Auto-generated constructor stub
	}

	public ComMul(Matrix first, Matrix second, double[][] firstM, double[][] secondM) {
		super();
		this.first = first;
		this.second = second;
		this.firstM = firstM;
		this.secondM = secondM;
	}

	public void ComMulMethod() throws InterruptedException {
		Thread thread1 = new Thread(new firstComMul(first, second, firstM, secondM));
		Thread thread2 = new Thread(new secondComMul(first, second, firstM, secondM));
		double startTime = System.currentTimeMillis();
		thread1.start();
		thread2.start();
		thread1.join();
		thread2.join();
		double endTime = System.currentTimeMillis();
		double time = endTime - startTime;
		System.out.println("并行运行时间：" + time);
	}

	public Matrix getFirst() {
		return first;
	}

	public void setFirst(Matrix first) {
		this.first = first;
	}

	public Matrix getSecond() {
		return second;
	}

	public void setSecond(Matrix second) {
		this.second = second;
	}

	public double[][] getFirstM() {
		return firstM;
	}

	public void setFirstM(double[][] firstM) {
		this.firstM = firstM;
	}

	public double[][] getSecondM() {
		return secondM;
	}

	public void setSecondM(double[][] secondM) {
		this.secondM = secondM;
	}

	public double[][] getResult() {
//		System.out.println("并行执行结果：" + Arrays.deepToString(result));
		return result;
	}
}
