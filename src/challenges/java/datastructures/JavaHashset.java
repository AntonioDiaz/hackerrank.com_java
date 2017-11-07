package challenges.java.datastructures;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.util.HashSet;
import java.util.Properties;
import java.util.Scanner;
import java.util.Set;

public class JavaHashset {
	public static void main(String[] args) throws IOException {
		InputStream inputStream = JavaHashset.class.getClassLoader().getResourceAsStream("config.properties");
		Properties properties = new Properties();
		properties.load(inputStream);
		File file = new File(properties.getProperty("input.path") + "java_hashset.txt");
		Scanner in = new Scanner(file);
		// Scanner in = new Scanner(System.in);
		int t = in.nextInt();
		String[] pair_left = new String[t];
		String[] pair_right = new String[t];

		for (int i = 0; i < t; i++) {
			pair_left[i] = in.next();
			pair_right[i] = in.next();
		}
		Set<String> set = new HashSet<String>();
		for (int i = 0; i < t; i++) {
			set.add(pair_left[i] + pair_left[i].length()+ pair_right[i] + pair_right[i].length());
			System.out.println(set.size());
		}
		
		in.close();
	}
}