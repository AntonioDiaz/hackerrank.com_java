package algorithms.implementation.easy;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;
import java.util.Scanner;

public class BreakingTheRecords {
	public static void main(String[] args) throws IOException {
		InputStream inputStream = BreakingTheRecords.class.getClassLoader().getResourceAsStream("config.properties");
		Properties properties = new Properties();
		properties.load(inputStream);
		File file = new File(properties.getProperty("input.path") + "breaking_the_records.txt");
		Scanner in = new Scanner(file);
		// Scanner in = new Scanner(System.in);
		int matches = in.nextInt();
		int matchScore = in.nextInt();
		int maxScore = matchScore;
		int minScore = matchScore;
		int bestScores = 0;
		int worseScores = 0;
		for (int i = 1; i < matches; i++) {
			int score = in.nextInt();
			if (score > maxScore) {
				bestScores++;
				maxScore = score;
			}
			if (score < minScore) {
				worseScores++;
				minScore = score;
			}
		}
		System.out.println(bestScores + " " + worseScores);
		in.close();
	}
}