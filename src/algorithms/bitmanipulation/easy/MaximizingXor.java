package algorithms.bitmanipulation.easy;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;
import java.util.Scanner;

public class MaximizingXor {

	public static void main(String[] args) throws IOException {
		InputStream input = MaximizingXor.class.getClassLoader().getResourceAsStream("config.properties");
		Properties properties = new Properties();
		properties.load(input);
		File file = new File(properties.getProperty("input.path") + "maximizing_xor.txt");
		Scanner in = new Scanner(file);
		//Scanner in = new Scanner(System.in);
		int l = in.nextInt();
		int r = in.nextInt();
		int maxXor = -1;
		for (int i = l; i <= r; i++) {
			for (int j = i; j <= r; j++) {
				int myXor = i^j;
				if (myXor>maxXor) {
					maxXor = myXor;
				}
			}			
		}		
		System.out.println(maxXor);
		in.close();
	}
}
