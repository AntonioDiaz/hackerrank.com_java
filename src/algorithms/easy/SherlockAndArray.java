package algorithms.easy;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;
import java.util.Scanner;

public class SherlockAndArray {

	public static void main(String[] args) throws IOException {
		InputStream input = SherlockAndArray.class.getClassLoader().getResourceAsStream("config.properties");
		Properties properties = new Properties();
		properties.load(input);
		File file = new File(properties.getProperty("input.path") + "sherlock_and_array_03.txt");
		Scanner in = new Scanner(file);
		// Scanner in = new Scanner(System.in);
		int t = in.nextInt();
		for (int i = 0; i < t; i++) {
			int n = in.nextInt();
			int[] arrayN = new int[n];
			long[] arrayS = new long[n];
			long sum = 0;
			for (int j = 0; j < n; j++) {
				int aux = in.nextInt();
				sum += aux;
				arrayN[j] = aux;
				arrayS[j] = sum;
			}
			//System.out.println(foundElement ? "YES" : "NO");
			boolean balanced = false;
			for (int j = 0; j < n -1; j++) {
				//System.out.println(j);
				if (arrayS[j] - arrayN[j]== sum - arrayS[j] ) {					
					balanced = true;
				}
			}
			System.out.println(n==1||balanced?"YES":"NO");
		}
		in.close();

	}


}
