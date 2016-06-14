package algorithms.moderate;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Properties;
import java.util.Scanner;
import java.util.Set;

public class Pairs {

	public static void main(String[] args) throws IOException {
		InputStream input = Pairs.class.getClassLoader().getResourceAsStream("config.properties");
		Properties properties = new Properties();
		properties.load(input);
		File file = new File(properties.getProperty("input.path") + "pairs_01.txt");
		Scanner in = new Scanner(file);
		// Scanner in = new Scanner(System.in);
		int n = in.nextInt();
		int k = in.nextInt();
		List<Integer> list = new ArrayList<Integer>();
		Set<Integer> set = new HashSet<Integer>();
		for (int i = 0; i < n; i++) {
			int myK = in.nextInt();
			list.add(myK);
			set.add(myK);
		}
		int cont = 0;
		for (Integer i : list) {
			if (set.contains(i-k)){
				cont++;
			}
		}
		System.out.println(cont);
		
		in.close();
	}
	
}
