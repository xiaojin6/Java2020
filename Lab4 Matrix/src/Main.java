import java.util.Arrays;

public class Main {

	public static void main(String[] args) {

		MatrixGenerator first = new MatrixGenerator(2000, 2002);
		double[][] firstM = first.Create();
		MatrixGenerator second = new MatrixGenerator(2002, 2001);
		double[][] secondM = second.Create();
		
//		Matrix first = new Matrix(3, 5);
//		double[][] firstM = first.Create();
//		Matrix second = new Matrix(5, 4);
//		double[][] secondM = second.Create();

		SimpleMul simple1 = new SimpleMul(first, second, firstM, secondM);
		double[][] result1 = simple1.simpleMulMethod();

		ComMul com1 = new ComMul(first, second, firstM, secondM);
		try {
			com1.ComMulMethod();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		double[][] result2 = com1.getResult();

		assert Arrays.deepEquals(result1, result2);
		System.out.println("result1 == result2");
	}
}
