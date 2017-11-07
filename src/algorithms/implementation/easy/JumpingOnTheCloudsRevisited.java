package algorithms.implementation.easy;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;
import java.util.Scanner;

public class JumpingOnTheCloudsRevisited {

	private static final int INITIAL_ENERGY = 100;

	public static void main(String[] args) throws IOException {
		InputStream inputStream = JumpingOnTheCloudsRevisited.class.getClassLoader().getResourceAsStream("config.properties");
		Properties properties = new Properties();
		properties.load(inputStream);
		File file = new File(properties.getProperty("input.path") + "jumping_on_the_clouds_revisited.txt");
		Scanner in = new Scanner(file);
		// Scanner in = new Scanner(System.in);
		int cloudsNumber = in.nextInt();
		int jumpDistance = in.nextInt();
		/* false -> normal cloud, true -> thundercloud. */
		List<Boolean> clouds = new ArrayList<Boolean>();
		for (int i = 0; i < cloudsNumber; i++) {
			clouds.add(in.nextInt() == 1 ? true : false);
		}
		int position = 0;
		int energy = INITIAL_ENERGY;
		do {
			position = (position + jumpDistance) % cloudsNumber;
			energy += clouds.get(position)?-3:-1;
		} while (position !=0);
		System.out.println(energy);
		in.close();
	}
}