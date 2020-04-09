public class Test {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		final String filename = "E:\\Java\\Lab2 Gatsby\\src\\Gatsby.txt";

		final String output = "E:\\Java\\Lab2 Gatsby\\src\\Output.txt";
		Gatsby gat = new Gatsby();
		
		String all = gat.toString(gat.wordsSort(gat.statistics(filename)));
		
		try {
			Gatsby.charOutStream(output, all);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
