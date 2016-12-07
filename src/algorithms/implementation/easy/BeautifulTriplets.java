package algorithms.implementation.easy;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.util.HashSet;
import java.util.Properties;
import java.util.Scanner;
import java.util.Set;

public class BeautifulTriplets {
	public static void main(String[] args) throws IOException {
		InputStream inputStream = BeautifulTriplets.class.getClassLoader().getResourceAsStream("config.properties");
		Properties properties = new Properties();
		properties.load(inputStream);
		File file = new File(properties.getProperty("input.path") + "beautiful_triplets.txt");
		Scanner in = new Scanner(file);
		// Scanner in = new Scanner(System.in);
		int tripletsCount = 0;
		int numbersCount = in.nextInt();
		int diference = in.nextInt();
		Set<Integer> numbers = new HashSet<Integer>();
		for (int i = 0; i < numbersCount; i++) {
			numbers.add(in.nextInt());
		}
		for (Integer n : numbers) {
			if (numbers.contains(n + diference) && numbers.contains(n + diference*2)) {
				tripletsCount++;
			}
		}
		System.out.println(numbers);
		System.out.println(tripletsCount);
		in.close();
	}
}