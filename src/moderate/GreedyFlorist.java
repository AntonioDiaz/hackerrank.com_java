package moderate;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Properties;
import java.util.Scanner;

public class GreedyFlorist {

	
	public static void main(String[] args) throws IOException {
		InputStream input = GreedyFlorist.class.getClassLoader().getResourceAsStream("config.properties");
		Properties properties = new Properties();
		properties.load(input);
		File file = new File(properties.getProperty("input.path") + "greedy_florist_01.txt");
		Scanner in = new Scanner(file);
		// Scanner in = new Scanner(System.in);
		int flowers = in.nextInt();
		int people = in.nextInt();
		List<Integer> list = new ArrayList<Integer>();
		for (int i = 0; i < flowers; i++) {
			list.add(in.nextInt());
		}
		
		int sum = 0;
		Collections.sort(list);
		Collections.reverse(list);
		for (int i = 0; i < list.size(); i++) {
			int x = (i/people)+1;
			sum += list.get(i) * x;
		}
		System.out.println(sum);
		
		in.close();
	}
}
