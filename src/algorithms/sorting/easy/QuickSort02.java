package algorithms.sorting.easy;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;
import java.util.Scanner;

public class QuickSort02 {
	public static void main(String[] args) throws IOException {
		InputStream inputStream = QuickSort02.class.getClassLoader().getResourceAsStream("config.properties");
		Properties properties = new Properties();
		properties.load(inputStream);
		File file = new File(properties.getProperty("input.path") + "quicksort_02.txt");
		Scanner in = new Scanner(file);
		// Scanner in = new Scanner(System.in);
		int elements = in.nextInt();
		List<Integer> list = new ArrayList<Integer>();
		for (int i = 0; i < elements; i++) {
			list.add(in.nextInt());
		}
		in.close();
		list = quickSort(list);
	}

	private static List<Integer> quickSort(List<Integer> list) {
		if (list.size()>0) {
			List<Integer> sortedList = new ArrayList<Integer>();
			List<Integer>[] dividedList = divideList(list);
			Integer pivot = list.get(0);

			if (dividedList[0].size()>0) {
				List<Integer> quickSort = quickSort(dividedList[0]);
				sortedList.addAll(quickSort);
			}
			sortedList.add(pivot);
			if (dividedList[1].size()>0) {
				sortedList.addAll(quickSort(dividedList[1]));
			}
			if (sortedList.size()>1) {
				for (Integer i : sortedList) {
					System.out.print(i + " ");
				}
				System.out.println("");
			}
			return sortedList;	
		}
		return null;
		
	}
	
	private static List<Integer>[] divideList(List<Integer> list) {
		List<Integer> lower = new ArrayList<Integer>();
		List<Integer> bigger = new ArrayList<Integer>();
		Integer pivot = list.get(0);
		for (int i = 1; i < list.size(); i++) {
			Integer e = list.get(i);
			if (e<pivot) {
				lower.add(e);
			} else {
				bigger.add(e);
			}			
		}
		return new List[]{lower, bigger};
	}
	
}