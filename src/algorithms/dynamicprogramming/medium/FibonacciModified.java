package algorithms.dynamicprogramming.medium;

import java.io.IOException;
import java.math.BigInteger;
import java.util.Scanner;

public class FibonacciModified {

	public static void main(String[] args) throws IOException {
		//InputStream input = AlternatingCharacters.class.getClassLoader().getResourceAsStream("config.properties");
		//Properties properties = new Properties();
		//properties.load(input);
		//File file = new File(properties.getProperty("input.path") + "fibonacci_modified_02.txt");		
		//Scanner in = new Scanner(file);
		Scanner in = new Scanner(System.in);
		BigInteger a = BigInteger.valueOf(in.nextInt());
		BigInteger b = BigInteger.valueOf(in.nextInt());
		Integer n = in.nextInt();
		BigInteger next = BigInteger.valueOf(0);
		for (int i = 0; i < n - 2; i++) {
			next = a.add(b.multiply(b));
			a = b;
			b = next;			
		}		
		System.out.println(next);
		in.close();
	}
}