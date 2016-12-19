package algorithms.implementation.easy;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;
import java.util.Scanner;

public class CamelCase {

	public static void main(String[] args) throws IOException {
		InputStream input = CamelCase.class.getClassLoader().getResourceAsStream("config.properties");
		Properties properties = new Properties();
		properties.load(input);
		File file = new File(properties.getProperty("input.path") + "camel_case.txt");
		Scanner in = new Scanner(file);
		// Scanner in = new Scanner(System.in);
		String word = in.next();
		byte[] bytes = word.getBytes();
		int wordsCount = 1;
		for (byte b : bytes) {
			if (b>=65 && b<=90) {
				wordsCount++;
			}
		}
		System.out.println(wordsCount);
		in.close();
	}
}
