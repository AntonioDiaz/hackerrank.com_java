package algorithms.strings.easy;


import java.io.IOException;
import java.util.Scanner;

public class CaesarCipher {

	public static void main(String[] args) throws IOException {
		//InputStream input = CavityMap.class.getClassLoader().getResourceAsStream("config.properties");
		//Properties properties = new Properties();
		//properties.load(input);
		//File file = new File(properties.getProperty("input.path") + "caesar_cipher.txt");
		Scanner in = new Scanner(System.in);
		in.nextInt();
		String s = in.next();
		int k = in.nextInt();
		byte[] bytes = s.getBytes();
		for (int i = 0; i < bytes.length; i++) {
			if (bytes[i] >= 'a' && bytes[i] <= 'z') {
				bytes[i] = (byte)(((bytes[i] - 'a' + k) % 26) + 'a');
			}
			if (bytes[i] >= 'A' && bytes[i] <= 'Z') {
				bytes[i] = (byte)(((bytes[i] - 'A' + k) % 26) + 'A');
			}
		}
		System.out.println(new String(bytes));
		in.close();
	}
}
