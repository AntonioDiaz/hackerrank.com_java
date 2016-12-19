package algorithms.strings.easy;

/**
 * @author antonio.diaz
 */

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.util.HashSet;
import java.util.Properties;
import java.util.Scanner;
import java.util.Set;

public class StringConstruction {
	public static void main(String[] args) throws IOException {
		InputStream inputStream = StringConstruction.class.getClassLoader().getResourceAsStream("config.properties");
		Properties properties = new Properties();
		properties.load(inputStream);
		File file = new File(properties.getProperty("input.path") + "string_construction.txt");
		Scanner in = new Scanner(file);
		// Scanner in = new Scanner(System.in);
		int n = in.nextInt();
		for (int i = 0; i < n; i++) {
			String input = in.next();
			int cost = StringConstruction.calculateCost(input);
			System.out.println(cost);
		}
		in.close();
	}

	private static int calculateCost(String oldStr) {
		int dolarsNeeded = 0;
		Set<Character> setCharacters = new HashSet<Character>();
		for (int i = 0; i < oldStr.length(); i++) {
			Character c = oldStr.charAt(i);
			if (!setCharacters.contains(c)) {
				setCharacters.add(c);
				dolarsNeeded++;
			}
		}
		return dolarsNeeded;
	}
}
