package challenges.java.strings;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;
import java.util.Scanner;

public class JavaStringReverse {
	public static void main(String[] args) throws IOException {
		InputStream inputStream = JavaStringReverse.class.getClassLoader().getResourceAsStream("config.properties");
		Properties properties = new Properties();
		properties.load(inputStream);
		File file = new File(properties.getProperty("input.path") + "java_string_reverse.txt");
		Scanner in = new Scanner(file);
		// Scanner in = new Scanner(System.in);
		String possiblePalindrome = in.next();
		System.out.println(possiblePalindrome.length() / 2);
		boolean isPalindrome = true;
		for (int i = 0; i < possiblePalindrome.length() / 2; i++) {
			if (possiblePalindrome.charAt(i) != possiblePalindrome.charAt(possiblePalindrome.length() - 1 - i)) {
				isPalindrome = false;
			}
		}
		System.out.println(isPalindrome?"Yes":"No");
		in.close();
	}
}