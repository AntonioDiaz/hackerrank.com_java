package challenges.java.introduction;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;
import java.util.Scanner;

public class JavaLoops01 {
	public static void main(String[] args) throws IOException {
		InputStream inputStream = JavaLoops01.class.getClassLoader().getResourceAsStream("config.properties");
		Properties properties = new Properties();
		properties.load(inputStream);
		File file = new File(properties.getProperty("input.path") + "java_loops_01.txt");
		Scanner in = new Scanner(file);
		// Scanner in = new Scanner(System.in);
		int n = in.nextInt();
		for (int i = 1; i <= 10; i++) {
			System.out.printf("%d x %d = %d%n", n, i, (n*i));
		}
		in.close();
	}
}