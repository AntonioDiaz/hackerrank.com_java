package challenges.java.datastructures;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;
import java.util.Scanner;


public class JavaList {
	
	private static final String ACTION_INSERT = "Insert";
	private static final String ACTION_DELETE = "Delete";
	
	public static void main(String[] args) throws IOException {
		InputStream inputStream = JavaList.class.getClassLoader().getResourceAsStream("config.properties");
		Properties properties = new Properties();
		properties.load(inputStream);
		File file = new File(properties.getProperty("input.path") + "java_list_challenge.txt");
		Scanner in = new Scanner(file);
		// Scanner in = new Scanner(System.in);
		int elementsNumber = in.nextInt();
		List<Integer> elementsList = new ArrayList<Integer>();
		for (int i = 0; i < elementsNumber; i++) {
			elementsList.add(in.nextInt());
		}
		int operationsNumber = in.nextInt();
		for (int i = 0; i < operationsNumber; i++) {
			String action = in.next();
			if (ACTION_INSERT.equals(action)) {
				int index = in.nextInt();
				int value = in.nextInt();
				elementsList.add(index, value);
			} else  if (ACTION_DELETE.equals(action)) {
				int index = in.nextInt();
				elementsList.remove(index);
			}
		}
		for (Integer value : elementsList) {
			System.out.print(value + " ");
			
		}
		in.close();
	}
}
