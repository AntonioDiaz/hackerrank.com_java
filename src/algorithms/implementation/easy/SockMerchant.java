package algorithms.implementation.easy;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;
import java.util.Scanner;

public class SockMerchant {

	public static void main(String[] args) throws IOException {
		InputStream inputStream = SockMerchant.class.getClassLoader().getResourceAsStream("config.properties");
		Properties properties = new Properties();
		properties.load(inputStream);
		File file = new File(properties.getProperty("input.path") + "sock_merchant.txt");
		Scanner in = new Scanner(file);

		// Scanner in = new Scanner(System.in);
		int sockAmount = in.nextInt();
		Map<Integer, Integer> socksMap = new HashMap<Integer, Integer>();
		for (int i = 0; i < sockAmount; i++) {
			int sockColor = in.nextInt();
			if (!socksMap.containsKey(sockColor)) {
				socksMap.put(sockColor, 0);
			}
			socksMap.put(sockColor, socksMap.get(sockColor) + 1);
		}
		Collection<Integer> values = socksMap.values();
		int socksPairs = 0;
		for (Integer socksByColor : values) {
			socksPairs += socksByColor / 2;
		}
		System.out.println(socksPairs);
		in.close();

	}
}
