package challenges.java.datastructures;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;
import java.util.Scanner;

public class JavaSubArray {
	public static void main(String[] args) throws IOException {
		InputStream inputStream = JavaSubArray.class.getClassLoader().getResourceAsStream("config.properties");
		Properties properties = new Properties();
		properties.load(inputStream);
		File file = new File(properties.getProperty("input.path") + "java_subarray.txt");
		Scanner in = new Scanner(file);
		// Scanner in = new Scanner(System.in);
		int numElements = in.nextInt();
		int[] arrayInput = new int[numElements];
		for (int i = 0; i < numElements; i++) {
			arrayInput[i] = in.nextInt();
		}
		int subarraysNegatives = 0;
		for (int i = 0; i < numElements; i++) {
			int sum = 0;
			for (int j = i; j < numElements; j++) {
				sum += arrayInput[j];
				//System.out.println(i + "-" + j + "->" + sum);
				if (sum<0) {
					subarraysNegatives +=1;
				}
			}
		}
		System.out.println(subarraysNegatives);
		in.close();
	}
}