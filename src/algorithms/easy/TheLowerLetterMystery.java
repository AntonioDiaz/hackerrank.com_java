package algorithms.easy;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;
import java.util.Scanner;

public class TheLowerLetterMystery {

	public static void main(String[] args) throws IOException {
		InputStream input = TheLowerLetterMystery.class.getClassLoader().getResourceAsStream("config.properties");
		Properties properties = new Properties();
		properties.load(input);
		File file = new File(properties.getProperty("input.path") + "the_lower_letter_mystery.txt");
		Scanner in = new Scanner(file);
		// Scanner in = new Scanner(System.in);
		int t = in.nextInt();
		for (int i = 0; i < t; i++) {
			String s = in.next();
			//System.out.println(s);
			int half = s.length()/2;
			//System.out.println(half);
			int cont = 0;
			for (int j = 0; j < half; j++) {
				byte b1 = (byte)s.charAt(j);
				byte b2 = (byte)s.charAt(s.length() - j - 1);
				cont += Math.abs(b1-b2);
			}				
			System.out.println(cont);
		}
		in.close();
	}
}
