package algorithms.easy;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;
import java.util.Scanner;

public class GameOfThrones01 {

	
	public static void main(String[] args) throws IOException {
		InputStream input = GameOfThrones01.class.getClassLoader().getResourceAsStream("config.properties");
		Properties properties = new Properties();
		properties.load(input);
		File file = new File(properties.getProperty("input.path") + "game_of_trones_01.txt");
		Scanner in = new Scanner(file);
		// Scanner in = new Scanner(System.in);
		String str = in.next();
		byte[] bytes = str.getBytes();
		Map<Byte, Integer> map = new HashMap<Byte, Integer>();
		for (byte b : bytes) {
			int repetitions = 1;
			if (map.containsKey(b)) {
				repetitions = map.get(b) + 1;
			}
			map.put(b, repetitions);
		}
		int odd = 0;
		for (Byte b : map.keySet()) {
			if (map.get(b)%2!=0) {
				odd ++;
			}
		}
		System.out.println(odd<=1?"YES":"NO");
		in.close();
	}
}
