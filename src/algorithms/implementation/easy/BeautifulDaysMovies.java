package algorithms.implementation.easy;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;
import java.util.Scanner;

public class BeautifulDaysMovies {

	public static void main(String[] args) throws IOException {
		InputStream inputStream = BeautifulDaysMovies.class.getClassLoader().getResourceAsStream("config.properties");
		Properties properties = new Properties();
		properties.load(inputStream);
		File file = new File(properties.getProperty("input.path") + "beautiful_days_movies.txt");
		Scanner in = new Scanner(file);
		//Scanner in = new Scanner(System.in);
		int dayFrom = in.nextInt();
		int dayTo = in.nextInt();
		int k = in.nextInt();
		int specialDaysCount = 0;
		for(int i=dayFrom; i<=dayTo; i++){
			StringBuilder reverseStr = new StringBuilder(String.valueOf(i)).reverse();
			int iReversed = Integer.parseInt(reverseStr.toString());
			if (Math.abs(i-iReversed)%k==0) {
				specialDaysCount++;
			}
		}		
		System.out.println(specialDaysCount);
		in.close();
	}	
}
