package algorithms.strings.medium;

/** @author Antonio Diaz */
/** https://www.hackerrank.com/challenges/sherlock-and-anagrams */

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Properties;
import java.util.Scanner;

public class SherlockAndAnagrams {
	public static void main(String[] args) throws IOException {
		InputStream inputStream = SherlockAndAnagrams.class.getClassLoader().getResourceAsStream("config.properties");
		Properties properties = new Properties();
		properties.load(inputStream);
		File file = new File(properties.getProperty("input.path") + "sherlock_and_anagrams.txt");
		Scanner in = new Scanner(file);
		// Scanner in = new Scanner(System.in);
		int testCases = in.nextInt();
		for (int i = 0; i < testCases; i++) {
			String input = in.next();
			Integer anagrams = SherlockAndAnagrams.calculateAnagrams(input);
			System.out.println(anagrams);
		}
		in.close();
	}

	public static Integer calculateAnagrams(String input) {
		Integer anagramsCount = 0;
		byte[] bytes = input.getBytes();
		for (int i = 0; i < bytes.length; i++) {
			/* different sizes */
			for (int size = 1; size + 1 <= bytes.length - i; size++) {
				byte[] subArray0 = Arrays.copyOfRange(bytes, i, i + size);
				List<Byte> subSet0 = SherlockAndAnagrams.convertToList(subArray0);
				for (int j = i + 1; j + size <= bytes.length; j++) {
					byte[] subArray1 = Arrays.copyOfRange(bytes, j, j + size);					
					List<Byte> subSet1 = SherlockAndAnagrams.convertToList(subArray1);
					if (subSet0.equals(subSet1)) {
						anagramsCount++;
					}
				}
			}
		}
		return anagramsCount;
	}

	private static List<Byte> convertToList(byte[] array) {
		List<Byte> list = new ArrayList<Byte>();
		for (byte b : array) {
			list.add(new Byte(b));
		}
		Collections.sort(list);
		return list;
	}
}