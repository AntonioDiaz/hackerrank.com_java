package algorithms.implementation.easy;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;
import java.util.Scanner;

public class GradingStudents {
	public static void main(String[] args) throws IOException {
		InputStream inputStream = GradingStudents.class.getClassLoader().getResourceAsStream("config.properties");
		Properties properties = new Properties();
		properties.load(inputStream);
		File file = new File(properties.getProperty("input.path") + "grading_students.txt");
		Scanner in = new Scanner(file);
		// Scanner in = new Scanner(System.in);
		int elements = in.nextInt();
		for (int i = 0; i < elements; i++) {
			int n = in.nextInt();
			if (n>=38 && (n%5)>2) {
				n = n + (5 - n%5);
			}
			System.out.println(n);
		}
		in.close();
	}
}