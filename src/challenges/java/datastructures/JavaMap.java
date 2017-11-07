package challenges.java.datastructures;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;
import java.util.Scanner;

public class JavaMap {
	private static final String NOT_FOUND = "Not found";

	public static void main(String[] args) throws IOException {
		InputStream inputStream = JavaMap.class.getClassLoader().getResourceAsStream("config.properties");
		Properties properties = new Properties();
		properties.load(inputStream);
		File file = new File(properties.getProperty("input.path") + "java_map.txt");
		Scanner in = new Scanner(file);
		// Scanner in = new Scanner(System.in);
		int n = in.nextInt();
		in.nextLine();
		Map<String, String> phoneBook = new HashMap<String, String>();
		for (int i = 0; i < n; i++) {
			String name = in.nextLine();
			String phone = in.nextLine();
			phoneBook.put(name, phone);
		}
		while (in.hasNext()) {
			String s = in.nextLine();
			if (phoneBook.containsKey(s)) {
				System.out.println(s + "=" + phoneBook.get(s));
			} else {
				System.out.println(NOT_FOUND);			
			}
		}
		in.close();
	}
}