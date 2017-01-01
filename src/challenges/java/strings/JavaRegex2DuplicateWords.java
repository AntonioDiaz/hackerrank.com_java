package challenges.java.strings;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class JavaRegex2DuplicateWords {
	public static void main(String[] args) throws IOException {
		InputStream inputStream = JavaRegex2DuplicateWords.class.getClassLoader().getResourceAsStream("config.properties");
		Properties properties = new Properties();
		properties.load(inputStream);
		File file = new File(properties.getProperty("input.path") + "java_regex2_duplicate_words.txt");
		Scanner in = new Scanner(file);
		// Scanner in = new Scanner(System.in);

//		String regex = "\\b(\\w+)\\s+\\1\\b";
		String regex = "\\b(\\w+)(\\s+\\1\\b)*";
		Pattern p = Pattern.compile(regex, Pattern.CASE_INSENSITIVE);

		int numSentences = Integer.parseInt(in.nextLine());

		while (numSentences-- > 0) {
			String input = in.nextLine();
//			System.out.println("begin [" + input + "]");
			Matcher m = p.matcher(input);

			// Check for subsequences of input that match the compiled pattern
			while (m.find()) {
//				System.out.println(" m.group() -->" + m.group());
//				System.out.println(" m.group(1) -->" + m.group(1));
				input = input.replaceAll(m.group(), m.group(1));
//				m = p.matcher(input);
//				System.out.println(input);
			}

			// Prints the modified sentence.
			System.out.println("end [" + input + "]");
		}

		in.close();
	}
}