package algorithms.implementation.easy;

import java.util.Scanner;

public class FindDigits {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int t = in.nextInt();
		for (int a0 = 0; a0 < t; a0++) {
			int n = in.nextInt();
			int tenMulti = 1;
			int cont = 0;
			while (n > tenMulti) {
				tenMulti = tenMulti * 10;
				int myDigit = n % tenMulti * 10 / tenMulti;
				if (myDigit != 0 && n % myDigit == 0) {
					cont++;
				}
			}
			System.out.println(cont);
		}
		in.close();
	}
}