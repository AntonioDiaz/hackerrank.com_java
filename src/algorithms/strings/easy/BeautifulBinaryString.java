package algorithms.strings.easy;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;
import java.util.Scanner;

public class BeautifulBinaryString {

	public static final String BEAUTIFUL_STRING = "010";

	public static void main(String[] args) throws IOException {
		InputStream inputStream = BeautifulBinaryString.class.getClassLoader().getResourceAsStream("config.properties");
		Properties properties = new Properties();
		properties.load(inputStream);
		File file = new File(properties.getProperty("input.path") + "beautiful_binary_string.txt");
		Scanner in = new Scanner(file);
		// Scanner in = new Scanner(System.in);
		in.nextInt();
		String input = in.next();
		int index = -1;
		int changesCount = 0;
		int prevIndex = -1;
		do {
			index = input.indexOf(BEAUTIFUL_STRING, index + 1);
			if (index != -1 && (prevIndex == -1 || index - prevIndex > 2)) {
				changesCount++;
				prevIndex = index;
			}
		} while (index != -1);
		System.out.println(changesCount);
		in.close();
	}
}
