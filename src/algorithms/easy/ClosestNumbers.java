package algorithms.easy;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Properties;
import java.util.Scanner;

public class ClosestNumbers {

	public static void main(String[] args) throws IOException {
		InputStream input = ClosestNumbers.class.getClassLoader().getResourceAsStream("config.properties");
		Properties properties = new Properties();
		properties.load(input);
		File file = new File(properties.getProperty("input.path") + "closest_numbers_02.txt");
		Scanner in = new Scanner(file);
		// Scanner in = new Scanner(System.in);
		int n = in.nextInt();
		List<Integer> list = new ArrayList<Integer>();
		for (int i = 0; i < n; i++) {
			list.add(in.nextInt());
		}
		Collections.sort(list);
		List<Integer> listPairs = new ArrayList<Integer>();
		Integer minDiff = Integer.MAX_VALUE;
		for (int i = 1; i < n; i++) {
			int d = Math.abs(list.get(i) - list.get(i - 1));
			if (d <= minDiff) {
				if (d<minDiff) {
					listPairs = new ArrayList<Integer>();
				}
				minDiff = d;
				listPairs.add(i);
			}
		}
		for (Integer i : listPairs) {
			System.out.print(list.get(i-1) + " " + list.get(i) + " ");
		}
		in.close();
	}
}
