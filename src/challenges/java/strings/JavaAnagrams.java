package challenges.java.strings;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;
import java.util.Scanner;

public class JavaAnagrams {
	public static void main(String[] args) throws IOException {
		InputStream inputStream = JavaAnagrams.class.getClassLoader().getResourceAsStream("config.properties");
		Properties properties = new Properties();
		properties.load(inputStream);
		File file = new File(properties.getProperty("input.path") + "java_anagrams.txt");
		Scanner in = new Scanner(file);
		// Scanner in = new Scanner(System.in);
		String str01 = in.nextLine();
		String str02 = in.nextLine();
		if (isAnagram(str01, str02)) {
			System.out.println("Anagrams");
		} else {
			System.out.print("Not Anagrams");
		}
		in.close();
	}

	private static boolean isAnagram(String str01, String str02) {
		str01 =  str01.toLowerCase();
		str02 =  str02.toLowerCase();
		byte[] bytes = str01.getBytes();
		boolean areAnagrams = false;
		if (str01.length()==str02.length()) {
			for (byte b : bytes) {
				String str = new String(new char[]{(char)b});
				str02 = str02.replaceFirst(str, "");
				System.out.println("-->" + str02);
			}
			System.out.println("-->" + str02.length());
			System.out.println("-->" + (str02.length()==0));
			areAnagrams =  str02.length()==0;
		}
		return areAnagrams;
	}
}