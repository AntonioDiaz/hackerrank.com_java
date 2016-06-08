package easy;

import java.util.Scanner;

public class ChocolateFeast {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int t = in.nextInt();
		for (int a0 = 0; a0 < t; a0++) {
			int n = in.nextInt();
			int c = in.nextInt();
			int m = in.nextInt();
			int chocolates = n / c;
			int envelopes = chocolates;
			while (envelopes >= m) {
				chocolates += envelopes / m;
				envelopes = envelopes / m + envelopes % m;

			}
			System.out.println(chocolates);
		}
		in.close();
	}
}