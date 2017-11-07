package algorithms.implementation.easy;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;
import java.util.Scanner;

public class CatsAndMouse {

	private static final String CAT_A = "Cat A";
	private static final String CAT_B = "Cat B";
	private static final String MOUSE = "Mouse C";

	public static void main(String[] args) throws IOException {
		InputStream inputStream = CatsAndMouse.class.getClassLoader().getResourceAsStream("config.properties");
		Properties properties = new Properties();
		properties.load(inputStream);
		File file = new File(properties.getProperty("input.path") + "cats_and_mouse.txt");
		Scanner in = new Scanner(file);
		// Scanner in = new Scanner(System.in);
		int cases = in.nextInt();
		for (int i = 0; i < cases; i++) {
			int catAPosition = in.nextInt();
			int catBPosition = in.nextInt();
			int mousePosition = in.nextInt();
			int distanceCatA = Math.abs(catAPosition - mousePosition);
			int distanceCatB = Math.abs(catBPosition - mousePosition);
			if (distanceCatA < distanceCatB) {
				System.out.println(CAT_A);
			} else if (distanceCatB < distanceCatA) {
				System.out.println(CAT_B);
			} else {
				System.out.println(MOUSE);
			}
		}
		in.close();
	}
}