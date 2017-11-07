package security.easy;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;
import java.util.Scanner;

public class SecurityKeySpaces {
	public static void main(String[] args) throws IOException {
		InputStream input = SecurityKeySpaces.class.getClassLoader().getResourceAsStream("config.properties");
		Properties properties = new Properties();
		properties.load(input);
		File file = new File(properties.getProperty("input.path") + "security_key_spaces.txt");
		Scanner in = new Scanner(file);
		// Scanner in = new Scanner(System.in);
		String m = in.next();
		int e = in.nextInt();
		byte[] bytes = m.getBytes();
		for (byte b : bytes) {
			System.out.print((Character.getNumericValue(b) + e) % 10);
		}
		in.close();
	}
}
