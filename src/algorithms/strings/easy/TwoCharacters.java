package algorithms.strings.easy;

/** 
 * @author Antonio Diaz
 * https://www.hackerrank.com/challenges/two-characters 
 * */

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Properties;
import java.util.Scanner;
import java.util.Set;

public class TwoCharacters {
	public static void main(String[] args) throws IOException {
		InputStream inputStream = TwoCharacters.class.getClassLoader().getResourceAsStream("config.properties");
		Properties properties = new Properties();
		properties.load(inputStream);
		File file = new File(properties.getProperty("input.path") + "two_characters.txt");
		Scanner in = new Scanner(file);
		// Scanner in = new Scanner(System.in);
		in.nextInt();
		String input = in.next();
		int charsRemoved = TwoCharacters.calculateChars(input);
		System.out.println(charsRemoved);
		in.close();
	}

	/**
	 * @param input
	 * @return
	 */
	public static int calculateChars(String input) {
		Set<Character> charsSet = new HashSet<Character>();
		for (int i = 0; i < input.length(); i++) {
			charsSet.add(input.charAt(i));
		}
		List<Character> charsList = new ArrayList<Character>();
		charsList.addAll(charsSet);
		int maxLength = 0;
		for (int i = 0; i < charsList.size(); i++) {
			for (int j = i+1; j < charsList.size(); j++) {
				String str = "";
				Character charFirst = charsList.get(i);
				Character charSecond = charsList.get(j);
				for (int k = 0; k < input.length(); k++) {
					if (input.charAt(k)==charFirst || input.charAt(k)==charSecond) {
						str += input.charAt(k); 
					}
				}
				/* check is if valid */
				String strFirst = "" + charFirst + charFirst;
				String strSecond = "" + charSecond + charSecond;
				if (str.indexOf(strFirst)==-1 && str.indexOf(strSecond)==-1) {
					if (str.length()>maxLength) {
						maxLength = str.length();
					}
				}
			}
		}
		return maxLength;
	}
}