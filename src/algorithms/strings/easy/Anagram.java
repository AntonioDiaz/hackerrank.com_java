package algorithms.strings.easy;

/** @author Antonio Diaz */

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;
import java.util.Scanner;

public class Anagram {

	/**
	 * https://www.hackerrank.com/challenges/anagram
	 * @param args
	 * @throws IOException
	 */
	public static void main(String[] args) throws IOException {
		InputStream inputStream = Anagram.class.getClassLoader().getResourceAsStream("config.properties");
		Properties properties = new Properties();
		properties.load(inputStream);
		File file = new File(properties.getProperty("input.path") + "anagram.txt");
		Scanner in = new Scanner(file);
		// Scanner in = new Scanner(System.in);
		int casesNumber = in.nextInt();
		for (int i = 0; i < casesNumber; i++) {
			String input = in.next();
			int changes = Anagram.calculateAnagram(input);
			System.out.println(changes);
		}
		in.close();
	}

	/**
	 * if input length is odd return -1
	 * else
	 *  divide input in 2 equals part (S1 and S2).
	 * 	calculate caracters in present in S2 and not in S1.
	 * @param input
	 * @return
	 */
	public static Integer calculateAnagram(String input) {
		int distinctChars = -1;
		int length = input.length();
		if (length%2==0) {
			String firstPart = input.substring(0, length/2); 
			String secondPart = input.substring(length/2, length); 
			System.out.println(firstPart);
			System.out.println(secondPart);
			for (int i = 0; i < firstPart.length(); i++) {
				String pattern = "" + firstPart.charAt(i);
				secondPart = secondPart.replaceFirst(pattern, "");
			}
			distinctChars = secondPart.length();
		}
		return distinctChars;
	}
}
