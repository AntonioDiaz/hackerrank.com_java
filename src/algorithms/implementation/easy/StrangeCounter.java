package algorithms.implementation.easy;

import java.util.Scanner;

public class StrangeCounter {

	public static void main(String[] args) throws Exception {
		Scanner in = new Scanner(System.in);
		long time = in.nextLong();
		long n = 3;
		boolean exit = false;
		while (!exit) {
			if (time<=n) {
				System.out.println((n - (time-1)));
				exit = true;
			}
			n = n*2 +3;
		}
		in.close();
	}
}
