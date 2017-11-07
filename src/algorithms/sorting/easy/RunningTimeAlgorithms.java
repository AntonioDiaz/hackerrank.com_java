package algorithms.sorting.easy;

/** @author Antonio Diaz */

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;
import java.util.Scanner;

public class RunningTimeAlgorithms {
	public static void main(String[] args) throws IOException {
		InputStream inputStream = RunningTimeAlgorithms.class.getClassLoader().getResourceAsStream("config.properties");
		Properties properties = new Properties();
		properties.load(inputStream);
		File file = new File(properties.getProperty("input.path") + "running_time_algorithms.txt");
		Scanner in = new Scanner(file);
		// Scanner in = new Scanner(System.in);
		List<Integer> list = new ArrayList<Integer>();
		int s = in.nextInt();
		for (int i = 0; i < s; i++) {
			int n = in.nextInt();
			list.add(n);
		}
		int movements = RunningTimeAlgorithms.sortElement(list);
		System.out.println(movements);
		in.close();
	}

	private static int sortElement(List<Integer> list) {
		int count = 0;
		for (int i = 1; i < list.size(); i++) {
			int newIndex = i - 1;
			int oldIndex = i;
			while (newIndex>=0 && list.get(oldIndex)<list.get(newIndex)) {
				int aux = list.get(newIndex);
				list.set(newIndex, list.get(oldIndex));
				list.set(oldIndex, aux);
				oldIndex = newIndex;
				newIndex--;
				count++;
			}
		}
		return count;
	}
}