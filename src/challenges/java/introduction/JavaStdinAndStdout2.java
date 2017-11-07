package challenges.java.introduction;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.util.Locale;
import java.util.Properties;
import java.util.Scanner;

public class JavaStdinAndStdout2 {
	public static void main(String[] args) throws IOException {
		InputStream inputStream = JavaStdinAndStdout2.class.getClassLoader().getResourceAsStream("config.properties");
		Properties properties = new Properties();
		properties.load(inputStream);
		File file = new File(properties.getProperty("input.path") + "stdin_and_stdout_2.txt");
		Scanner in = new Scanner(file);
		in.useLocale(Locale.US);
		int i = in.nextInt();
		double d = in.nextDouble();
		in.nextLine();
		String s = in.nextLine();
		System.out.println("String: " + s);
		System.out.println("Double: " + d);
		System.out.println("Int: " + i);
		in.close();
	}
}
