package algorithms.easy;

import java.io.File;
import java.io.InputStream;
import java.util.Properties;
import java.util.Scanner;

public class MaximunSubarray {

	public static void main(String[] args) throws Exception {
		InputStream input = MaximunSubarray.class.getClassLoader().getResourceAsStream("config.properties");
		Properties properties = new Properties();
		properties.load(input);
		File file = new File(properties.getProperty("input.path") + "maximun_subarray.txt");
		Scanner in = new Scanner(file);
		int t = in.nextInt();
		for (int i = 0; i < t; i++) {
			int n = in.nextInt();
			int[] a = new int[n];
			long maxContiguos = 0;
			long maxContiguosTemp = 0;
			long maxNonContiguos = 0;
			long max = Long.MIN_VALUE;
			for (int j = 0; j < n; j++) {
				a[j] = in.nextInt();
			}
			for (int j = 0; j < n; j++) {
				if (a[j]>max) {
					max = a[j];
				}
				if (a[j] > 0) {
					maxNonContiguos += a[j];
				}
				if (maxContiguosTemp + a[j]>0) {
					maxContiguosTemp += a[j];
					if (maxContiguosTemp>maxContiguos) {
						maxContiguos = maxContiguosTemp;
					}
				} else {
					maxContiguosTemp = 0;
				}
			}
			if (maxContiguos==0) {
				maxContiguos = max;
			}
			if (maxNonContiguos==0) {
				maxNonContiguos = max;
			}
			System.out.println(maxContiguos + " " + maxNonContiguos);
		}
		in.close();
	}

}
