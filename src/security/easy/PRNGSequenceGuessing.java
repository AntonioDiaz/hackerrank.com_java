package security.easy;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Date;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;
import java.util.Random;
import java.util.Scanner;

public class PRNGSequenceGuessing {

	public static void mainAux(String[] args) throws IOException {
		Random random = new Random(1374037200);
		for (int i = 0; i < 20; i++) {
			System.out.println(random.nextInt(1000));
		}
	}
	
	public static void main(String[] args) throws IOException {
		InputStream input = PRNGSequenceGuessing.class.getClassLoader().getResourceAsStream("config.properties");
		Properties properties = new Properties();
		properties.load(input);
		File file = new File(properties.getProperty("input.path") + "prng_sequence_guessing.txt");
		Scanner in = new Scanner(file);
		// Scanner in = new Scanner(System.in);
		int n = in.nextInt();
		for (int i = 0; i < n; i++) {
			long since = in.nextLong();
			long to = in.nextLong();
			List<Integer> list = new ArrayList<Integer>();
			for (int j = 0; j < 10; j++) {
				list.add(in.nextInt());
			}
			boolean found = false;
			for (long j = since; j < to && !found; j++) {
				Random random = new Random(j);
				boolean equals = true;
				for (int k = 0; k < 10; k++) {
					if (random.nextInt(1000)!=list.get(k)){
						equals = false;
					}
					if (k==9 && equals) {
						found = true;
						System.out.print(j);
						for (int p = 0; p < 10; p++) {
							System.out.print(" " + random.nextInt(1000));
						}
						System.out.println("");
					}
				}
			}
		}
		in.close();
	}
	
}
