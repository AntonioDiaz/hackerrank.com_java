package algorithms.strings.easy;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;
import java.util.Scanner;

public class SuperReducedString {

	public static void main(String[] args) throws IOException {
		InputStream inputStream = SuperReducedString.class.getClassLoader().getResourceAsStream("config.properties");
		Properties properties = new Properties();
		properties.load(inputStream);
		File file = new File(properties.getProperty("input.path") + "super_reduced_string.txt");
		Scanner in = new Scanner(file);
		// Scanner in = new Scanner(System.in);
		String input = in.nextLine();
		String reducedString = SuperReducedString.calculateReducedString(input);
		System.out.println(reducedString);
		in.close();
	}

	public static String calculateReducedString(String input) {
		boolean pairFound = true;
		String inputAux = "";
		while (pairFound) {
			inputAux = "";
			pairFound = false;
			int i = 0;
			while (i < input.length()) {
				if (i + 1 < input.length()) {
					if (input.charAt(i) == input.charAt(i + 1)) {
						i += 2;
						pairFound = true;
					} else {
						inputAux += input.charAt(i);
						i++;
					}
				} else {
					inputAux += input.charAt(i);
					i++;
				}
			}
			input = inputAux;
		}
		return inputAux == "" ? "Empty String" : inputAux;
	}
}
