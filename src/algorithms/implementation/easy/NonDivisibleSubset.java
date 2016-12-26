package algorithms.implementation.easy;

import java.io.File;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;
import java.util.Scanner;

public class NonDivisibleSubset {

	public static void main(String[] args) throws Exception {
		InputStream input = NonDivisibleSubset.class.getClassLoader().getResourceAsStream("config.properties");
		Properties properties = new Properties();
		properties.load(input);
		File file = new File(properties.getProperty("input.path") + "non_divisible_subset.txt");
		Scanner in = new Scanner(file);
		// Scanner in = new Scanner(System.in);
		int n = in.nextInt();
		int k = in.nextInt();
		Map<Integer, Integer> remaindersCount = new HashMap<Integer, Integer>();
		for (int i = 0; i < k; i++) {
			remaindersCount.put(i, 0);
		}
		for (int i = 0; i < n; i++) {
			int remainder = in.nextInt() % k;
			remaindersCount.put(remainder, remaindersCount.get(remainder) + 1);
		}
		// System.out.println(remaindersCount);
		int maxSubSetCount = 0;
		for (int i = 0; i <= (k / 2); i++) {
			if (i==0 || i==(k-i)) {
				if (remaindersCount.get(i)>0) {
					maxSubSetCount += 1;
				}
			} else {
				if (remaindersCount.get(i) > remaindersCount.get(k - i)) {
					maxSubSetCount += remaindersCount.get(i);
				} else {
					maxSubSetCount += remaindersCount.get(k - i);
				}
			}
		}
		System.out.println(maxSubSetCount);
		in.close();
	}
}
