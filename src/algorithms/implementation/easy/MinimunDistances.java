package algorithms.implementation.easy;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;
import java.util.Scanner;

public class MinimunDistances {

	public static void main(String[] args) throws IOException {
		InputStream inputStream = MinimunDistances.class.getClassLoader().getResourceAsStream("config.properties");
		Properties properties = new Properties();
		properties.load(inputStream);
		File file = new File(properties.getProperty("input.path") + "minimun_distances.txt");
		Scanner in = new Scanner(file);
		// Scanner in = new Scanner(System.in);
		int size = in.nextInt();
		int[] numbers = new int[size]; 
		for (int i = 0; i < size; i++) {
			numbers[i] = in.nextInt();
		}
		int minimunDistance = -1;
		for (int i = 0; i < numbers.length; i++) {
			for (int j = i+1; j < numbers.length; j++) {
				if (numbers[i]==numbers[j] && (j-i<minimunDistance || minimunDistance==-1)) {
					minimunDistance = j-i;
				}
			}
		}
		System.out.println(minimunDistance);
		in.close();
	}

}
