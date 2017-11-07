package challenges.java.strings;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;
import java.util.Scanner;

public class JavaRegex {
	
	
	public static void main(String[] args) throws IOException {
		InputStream inputStream = JavaRegex.class.getClassLoader().getResourceAsStream("config.properties");
		Properties properties = new Properties();
		properties.load(inputStream);
		File file = new File(properties.getProperty("input.path") + "java_regex.txt");
		Scanner in = new Scanner(file);
		// Scanner in = new Scanner(System.in);
		while (in.hasNext()) {
			String ip = in.next();
			System.out.println(ip.matches(new MyRegex().pattern));
		}

		in.close();
	}
	
	static class MyRegex {
		private String ipSegment = "(\\d{1,2}|(0|1)\\d{2}|2[0-4]\\d|25[0-5])";
		public String pattern = ipSegment + "." + ipSegment + "." + ipSegment + "." + ipSegment;
	}
}
