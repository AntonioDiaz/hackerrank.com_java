package algorithms.sorting.easy;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;
import java.util.Scanner;

public class CountingSort01 {
	
	private static int VALUES_RANGE = 100; 
	
	public static void main(String[] args) throws IOException {
		InputStream inputStream = CountingSort01.class.getClassLoader().getResourceAsStream("config.properties");
		Properties properties = new Properties();
		properties.load(inputStream);
		File file = new File(properties.getProperty("input.path") + "counting_sort_01.txt");
		Scanner in = new Scanner(file);
		// Scanner in = new Scanner(System.in);
		List<Integer> countingList = new ArrayList<Integer>(VALUES_RANGE);
		for (int i = 0; i < VALUES_RANGE; i++) {
			countingList.add(0);
		}
		int elements = in.nextInt();
		for (int i = 0; i < elements; i++) {
			int n = in.nextInt();
			countingList.set(n, countingList.get(n) + 1);
		}
		for (int i = 0; i < VALUES_RANGE; i++) {
			System.out.print(countingList.get(i) + " ");
		}
		in.close();
	}
}