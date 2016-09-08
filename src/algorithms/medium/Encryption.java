package algorithms.medium;

import java.io.IOException;
import java.util.Scanner;

public class Encryption {

	public static void main(String[] args) throws IOException {
		// InputStream input =
		// Encryption.class.getClassLoader().getResourceAsStream("config.properties");
		// Properties properties = new Properties();
		// properties.load(input);
		// File file = new File(properties.getProperty("input.path") +
		// "encryption_01.txt");
		// Scanner in = new Scanner(file);
		Scanner in = new Scanner(System.in);
		String s = in.next();
		int strLength = s.length();
		double sqrt = Math.sqrt(strLength);
		int floor = (int) Math.floor(sqrt);
		int ceil = (int) Math.ceil(sqrt);
		int rows = Integer.MAX_VALUE;
		int cols = 1;
		for (int i = floor; i <= ceil; i++) {
			for (int j = i; j <= ceil; j++) {
				if (i * j >= strLength && i * j < rows * cols) {
					rows = i;
					cols = j;
				}
			}
		}
		for (int i = 0; i < cols; i++) {
			for (int j = 0; j < rows; j++) {
				if (cols * j + i < strLength) {
					System.out.print(s.charAt(cols * j + i));
				}
			}
			System.out.print(" ");
		}
		in.close();
	}

}
