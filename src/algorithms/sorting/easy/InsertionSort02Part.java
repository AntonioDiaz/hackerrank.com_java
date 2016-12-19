package algorithms.sorting.easy;
import java.io.File;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;
import java.util.Scanner;

public class InsertionSort02Part {
    
    
	public static void main(String[] args) throws Exception {
		InputStream input = InsertionSort02Part.class.getClassLoader().getResourceAsStream("config.properties");
		Properties properties = new Properties();
		properties.load(input);
		File file = new File(properties.getProperty("input.path") + "insertion_sort_02_part.txt");
		Scanner scanner = new Scanner(file);
		//Scanner scanner = new Scanner(System.in);
		List<Integer> list = new ArrayList<Integer>();
		int s = scanner.nextInt();
		for (int i = 0; i < s; i++) {
			int n = scanner.nextInt();
			list.add(n);
		}
		for (int i=2; i<list.size() + 1; i++) {
			list = sortElement(list, i);
			InsertionSort02Part.printList(list);
		}
		scanner.close();
	}

	private static void printList(List<Integer> list) {
		for (Integer integer : list) {
			System.out.print(integer + " ");
		}
		System.out.println("");		
	}

	private static List<Integer> sortElement(List<Integer> list, int mySize) {
		boolean sorted = false;
		int element = list.get(mySize - 1);
		int index = mySize - 2;
		while (!sorted) {
			if (index>=0 && list.get(index) > element) {
				list.set(index + 1, list.get(index));
				index--;
			} else {
				sorted = true;
				list.set(index + 1, element);
			}
		}
		return list;
	}
}