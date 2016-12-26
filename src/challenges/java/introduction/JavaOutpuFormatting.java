package challenges.java.introduction;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;
import java.util.Scanner;

public class JavaOutpuFormatting {
	public static void main(String[] args) throws IOException {
		InputStream inputStream = JavaOutpuFormatting.class.getClassLoader().getResourceAsStream("config.properties");
		Properties properties = new Properties();
		properties.load(inputStream);
		File file = new File(properties.getProperty("input.path") + "java_output_formatting.txt");
		Scanner in = new Scanner(file);
		// Scanner in = new Scanner(System.in);
		System.out.println("================================");
		for (int i = 0; i < 3; i++) {
			String s1 = in.next();
			int x = in.nextInt();
			System.out.printf("%-15s%03d%n", s1, x);
		}
		System.out.println("================================");
		in.close();
	}
}
