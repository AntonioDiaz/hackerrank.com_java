package algorithms.implementation.easy;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;
import java.util.Scanner;

public class FairRations {
	public static void main(String[] args) throws IOException {
		InputStream inputStream = FairRations.class.getClassLoader().getResourceAsStream("config.properties");
		Properties properties = new Properties();
		properties.load(inputStream);
		File file = new File(properties.getProperty("input.path") + "fair_rations.txt");
		Scanner in = new Scanner(file);
		// Scanner in = new Scanner(System.in);
		int n = in.nextInt();
		//int[] subjects = new int[n];
		List<Integer> subjectsList = new ArrayList<Integer>();
		int loavesCount = 0;
		for (int i = 0; i < n; i++) {
			subjectsList.add(in.nextInt());
			loavesCount += subjectsList.get(i);
			
		}
		if (loavesCount % 2 ==0) {
			int loavesGiven = 0;
			for (int i = 0; i < subjectsList.size(); i++) {
				if (subjectsList.get(i)%2==1) {
					subjectsList.set(i, subjectsList.get(i)+1);
					subjectsList.set(i+1, subjectsList.get(i+1)+1);
					loavesGiven+=2;
				}
			}
			System.out.println(loavesGiven);
		} else {
			System.out.println("NO");
		}
		in.close();
	}
}