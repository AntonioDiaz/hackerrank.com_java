package algorithms.moderate;

import java.io.IOException;
import java.util.Scanner;

public class LarrysArray {

	public static void main(String[] args) throws IOException {
		// InputStream input = Encryption.class.getClassLoader().getResourceAsStream("config.properties");
		// Properties properties = new Properties();
		// properties.load(input);
		// File file = new File(properties.getProperty("input.path") + "larrys_array.txt");
		// Scanner in = new Scanner(file);
		Scanner in = new Scanner(System.in);
		int t = in.nextInt();
		for (int i = 0; i < t; i++) {
			int n = in.nextInt();
			int[] a = new int[n];
			for (int j = 0; j < n; j++) {
				a[j] = in.nextInt();
			}
			System.out.println(hasSolution(a) ? "YES" : "NO");
		}
		in.close();
	}

	public static final boolean hasSolution(int[] a) {
		int inversions = 0;
		for (int i = 0; i < a.length; i++) {
			for (int j = i + 1; j < a.length; j++) {
				if (a[i] > a[j]) {
					inversions++;
				}
			}
		}
		return inversions % 2 == 0;
	}

}
