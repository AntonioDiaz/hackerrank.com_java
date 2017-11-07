package algorithms.sorting.easy;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;
import java.util.Scanner;

public class QuickSort01 {
	public static void main(String[] args) throws IOException {
		InputStream inputStream = QuickSort01.class.getClassLoader().getResourceAsStream("config.properties");
		Properties properties = new Properties();
		properties.load(inputStream);
		File file = new File(properties.getProperty("input.path") + "quicksort_01.txt");
		Scanner in = new Scanner(file);
		// Scanner in = new Scanner(System.in);
		int elements = in.nextInt();
		int pivot = in.nextInt();
		List<Integer> biggers = new ArrayList<Integer>();
		for (int i = 0; i < elements - 1; i++) {
			int n = in.nextInt();			
			if (n < pivot) {
				System.out.print(n + " ");	
			} else if (n>pivot) {
				biggers.add(n);
			}
		}
		System.out.print(pivot + " ");
		for (Integer integer : biggers) {
			System.out.print(integer + " ");
		}
		in.close();
	}
}