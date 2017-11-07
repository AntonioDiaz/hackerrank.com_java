package challenges.java.introduction;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;
import java.util.Scanner;

public class JavaDatatypes {
	public static void main(String[] args) throws IOException {
		InputStream inputStream = JavaDatatypes.class.getClassLoader().getResourceAsStream("config.properties");
		Properties properties = new Properties();
		properties.load(inputStream);
		File file = new File(properties.getProperty("input.path") + "java_datatypes.txt");
		Scanner in = new Scanner(file);
		// Scanner in = new Scanner(System.in);
		int testCases = in.nextInt();
		for (int i = 0; i < testCases; i++) {
			try {
				long l = in.nextLong();
				System.out.println(l + " can be fitted in:");
				if (l >= Byte.MIN_VALUE && l <= Byte.MAX_VALUE) {
					System.out.println("* byte");
				}
				if (l >= Short.MIN_VALUE && l <= Short.MAX_VALUE) {
					System.out.println("* short");
				}
				if (l >= Integer.MIN_VALUE && l <= Integer.MAX_VALUE) {
					System.out.println("* int");
				}
				System.out.println("* long");
			} catch (Exception e) {
				System.out.println(in.next() + " can't be fitted anywhere.");
			}
		}
		in.close();
	}
}