package algorithms.implementation.easy;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;
import java.util.Scanner;
import java.util.Set;

public class EqualizeTheArray {
	public static void main(String[] args) throws IOException {
		InputStream inputStream = EqualizeTheArray.class.getClassLoader().getResourceAsStream("config.properties");
		Properties properties = new Properties();
		properties.load(inputStream);
		File file = new File(properties.getProperty("input.path") + "equalize_the_array.txt");
		Scanner in = new Scanner(file);
		// Scanner in = new Scanner(System.in);
		int numOfElements = in.nextInt();
		Map<Integer, Integer> elementsCount = new HashMap<Integer, Integer>();
		for (int i = 0; i < numOfElements; i++) {
			int num = in.nextInt();
			if (elementsCount.get(num) == null) {
				elementsCount.put(num, 0);				
			}
			elementsCount.put(num, elementsCount.get(num)+1);
		}
		Set<Integer> keySet = elementsCount.keySet();
		int mostRepeatedCount = 0;
		for (Integer keyNum : keySet) {
			if (elementsCount.get(keyNum)>mostRepeatedCount) {
				mostRepeatedCount = elementsCount.get(keyNum);
			}
		}
		in.close();
		System.out.println(numOfElements - mostRepeatedCount);
	}
}