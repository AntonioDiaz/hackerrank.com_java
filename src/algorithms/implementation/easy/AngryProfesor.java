package algorithms.implementation.easy;

import java.util.Scanner;

public class AngryProfesor {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int t = in.nextInt();
		for (int a0 = 0; a0 < t; a0++) {
			int n = in.nextInt();
			int k = in.nextInt();
			int puppilsOnTime = 0;
			for (int a_i = 0; a_i < n; a_i++) {
				if (in.nextInt() <= 0) {
					puppilsOnTime++;
				}
			}
			if (puppilsOnTime >= k) {
				System.out.println("NO");
			} else {
				System.out.println("YES");
			}
		}
		in.close();
	}
}