package contest.weekcode27;

/** @author Antonio Diaz */

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;
import java.util.Scanner;

public class ZeroMoveNim {
	public static void main(String[] args) throws IOException {
		InputStream inputStream = ZeroMoveNim.class.getClassLoader().getResourceAsStream("config.properties");
		Properties properties = new Properties();
		properties.load(inputStream);
		File file = new File(properties.getProperty("input.path") + "zero_moven_nim.txt");
		Scanner in = new Scanner(file);
		// Scanner in = new Scanner(System.in);
		int games = in.nextInt();
		for (int i = 0; i < games; i++) {
			int pilesNum = in.nextInt();
			List<BigInteger> piles = new ArrayList<BigInteger>();
			for (int j = 0; j < pilesNum; j++) {
				piles.add(new BigInteger(in.next()));
			}
			boolean firstWins = ZeroMoveNim.calculateIfFirstWins(piles);
			System.out.println(firstWins ? "W" : "L");
		}
		in.close();
	}

	/** Nim Game: calculate if the first player can win the game.
	 * 
	 * @param piles
	 * @return */
	public static boolean calculateIfFirstWins(List<BigInteger> piles) {
		System.out.println(piles);
		return false;
	}

}
