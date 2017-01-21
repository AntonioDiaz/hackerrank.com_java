package challenges.java.bignumber;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.math.BigInteger;
import java.util.Properties;
import java.util.Scanner;

public class JavaBigInteger {

	public static void main(String[] args) throws IOException {
		InputStream inputStream = JavaBigInteger.class.getClassLoader().getResourceAsStream("config.properties");
		Properties properties = new Properties();
		properties.load(inputStream);
		File file = new File(properties.getProperty("input.path") + "java_biginteger.txt");
		Scanner in = new Scanner(file);
		// Scanner in = new Scanner(System.in);
		BigInteger big01 = new BigInteger(in.next());
		BigInteger big02 = new BigInteger(in.next());
		System.out.println(big01.add(big02).toString());
		System.out.println(big01.multiply(big02).toString());
		in.close();
	}

}
