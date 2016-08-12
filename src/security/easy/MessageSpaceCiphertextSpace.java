package security.easy;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;
import java.util.Scanner;

public class MessageSpaceCiphertextSpace {
	public static void main(String[] args) throws IOException {
		InputStream input = MessageSpaceCiphertextSpace.class.getClassLoader().getResourceAsStream("config.properties");
		Properties properties = new Properties();
		properties.load(input);
		File file = new File(properties.getProperty("input.path") + "message_space_ciphertext_space.txt");
		Scanner in = new Scanner(file);
		// Scanner in = new Scanner(System.in);
		String m = in.next();
		byte[] bytes = m.getBytes();
		for (byte b : bytes) {
			System.out.print((Character.getNumericValue(b) + 1) % 10);
		}
		in.close();
	}
}
