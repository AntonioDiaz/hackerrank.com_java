package algorithms.greedy.easy;

import java.util.Arrays;
import java.util.Scanner;

public class SherlockBeast {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int t = in.nextInt();
		for (int a0 = 0; a0 < t; a0++) {
			int n = in.nextInt();
			System.out.println(getFivesAndThrees(n));
		}
		in.close();
	}

	/** @param n
	 * @return */
	public static String getFivesAndThrees(int n) {
		int numOfThrees = 0;
		int numOfFives = 0;
		String result = "";
		if (n < 3 || n == 4 || n == 7) {
			result = "-1";
		} else {
			switch (n % 3) {
			case 0:
				numOfFives = 3 * (n / 3);
				break;
			case 1:
				if (n >= 10) { // 10, 13, 16, 19.
					numOfThrees = 10;
					numOfFives = 3 * (n / 3 - 3);
				} else { // 4, 7
					numOfFives = 3 * (n / 3);
				}
				break;
			case 2:
				numOfFives = 3 * (n / 3 - 1);
				numOfThrees = 5;
				break;
			}
			char[] chars = new char[numOfFives];
			Arrays.fill(chars, '5');
			String resultFives = new String(chars);
			chars = new char[numOfThrees];
			Arrays.fill(chars, '3');
			String resultThrees = new String(chars);
			result = resultFives + resultThrees;
		}
		return result;
	}
}