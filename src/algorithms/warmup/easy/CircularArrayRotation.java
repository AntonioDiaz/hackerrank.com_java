package algorithms.warmup.easy;

import java.io.File;
import java.io.InputStream;
import java.util.Properties;
import java.util.Scanner;

public class CircularArrayRotation {

	public static void main(String[] args) throws Exception {
		InputStream input = CircularArrayRotation.class.getClassLoader().getResourceAsStream("config.properties");
		Properties properties = new Properties();
		properties.load(input);
		File file = new File(properties.getProperty("input.path") + "circular_array_rotation.txt");
		Scanner in = new Scanner(file);
		//Scanner in = new Scanner(System.in);
		int n = in.nextInt();
		int k = in.nextInt();
		int q = in.nextInt();
		int[] array = new int[n];
		for (int i = 0; i < n; i++) {
			array[i] = in.nextInt();
		}
		for (int i = 0; i < q; i++) {
			int m = in.nextInt();
			//int position = (m + (k%n)) % n;
			int position = (m - (k%n) + n) % n;
			//System.out.println(position);
			System.out.println(array[position]);
		}
		in.close();
	}
}
