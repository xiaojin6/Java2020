import java.io.Closeable;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Reader;
import java.io.Writer;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Gatsby {

	public Gatsby() {
		// TODO Auto-generated constructor stub
	}
	
	private String readFromTxt(String filename) throws Exception {
		//从txt文本中读取文件内容，使用buffer配合reader。
		Reader reader = null;
		try {
			StringBuffer buf = new StringBuffer();
			char[] chars = new char[1024];
			reader = new FileReader(filename);
			int readed = reader.read(chars);
			while (readed != -1) {
				buf.append(chars, 0, readed);
				readed = reader.read(chars);
			}
			return buf.toString();
		} finally {
			close(reader);
		}
	}

	private void close(Closeable inout) {
		//关闭reader流
		if (inout != null) {
			try {
				inout.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}

	public Map<String, Integer> statistics(String filename) {
		//用HashMap统计各单词出现的频次
		Map<String, Integer> maps = new HashMap<>();
		String str = null;
		
		try {
			str = readFromTxt(filename);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("从TXT中读入文件错误");
		}
		
		String[] allStr = str.split("[\\s+]");;
		
		for(int i = 0; i < allStr.length; i++) {
			if(allStr[i].length() > 0) {
				if(maps.containsKey(allStr[i])) {
					maps.put(allStr[i], maps.get(allStr[i]) + 1);
				} else {
					maps.put(allStr[i], 1);
				}
			}
		}
		
		return maps;
	}
	
	public List<Map.Entry<String, Integer>> wordsSort(Map<String,Integer> map) {
//	    Map是以Map.Entry<键,值>的形式进行存储 将map装载到list中
		List<Map.Entry<String,Integer>> words = new ArrayList<Map.Entry<String, Integer>>(map.entrySet());

//	    重写sort方法 比较器将两个相邻的list元素按照list中的map的值进行排序 -降序 和冒泡排序相似 返回排序后的结果
		Collections.sort(words, new Comparator<Map.Entry<String, Integer>>() {
			public int compare(Map.Entry<String, Integer> o1, Map.Entry<String, Integer> o2) {
				return (o2.getValue() - o1.getValue());
			}
		});

		return words;
	}
	
	public String toString(List<Map.Entry<String, Integer>> words) {
		String all = "";
		for (int i = 0; i < words.size(); i++) {
			all = all + words.get(i).getKey() + " " +words.get(i).getValue() + "\n";
//			System.out.printf("%.8s %d\n", words.get(i).getKey(), words.get(i).getValue());
		}
		
		return all;
	}
	
	   public static void charOutStream(String filename, String all) throws Exception{
		   // 1：利用File类找到要操作的对象
		   File file = new File(filename);
		   if(!file.getParentFile().exists()){
			   file.getParentFile().mkdirs();
		   }
	            
		   //2：准备输出流
		   Writer out = new FileWriter(file);
		   out.write(all);
		   out.close();
	   }
}
