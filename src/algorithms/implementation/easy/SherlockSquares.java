package algorithms.implementation.easy;

import java.util.Scanner;

public class SherlockSquares {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int n = scanner.nextInt();
		for (int i = 0; i < n; i++) {
			int n0 = scanner.nextInt();
			int n1 = scanner.nextInt();
			int sqrt = (new Double(Math.sqrt(3))).intValue();
			int result = 0;
			while (sqrt * sqrt <= n1) {
				if (sqrt * sqrt >= n0) {
					result++;
				}
				sqrt++;
			}
			System.out.println(result);

		}
		scanner.close();
	}
}
