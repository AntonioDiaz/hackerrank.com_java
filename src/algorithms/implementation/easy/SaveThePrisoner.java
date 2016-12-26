package algorithms.implementation.easy;

import java.io.File;
import java.io.InputStream;
import java.util.Properties;
import java.util.Scanner;

public class SaveThePrisoner {

	public static void main(String[] args) throws Exception {
		InputStream input = SaveThePrisoner.class.getClassLoader().getResourceAsStream("config.properties");
		Properties properties = new Properties();
		properties.load(input);
		File file = new File(properties.getProperty("input.path") + "save_the_prisoner_big.txt");
		Scanner in = new Scanner(file);
		//Scanner in = new Scanner(System.in);
		int testCases = in.nextInt();
		for (int i = 0; i < testCases; i++) {
			int numberOfPrisoners = in.nextInt();
			int numberOfSweets = in.nextInt();
			int startPrisoner = in.nextInt() - 1;
			/** if would start on first prisoner */
			int lastSweet = numberOfSweets % numberOfPrisoners;
			lastSweet = (lastSweet + startPrisoner) % numberOfPrisoners;
			if (lastSweet ==0) {
				lastSweet = numberOfPrisoners;
			}
			System.out.println(lastSweet);
		}		
		in.close();
	}
}
