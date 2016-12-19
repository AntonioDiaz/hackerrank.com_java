package algorithms.strings.easy;

/**
 * @author antonio.diaz
 */

import java.io.*;
import java.util.*;

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
		String newStr = "";
		int dolarsNeeded = 0;
		int position = 0;
		while (!oldStr.equals(newStr)) {
			/* calculate maximun substring of the remainig oldStr found in newStr. */
			String maxSubstring = "";
			int subLength = newStr.length();
			while (subLength - position > 0 && maxSubstring.length()==0) {
				String substring = oldStr.substring(position, subLength);
				if (newStr.contains(substring)) {
					maxSubstring = substring;
				}
				subLength--;
			}
			if (maxSubstring.length() == 0) {
				newStr += oldStr.charAt(position);
				dolarsNeeded++;
			} else {
				newStr += maxSubstring;
			}
			position = newStr.length();
		}
		return dolarsNeeded;
	}
}
