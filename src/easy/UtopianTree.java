package easy;

import java.util.Scanner;

public class UtopianTree {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int t = in.nextInt();
		for (int a0 = 0; a0 < t; a0++) {
			int n = in.nextInt();
			Integer result = 1;
			for (int i = 1; i <= n; i++) {
				result = (i + 1) % 2 == 0 ? result * 2 : result + 1;
			}
			System.out.println(result);
		}
		in.close();
	}
}