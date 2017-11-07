package algorithms.implementation.easy;

import java.util.Scanner;

public class ModifiedKaprekarNumbers {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		long p = in.nextInt();
		long q = in.nextInt();
		boolean found = false;
		for (long i = p; i <= q; i++) {
			long digits = calcultateDigits(i);
			long square = i * i;
			long l = square / Math.round(Math.pow(10, digits));
			long r = square - l * Math.round(Math.pow(10, digits));
			// System.out.println("square " + square);
			// System.out.println(l + " " + r);
			if (r + l == i) {
				System.out.print(i + " ");
				found = true;
			}
		}
		if (!found) {
			System.out.println("INVALID RANGE");
		}
		in.close();
	}

	public static final int calcultateDigits(long n) {
		int i = 0;
		while (n / Math.pow(10, i) >= 10) {
			i++;
		}
		return i + 1;
	}
}
