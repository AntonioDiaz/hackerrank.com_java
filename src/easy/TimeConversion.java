package easy;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;
import java.util.Scanner;

public class TimeConversion {

	public static void main(String[] args) throws IOException {
		InputStream input = TimeConversion.class.getClassLoader().getResourceAsStream("config.properties");
		Properties properties = new Properties();
		properties.load(input);
		File file = new File(properties.getProperty("input.path") + "time_conversion.txt");
		Scanner in = new Scanner(file);
		String line = in.nextLine();
		boolean isPM = line.substring(line.length() - 2).equals("PM");
		line = line.substring(0, line.length() -2);
		String[] split = line.split(":");
		int parseInt = Integer.parseInt(split[0]);
		if (isPM) {
			if (parseInt!=12) {
				String hours = String.format ("%02d" , (parseInt + 12)%24);			
				line = hours + ":" + split[1] + ":" + split[2];
			}
		} else {
			if (parseInt==12) {
				line = "00" + ":" + split[1] + ":" + split[2];
			}
		}
		System.out.println(line);
		in.close();
	}
	
}
