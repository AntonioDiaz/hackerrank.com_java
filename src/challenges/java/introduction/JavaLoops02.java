package challenges.java.introduction;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;
import java.util.Scanner;

public class JavaLoops02 {
	public static void main(String[] args) throws IOException {
		InputStream inputStream = JavaLoops02.class.getClassLoader().getResourceAsStream("config.properties");
		Properties properties = new Properties();
		properties.load(inputStream);
		File file = new File(properties.getProperty("input.path") + "java_loops_02.txt");
		Scanner in = new Scanner(file);
		// Scanner in = new Scanner(System.in);
		int q = in.nextInt();
		for (int i = 0; i < q; i++) {
			int a = in.nextInt();
			int b = in.nextInt();
			int n = in.nextInt();
			int prevSum = a;
			for (int j = 0; j < n; j++) {
				prevSum += (int) Math.pow(2, j) * b;
				System.out.print(prevSum + " ");
			}
			System.out.println("");
		}
		in.close();
	}
}
