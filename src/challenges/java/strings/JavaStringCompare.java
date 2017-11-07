package challenges.java.strings;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;
import java.util.Scanner;

public class JavaStringCompare {
	public static void main(String[] args) throws IOException {
		InputStream inputStream = JavaStringCompare.class.getClassLoader().getResourceAsStream("config.properties");
		Properties properties = new Properties();
		properties.load(inputStream);
		File file = new File(properties.getProperty("input.path") + "java_string_compare.txt");
		Scanner in = new Scanner(file);
		// Scanner in = new Scanner(System.in);
		String inputStr = in.next();
		int subStrLength = in.nextInt();
		String subStrLargest = inputStr.substring(0, subStrLength);
		String subStrSmallest = inputStr.substring(0, subStrLength);
		for (int i = 0; i <= inputStr.length() - subStrLength; i++) {
			String subStr = inputStr.substring(i, i + subStrLength);
			if (subStr.compareTo(subStrSmallest) < 0) {
				subStrSmallest = subStr;
			}
			if (subStr.compareTo(subStrLargest) > 0) {
				subStrLargest = subStr;
			}
		}
		System.out.println(subStrSmallest);
		System.out.println(subStrLargest);
		in.close();
	}
}