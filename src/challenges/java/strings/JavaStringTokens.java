package challenges.java.strings;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class JavaStringTokens {

	public static void main(String[] args) throws IOException {
		InputStream inputStream = JavaStringTokens.class.getClassLoader().getResourceAsStream("config.properties");
		Properties properties = new Properties();
		properties.load(inputStream);
		File file = new File(properties.getProperty("input.path") + "java_string_tokens_01.txt");
		Scanner in = new Scanner(file);
		// Scanner in = new Scanner(System.in);
		String input = in.nextLine();
		Pattern patternLetters = Pattern.compile("[a-zB-Z]+");
		Matcher matcherLetters = patternLetters.matcher(input);
		int count =0;
		while (matcherLetters.find()) {
			count ++;
		}
		System.out.println(count);
		matcherLetters = patternLetters.matcher(input);
		while (matcherLetters.find()) {
			System.out.println(matcherLetters.group());
		}
		in.close();
	}

}
