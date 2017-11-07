package challenges.java.introduction;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;
import java.util.Scanner;

public class JavaEndOfFile {
	public static void main(String[] args) throws IOException {
		InputStream inputStream = JavaEndOfFile.class.getClassLoader().getResourceAsStream("config.properties");
		Properties properties = new Properties();
		properties.load(inputStream);
		File file = new File(properties.getProperty("input.path") + "java_end_of_file.txt");
		Scanner in = new Scanner(file);
		// Scanner in = new Scanner(System.in);
		int cont = 0;
		while (in.hasNextLine()) {
			System.out.println(++cont + " " + in.nextLine());
		}
		in.close();
	}
}
