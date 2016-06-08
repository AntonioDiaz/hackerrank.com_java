package easy;

import java.math.BigInteger;
import java.util.Scanner;

public class ExtraLongFactorial {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int n = in.nextInt();
		BigInteger big = BigInteger.valueOf(1);
		do {
			big = big.multiply(BigInteger.valueOf(n));
			n--;
		} while (n>1);
		System.out.println(big);
		in.close();
	}
}