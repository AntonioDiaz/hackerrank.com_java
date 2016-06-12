package easy;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.util.HashSet;
import java.util.Properties;
import java.util.Scanner;
import java.util.Set;

public class GemStones {

	public static void main(String[] args) throws IOException {
		InputStream input = GemStones.class.getClassLoader().getResourceAsStream("config.properties");
		Properties properties = new Properties();
		properties.load(input);
		File file = new File(properties.getProperty("input.path") + "gem_stones_01.txt");
		Scanner in = new Scanner(file);
		// Scanner in = new Scanner(System.in);
		int n = in.nextInt();
		byte[] bytes = in.next().getBytes();
		Set<Byte> gemElements = new HashSet<Byte>();
		for (Byte myByte : bytes) {
			gemElements.add(myByte);
		}
		for (int i = 1; i < n; i++) {
			String myStr = in.next();
			byte[] bytes2 = myStr.getBytes();			
			Set<Byte> gemAux = new HashSet<Byte>();
			for (Byte myByte : bytes2) {
				if (gemElements.contains(myByte)) {
					gemAux.add(myByte);
				}
			}
			gemElements = gemAux;
		}
		System.out.println(gemElements.size());
		in.close();
	}

}
