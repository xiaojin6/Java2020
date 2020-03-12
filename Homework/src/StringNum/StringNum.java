package StringNum;
import java.util.*;

public class StringNum {

	public StringNum() {
		// TODO Auto-generated constructor stub
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Map<String, Integer> maps = new HashMap<>();
		
		for(int i = 0; i < args.length; i++) {
			if(maps.containsKey(args[i])) {
				maps.put(args[i], maps.get(args[i]) + 1);
			} else {
				maps.put(args[i], 1);
			}
		}
		
		System.out.println(maps);
	}

}
