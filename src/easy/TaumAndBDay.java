package easy;


import java.io.IOException;
import java.util.Scanner;

public class TaumAndBDay {

	public static void main(String[] args) throws IOException {;
		Scanner in = new Scanner(System.in);
		int t = in.nextInt();
		for (int a0 = 0; a0 < t; a0++) {
			long b = in.nextInt();
			long w = in.nextInt();
			long x = in.nextInt();
			long y = in.nextInt();
			long z = in.nextInt();
			long result = 0;
			if (x < y + z) {
				result = b * x;
			} else {
				result = b * y + b * z;
			}
			if (y < x + z) {
				result += w * y;
			} else {
				result += w * x + w * z;
			}
			System.out.println(result);
		}
		in.close();
	}
}
