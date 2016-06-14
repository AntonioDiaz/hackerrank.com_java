package algorithms.easy;

import java.io.File;
import java.io.InputStream;
import java.util.HashSet;
import java.util.Properties;
import java.util.Scanner;
import java.util.Set;

public class Pangrams {

	public static void main(String[] args) throws Exception {

		InputStream input = Pangrams.class.getClassLoader().getResourceAsStream("config.properties");
		Properties properties = new Properties();
		properties.load(input);
		File file = new File(properties.getProperty("input.path") + "pangrams_01.txt");
		Scanner in = new Scanner(file);
		String line = in.nextLine();
		byte[] bytes = line.getBytes();
		Set<Byte> seen = new HashSet<Byte>();
		for (byte b : bytes) {
			if (b>64 && b<91) {
				b += 32;
			}
			if (b>96 && b<123) {
				seen.add(b);
			}
		}
		if (seen.size()==26) {
			System.out.println("pangram");
		} else {
			System.out.println("not pangram");
		}
		in.close();
	}
	
}
