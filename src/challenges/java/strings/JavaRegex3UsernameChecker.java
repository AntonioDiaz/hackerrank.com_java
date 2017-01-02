package challenges.java.strings;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class JavaRegex3UsernameChecker {
	public static void main(String[] args) throws IOException {
		InputStream inputStream = JavaRegex3UsernameChecker.class.getClassLoader().getResourceAsStream("config.properties");
		Properties properties = new Properties();
		properties.load(inputStream);
		File file = new File(properties.getProperty("input.path") + "java_regex3_username_checker.txt");
		Scanner in = new Scanner(file);
		// Scanner in = new Scanner(System.in);
		in.nextLine();
		while (in.hasNext()) {
			String username = in.nextLine();
			System.out.println(username);
			String pattern = "^[a-zA-Z]\\w{7,29}$";
			Pattern r = Pattern.compile(pattern);
			Matcher m = r.matcher(username);
			if (m.find()) {
				System.out.println("Valid");
			} else {
				System.out.println("Invalid");
			}
			System.out.println("");
		}
		in.close();
	}
}