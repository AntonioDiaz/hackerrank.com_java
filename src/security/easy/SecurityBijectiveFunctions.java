package security.easy;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.util.HashSet;
import java.util.Properties;
import java.util.Scanner;
import java.util.Set;

public class SecurityBijectiveFunctions {
	public static void main(String[] args) throws IOException {
		InputStream input = SecurityBijectiveFunctions.class.getClassLoader().getResourceAsStream("config.properties");
		Properties properties = new Properties();
		properties.load(input);
		File file = new File(properties.getProperty("input.path") + "security_bijective_functions.txt");
		Scanner in = new Scanner(file);
		// Scanner in = new Scanner(System.in);
		int n = in.nextInt();
		Set<Integer> set  = new HashSet<Integer>();
		boolean isBijective = true;
		for (int i = 0; i < n; i++) {
			int next = in.nextInt();
			if (set.contains(next)){
				isBijective = false;
			} else {
				set.add(next);
			}
		}
		System.out.println(isBijective?"YES":"NO");
		in.close();
	}
}
