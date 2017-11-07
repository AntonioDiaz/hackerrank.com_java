package challenges.java.strings;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;
import java.util.Scanner;
import java.util.regex.Pattern;

public class PatternSyntaxChecker {
	public static void main(String[] args) throws IOException {
		InputStream inputStream = PatternSyntaxChecker.class.getClassLoader().getResourceAsStream("config.properties");
		Properties properties = new Properties();
		properties.load(inputStream);
		File file = new File(properties.getProperty("input.path") + "pattern_syntax_checker.txt");
		Scanner in = new Scanner(file);
		// Scanner in = new Scanner(System.in);
		int testCases = in.nextInt();
		in.nextLine();
		for (int i = 0; i < testCases; i++) {
			String strRegex = in.nextLine();
			try {
				Pattern.compile(strRegex);
				System.out.println("Valid");
			} catch (Exception e) {
				System.out.println("Invalid");
			}
		}
		in.close();
	}
}