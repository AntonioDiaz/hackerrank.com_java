package contest.weekcode27;

/** @author Antonio Diaz */

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Properties;
import java.util.Scanner;

public class TailorShop {
	public static void main(String[] args) throws IOException {
		InputStream inputStream = TailorShop.class.getClassLoader().getResourceAsStream("config.properties");
		Properties properties = new Properties();
		properties.load(inputStream);
		File file = new File(properties.getProperty("input.path") + "tailor_shop.txt");
		Scanner in = new Scanner(file);
		// Scanner in = new Scanner(System.in);
		int colors = in.nextInt();
		int buttonPrice = in.nextInt();
		int buttonsNeeded = 0;
		List<Integer> minPricesList = new ArrayList<Integer>();
		for (int i = 0; i < colors; i++) {
			minPricesList.add(in.nextInt());
		}
		Collections.sort(minPricesList);
		System.out.println(minPricesList);
		int previousMinNumOfButtons = 0;
		for (Integer minPrice : minPricesList) {
			int minNumOfButtons = minPrice / buttonPrice + (minPrice % buttonPrice!=0?1:0);
			if (minNumOfButtons<=previousMinNumOfButtons) {
				minNumOfButtons = previousMinNumOfButtons + 1;
			}
			previousMinNumOfButtons = minNumOfButtons;
			buttonsNeeded += minNumOfButtons;
		}
		System.out.println(buttonsNeeded);
		in.close();
	}
}