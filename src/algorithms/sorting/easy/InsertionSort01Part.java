package algorithms.sorting.easy;

import java.io.File;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;
import java.util.Scanner;

public class InsertionSort01Part {

	public static void main(String[] args) throws Exception {
		InputStream input = InsertionSort01Part.class.getClassLoader().getResourceAsStream("config.properties");
		Properties properties = new Properties();
		properties.load(input);
		File file = new File(properties.getProperty("input.path") + "insertion_sort_01_part.txt");
		Scanner scanner = new Scanner(file);
		List<Integer> list = new ArrayList<Integer>();
		int s = scanner.nextInt();
		for (int i = 0; i < s; i++) {
			int n = scanner.nextInt();
			list.add(n);
		}
		boolean sorted = false;
		int element = list.get(list.size() - 1);
		int index = list.size() - 2;
		while (!sorted) {
			if (index>=0 && list.get(index) > element) {
				list.set(index + 1, list.get(index));
				index--;
			} else {
				sorted = true;
				list.set(index + 1, element);
			}
			for (Integer integer : list) {
				System.out.print(integer + " ");
			}
			System.out.println("");
		}
		scanner.close();
	}

}
