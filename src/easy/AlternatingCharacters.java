package easy;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;
import java.util.Scanner;

public class AlternatingCharacters {

	
	public static void main(String[] args) throws IOException {
		InputStream input = AlternatingCharacters.class.getClassLoader().getResourceAsStream("config.properties");
		Properties properties = new Properties();
		properties.load(input);
		File file = new File(properties.getProperty("input.path") + "alternating_characters.txt");		
		Scanner in = new Scanner(file);
		int n = in.nextInt();
		for (int i = 0; i < n; i++) {
			String s = in.next();
			byte[] bytes = s.getBytes();
			byte previous = -1;
			int cont = 0;
			for (byte b : bytes) {
				if (b==previous) {
					cont++;
				} else {
					previous = b;
				}
			} 
			System.out.println(cont);
		}
		in.close();
	}
	
}
