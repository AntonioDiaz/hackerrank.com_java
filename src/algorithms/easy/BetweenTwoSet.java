package algorithms.easy;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;
import java.util.Scanner;

public class BetweenTwoSet {

	public static void main(String[] args) throws IOException {
		InputStream inputStream = BetweenTwoSet.class.getClassLoader().getResourceAsStream("config.properties");
		Properties properties = new Properties();
		properties.load(inputStream);
		File file = new File(properties.getProperty("input.path") + "between_two_set.txt");
		Scanner in = new Scanner(file);
		// Scanner in = new Scanner(System.in);
		int minNumber = Integer.MAX_VALUE;
		int maxNumber = Integer.MIN_VALUE;
		int n = in.nextInt();
		int m = in.nextInt();
		int[] aSet = new int[n];
		for (int i = 0; i < n; i++) {
			aSet[i] = in.nextInt();
			if (aSet[i] < minNumber) {
				minNumber = aSet[i];
			}
			if (aSet[i] > maxNumber) {
				maxNumber = aSet[i];
			}
		}
		int[] bSet = new int[m];
		for (int i = 0; i < m; i++) {
			bSet[i] = in.nextInt();
			if (bSet[i] < minNumber) {
				minNumber = bSet[i];
			}
			if (bSet[i] > maxNumber) {
				maxNumber = bSet[i];
			}
		}
		int betweenCount = 0;
		for (int i = minNumber; i <= maxNumber; i++) {
			boolean isFactor = true;
			for (int a : aSet) {
				//System.out.println(a + " " + i % a);
				isFactor = isFactor && i % a == 0;
			}
			if (isFactor) {
				for (int b : bSet) {
					//System.out.println(a + " " + i % a);
					isFactor = isFactor && b % i == 0;
				}
			}
			if (isFactor) {
				betweenCount++;
			}
		}
		System.out.println(betweenCount);
		in.close();
	}
}
