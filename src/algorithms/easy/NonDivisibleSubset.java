package algorithms.easy;

import java.io.File;
import java.io.InputStream;
import java.util.HashSet;
import java.util.Properties;
import java.util.Scanner;
import java.util.Set;

public class NonDivisibleSubset {

	public static void main(String[] args) throws Exception {
		InputStream input = NonDivisibleSubset.class.getClassLoader().getResourceAsStream("config.properties");
		Properties properties = new Properties();
		properties.load(input);
		File file = new File(properties.getProperty("input.path") + "non_divisible_subset.txt");
		Scanner in = new Scanner(file);
		//Scanner in = new Scanner(System.in);
		int n = in.nextInt();
		int k = in.nextInt();
		int[] values = new int[n];
		Set<Integer> subSet = new HashSet<Integer>();
		for (int i = 0; i < n; i++) {
			values[i] = in.nextInt();
		}
		for (int i = 0; i < values.length; i++) {
			for (int j = i+1; j < values.length; j++) {
				if ((values[i] + values[j])%k!=0) {
					subSet.add(values[i]);
					subSet.add(values[j]);
				}
			}			
		}
		System.out.println(subSet.size());
		in.close();
	}
}
