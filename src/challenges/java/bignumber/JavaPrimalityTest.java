package challenges.java.bignumber;

import java.io.IOException;
import java.math.BigInteger;
import java.util.Scanner;

public class JavaPrimalityTest {

	public static void main(String[] args) throws IOException {
		Scanner in = new Scanner(System.in);
		BigInteger n = in.nextBigInteger();
	      System.out.println(n.isProbablePrime(100)?"prime":"not prime");;
		in.close();
	}
}
