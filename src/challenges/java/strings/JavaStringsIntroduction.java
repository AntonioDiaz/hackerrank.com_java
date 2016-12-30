package challenges.java.strings;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;
import java.util.Scanner;

public class JavaStringsIntroduction {
	public static void main(String[] args) throws IOException {
		InputStream inputStream = JavaStringsIntroduction.class.getClassLoader().getResourceAsStream("config.properties");
		Properties properties = new Properties();
		properties.load(inputStream);
		File file = new File(properties.getProperty("input.path") + "java_strings_introduction.txt");
		Scanner in = new Scanner(file);
		// Scanner in = new Scanner(System.in);
		String firstStr = in.nextLine();
		String secondStr = in.nextLine();
		System.out.println(firstStr.length() + secondStr.length());
		System.out.println(firstStr.compareTo(secondStr)>0?"Yes":"No");
		System.out.print(Character.toUpperCase(firstStr.charAt(0)) + firstStr.substring(1));
		System.out.println(" " + Character.toUpperCase(secondStr.charAt(0)) + secondStr.substring(1));
		in.close();
	}
}