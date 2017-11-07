package algorithms.implementation.easy;

import java.io.File;
import java.io.InputStream;
import java.util.Properties;
import java.util.Scanner;

public class DivisibleSumPair {

	public static void main(String[] args) throws Exception {
		InputStream input = DivisibleSumPair.class.getClassLoader().getResourceAsStream("config.properties");
		Properties properties = new Properties();
		properties.load(input);
		File file = new File(properties.getProperty("input.path") + "divisible_sum_pair.txt");
		Scanner in = new Scanner(file);
		//Scanner in = new Scanner(System.in);
		int n = in.nextInt();
		int k = in.nextInt();
		int[] values = new int[n];
		int pairsFound = 0;
		for (int i = 0; i < n; i++) {
			values[i] = in.nextInt();
		}
		for (int i = 0; i < values.length; i++) {
			for (int j = i+1; j < values.length; j++) {
				if ((values[i] + values[j])%k==0) {
					pairsFound++;
				}
			}			
		}
		System.out.println(pairsFound);
		in.close();
	}
}
