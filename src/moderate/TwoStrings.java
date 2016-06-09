package moderate;

import java.io.File;
import java.io.InputStream;
import java.util.HashSet;
import java.util.Properties;
import java.util.Scanner;
import java.util.Set;

public class TwoStrings {

	public static void main(String[] args) throws Exception {
		InputStream input = TwoStrings.class.getClassLoader().getResourceAsStream("config.properties");
		Properties properties = new Properties();
		properties.load(input);
		File file = new File(properties.getProperty("input.path") + "two_strings_01.txt");
		Scanner in = new Scanner(file);
		int n = in.nextInt();
		in.nextLine();
		for (int i = 0; i < n; i++) {
			String s1 = in.nextLine();
			String s2 = in.nextLine();
			byte[] bytesArray01 = s1.getBytes();
			byte[] bytesArray02 = s2.getBytes();
			Set<Byte> bytesSet = new HashSet<Byte>();
			for (byte b : bytesArray02) {
				bytesSet.add(b);
			}
			boolean contains = false;
			for (byte b : bytesArray01) {
				if (bytesSet.contains(b)) {
					contains = true;
				}
			}
			System.out.println(contains ? "YES" : "NO");
		}
		in.close();
	}
}
