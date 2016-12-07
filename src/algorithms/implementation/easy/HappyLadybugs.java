package algorithms.implementation.easy;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Properties;
import java.util.Scanner;
import java.util.Set;

public class HappyLadybugs {

	public static void main(String[] args) throws IOException {
		InputStream inputStream = HappyLadybugs.class.getClassLoader().getResourceAsStream("config.properties");
		Properties properties = new Properties();
		properties.load(inputStream);
		File file = new File(properties.getProperty("input.path") + "happy_ladybugs_02.txt");
		Scanner in = new Scanner(file);
		// Scanner in = new Scanner(System.in);
		int gamesCount = in.nextInt();
		for (int i = 0; i < gamesCount; i++) {
			//System.out.println("i -->" + i);
			in.nextInt();
			String board = in.next();
			//System.out.println(board);
			byte[] boardBytes = board.getBytes();
			Set<Byte> ladyBugsSingles = new HashSet<Byte>();
			Set<Byte> ladyBugs = new HashSet<Byte>();
			boolean spacesFound = false;
			for (byte b : boardBytes) {
				if (b==95) {
					spacesFound = true;
				} else {
					if (ladyBugs.contains(b)) {
						ladyBugsSingles.remove(b);
					} else {
						ladyBugsSingles.add(b);
					}
					ladyBugs.add(b);
				}
			}
			if (!ladyBugsSingles.isEmpty()) {
				System.out.println("NO");
			} else {
				if (spacesFound) {
					System.out.println("YES");
				} else {
					/* may be the ladybugs are already happy */
					boolean allHappy = true;
					for (int j = 0; j < boardBytes.length; j++) {
						if (boardBytes[j]!=95) {
							allHappy = allHappy && ((j>0 && boardBytes[j] == boardBytes[j-1]) || (j<boardBytes.length-1 && boardBytes[j] == boardBytes[j+1]));
						}
					}
					System.out.println(allHappy?"YES":"NO");
				}
			}
			//System.out.println(ladyBugs);
			//System.out.println(ladyBugsSingles);
			//System.out.println(spacesFound);
		}
		in.close();
	}
}
