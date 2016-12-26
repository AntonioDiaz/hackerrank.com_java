package algorithms.bitmanipulation.easy;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.math.BigInteger;
import java.util.Properties;
import java.util.Scanner;

public class FlippingBits {

	public static void main(String[] args) throws IOException {
		InputStream input = FlippingBits.class.getClassLoader().getResourceAsStream("config.properties");
		Properties properties = new Properties();
		properties.load(input);
		File file = new File(properties.getProperty("input.path") + "flipping_bits.txt");
		Scanner scanner = new Scanner(file);
		Integer t = scanner.nextInt();
		for (int i = 0; i < t; i++) {
			BigInteger n = new BigInteger(scanner.next());
			String str = n.toString(2);
			int size = str.length();
			for (int j = 0; j < 32 - size; j++) {
				str = "0" + str;
			}
			str = str.replace("1", "-");
			str = str.replace("0", "1");
			str = str.replace("-", "0");
			System.out.println(new BigInteger(str, 2));
		}
		scanner.close();
	}

}
