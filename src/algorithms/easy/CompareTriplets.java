package algorithms.easy;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;
import java.util.Scanner;

public class CompareTriplets {

	public static void main(String[] args) throws IOException {
		InputStream input = CompareTriplets.class.getClassLoader().getResourceAsStream("config.properties");
		Properties properties = new Properties();
		properties.load(input);
		File file = new File(properties.getProperty("input.path") + "compare_triplets.txt");
		Scanner in = new Scanner(file);
		//Scanner in = new Scanner(System.in);
		int a0 = in.nextInt();
		int a1 = in.nextInt();
		int a2 = in.nextInt();
		int b0 = in.nextInt();
		int b1 = in.nextInt();
		int b2 = in.nextInt();
		int[] result = new int[2];
		compareNumbers(a0, b0, result);
		compareNumbers(a1, b1, result);
		compareNumbers(a2, b2, result);
		System.out.println(result[0] + " " + result[1]);
		in.close();
	}

	private static void compareNumbers(int aCategory, int bCategory, int[] result) {
		if (aCategory!=bCategory) {
			if (aCategory>bCategory) {
				result[0]++;
			} else {
				result[1]++;
			}
		}
	}
}
