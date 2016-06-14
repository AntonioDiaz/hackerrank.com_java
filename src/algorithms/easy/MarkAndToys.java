package algorithms.easy;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Properties;
import java.util.Scanner;

import moderate.BreadthFirstSearch;

public class MarkAndToys {

	public static void main(String[] args) throws IOException {
		InputStream input = BreadthFirstSearch.class.getClassLoader().getResourceAsStream("config.properties");
		Properties properties = new Properties();
		properties.load(input);
		File file = new File(properties.getProperty("input.path") + "mark_and_toys.txt");
		Scanner in = new Scanner(file);
		// Scanner in = new Scanner(System.in);
		int n = in.nextInt();
		long k = in.nextLong();
		List<Long> list = new ArrayList<Long>();
		for (int i = 0; i < n; i++) {
			list.add(in.nextLong());
		}
		Collections.sort(list);
		Long sum = 0l;
		Integer cont = 0;
		for (int i = 0; i < n; i++) {
			if (sum + list.get(i) <= k) {
				cont++;
				sum += list.get(i);
			}
		}
		System.out.println(cont);
		in.close();
	}
}
