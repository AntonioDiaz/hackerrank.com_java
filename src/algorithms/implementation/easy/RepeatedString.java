package algorithms.implementation.easy;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;
import java.util.Scanner;

public class RepeatedString {

	public static void main(String[] args) throws IOException {
		InputStream inputStream = RepeatedString.class.getClassLoader().getResourceAsStream("config.properties");
		Properties properties = new Properties();
		properties.load(inputStream);
		File file = new File(properties.getProperty("input.path") + "repeated_string.txt");
		Scanner in = new Scanner(file);
		// Scanner in = new Scanner(System.in);
		String word = in.nextLine();
		long letters = in.nextLong();
		long fullWords = letters / word.length();
		long lastWordLength = letters % word.length();
		int aesInWord = 0;
		int aesInLastWord = 0;
		for (int i = 0; i < word.length(); i++) {
			if (word.charAt(i) == 'a') {
				aesInWord++;
				if (i < lastWordLength) {
					aesInLastWord++;
				}
			}
		}
		System.out.println(aesInWord * fullWords + aesInLastWord);
		in.close();
	}
}
