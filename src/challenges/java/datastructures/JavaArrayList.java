package challenges.java.datastructures;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;
import java.util.Scanner;

public class JavaArrayList {
	private static final String ERROR = "ERROR!";

	public static void main(String[] args) throws IOException {
		InputStream inputStream = JavaArrayList.class.getClassLoader().getResourceAsStream("config.properties");
		Properties properties = new Properties();
		properties.load(inputStream);
		File file = new File(properties.getProperty("input.path") + "java_arraylist.txt");
		Scanner in = new Scanner(file);
		// Scanner in = new Scanner(System.in);
		int numberOfList = in.nextInt();
		List<List<Integer>> listOfList = new ArrayList<List<Integer>>();
		for (int i = 0; i < numberOfList; i++) {
			int numberOfElements = in.nextInt();
			List<Integer> elements = new ArrayList<>();
			for (int j = 0; j < numberOfElements; j++) {
				elements.add(in.nextInt());
			}
			listOfList.add(elements);			
		}
		int numberOfQueries = in.nextInt();
		for (int i = 0; i < numberOfQueries; i++) {
			int queryList = in.nextInt() - 1;
			int queryIndex = in.nextInt() - 1;
			if (listOfList.size()>queryList && listOfList.get(queryList).size()>queryIndex) {
				System.out.println(listOfList.get(queryList).get(queryIndex));
			} else {
				System.out.println(ERROR);
			}
		}
		in.close();
	}
}