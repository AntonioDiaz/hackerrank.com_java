package algorithms.implementation.easy;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;
import java.util.Scanner;

public class AppleAndOrange {

	public static void main(String[] args) throws IOException {
		InputStream inputStream = AppleAndOrange.class.getClassLoader().getResourceAsStream("config.properties");
		Properties properties = new Properties();
		properties.load(inputStream);
		File file = new File(properties.getProperty("input.path") + "apple_and_orange.txt");
		Scanner in = new Scanner(file);
		// Scanner in = new Scanner(System.in);
		int s = in.nextInt();
		int t = in.nextInt();
		int a = in.nextInt();
		int b = in.nextInt();
		int m = in.nextInt();
		int n = in.nextInt();
		int applesInside = 0;
		int orangesInside = 0;
		for (int i = 0; i < m; i++) {
			int appleDistance = in.nextInt();
			if (appleDistance >= (s - a) && appleDistance <= (t - a)) {
				applesInside++;
			}
		}
		for (int i = 0; i < n; i++) {
			int orangeDistance = in.nextInt();
			if (orangeDistance >= (s-b) && orangeDistance <= (t-b)) {
				orangesInside++;
			}
		}
		System.out.println(applesInside);
		System.out.println(orangesInside);
		in.close();
	}
}
