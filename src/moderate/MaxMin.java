package moderate;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Properties;
import java.util.Scanner;

public class MaxMin {

	
	public static void main(String[] args) throws IOException {
		InputStream input = MaxMin.class.getClassLoader().getResourceAsStream("config.properties");
		Properties properties = new Properties();
		properties.load(input);
		File file = new File(properties.getProperty("input.path") + "max_min_03.txt");
		Scanner in = new Scanner(file);
		// Scanner in = new Scanner(System.in);
		int n = in.nextInt();
		int k = in.nextInt();
		List<Integer> list = new ArrayList<Integer>();
		for (int i = 0; i < n; i++) {
			list.add(in.nextInt());
		}
		Collections.sort(list);
		int result = Integer.MAX_VALUE;
		for (int i = 0; i <= list.size() -k; i++) {
			int diff = list.get(i+k-1) - list.get(i);
			if (diff<result) {
				result = diff;
			}
		}
		System.out.println(result);
		in.close();
	}
	
	
	
}
