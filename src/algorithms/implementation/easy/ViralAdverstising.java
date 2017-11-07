package algorithms.implementation.easy;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;
import java.util.Scanner;

public class ViralAdverstising {

	public static void main(String[] args) throws IOException {
		InputStream inputStream = ViralAdverstising.class.getClassLoader().getResourceAsStream("config.properties");
		Properties properties = new Properties();
		properties.load(inputStream);
		File file = new File(properties.getProperty("input.path") + "viral_advertising.txt");
		Scanner in = new Scanner(file);
		//Scanner in = new Scanner(System.in);
		int days = in.nextInt();
		int peopleLikedLast = 0;
		int peopleLikedCount = 0;
		int peopleViewed = 5;
		for (int i = 0; i < days; i++) {
			peopleLikedLast = peopleViewed / 2;
			peopleViewed = peopleLikedLast * 3;
			peopleLikedCount+= peopleLikedLast;
		}
		System.out.println(peopleLikedCount);
		in.close();
	}
	
}
