package security.easy;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;
import java.util.Scanner;

public class SecurityEncryptionScheme {
	public static void main(String[] args) throws IOException {
		InputStream input = SecurityEncryptionScheme.class.getClassLoader().getResourceAsStream("config.properties");
		Properties properties = new Properties();
		properties.load(input);
		File file = new File(properties.getProperty("input.path") + "security_encryption_scheme.txt");
		Scanner in = new Scanner(file);
		// Scanner in = new Scanner(System.in);
		int e = in.nextInt();
		int result = 1;
		for (int i = 1; i <= e; i++) {
			result *= i;
		}
		System.out.println(result);
		in.close();
	}
}
