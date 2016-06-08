package easy;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;
import java.util.Scanner;

public class FunnyString {

	public static void main(String[] args) throws IOException {
		InputStream input = FunnyString.class.getClassLoader().getResourceAsStream("config.properties");
		Properties properties = new Properties();
		properties.load(input);
		File file = new File(properties.getProperty("input.path") + "funny_string.txt");
		Scanner in = new Scanner(file);
		int t = in.nextInt();
		for (int i = 0; i < t; i++) {
			String line = in.next();
			boolean f = isFunny(line);
			if (f) {
				System.out.println("Funny");
			} else {
				System.out.println("Not Funny");
			}
		}
		
		in.close();
	}

	private static final boolean isFunny(String line) {
		byte[] bytes = line.getBytes();
		boolean isFunny = true;
		for (int i = 1; i < bytes.length; i++) {
			int abs1 = Math.abs(bytes[i-1] - bytes[i]);
			int abs2 = Math.abs(bytes[bytes.length - i - 1] - bytes[bytes.length - i]);
			if (abs1!=abs2) {
				isFunny = false;
			}
		}
		return isFunny;
	}
	
	
	
}
