package algorithms.warmup.easy;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;
import java.util.Scanner;

public class BirthdayCakeCandles {

	public static void main(String[] args) throws IOException {
		InputStream inputStream = BirthdayCakeCandles.class.getClassLoader().getResourceAsStream("config.properties");
		Properties properties = new Properties();
		properties.load(inputStream);
		File file = new File(properties.getProperty("input.path") + "birthday_cake_candles.txt");
		Scanner in = new Scanner(file);
		// Scanner in = new Scanner(System.in);
		int n = in.nextInt();
		Map<Integer, Integer> candles = new HashMap<Integer, Integer>();
		int maxHeight = Integer.MIN_VALUE;
		for (int i = 0; i < n; i++) {
			int candleHeight = in.nextInt();
			if (candleHeight>maxHeight) {
				maxHeight = candleHeight;
			}			
			if (candles.containsKey(candleHeight)) {
				candles.put(candleHeight, candles.get(candleHeight) + 1);
			} else {
				candles.put(candleHeight, 1);
			}
		}
		System.out.println(candles.get(maxHeight));
		in.close();
	}

}
