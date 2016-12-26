package algorithms.search.easy;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;
import java.util.Scanner;

public class IceCreamParlor {

	public static void main(String[] args) throws IOException {
		InputStream input = IceCreamParlor.class.getClassLoader().getResourceAsStream("config.properties");
		Properties properties = new Properties();
		properties.load(input);
		File file = new File(properties.getProperty("input.path") + "icecream_parlor.txt");
		Scanner in = new Scanner(file);
		int t = in.nextInt();
		for (int i = 0; i < t; i++) {
			int m = in.nextInt();
			int n = in.nextInt();
			int[] c = new int[n];
			for (int j = 0; j < n; j++) {
				c[j] = in.nextInt();
			}
			int[] flavors = twoFlavors(m, c);
			System.out.println((flavors[0] +1) + " " + (flavors[1]+ 1));
		}
		in.close();
	}

	private static int[] twoFlavors(int m, int[] c) {
		int[] result = new int[2];
		boolean finish = false;
		for (int i = 0; i < c.length && !finish; i++) {
			for (int j = i + 1; j < c.length && !finish; j++) {
				if (c[i] + c[j]==m) {
					result[0] = i;
					result[1] = j;
					finish = true;
				}
			}
		}
		return result;
	}
}
