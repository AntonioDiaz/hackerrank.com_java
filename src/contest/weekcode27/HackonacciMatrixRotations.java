package contest.weekcode27;

/** @author Antonio Diaz */

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.math.BigInteger;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;
import java.util.Scanner;

public class HackonacciMatrixRotations {
	public static void main(String[] args) throws IOException {
		InputStream inputStream = HackonacciMatrixRotations.class.getClassLoader().getResourceAsStream("config.properties");
		Properties properties = new Properties();
		properties.load(inputStream);
		File file = new File(properties.getProperty("input.path") + "hackonacci_matrix_rotations.txt");
		Scanner in = new Scanner(file);
		// Scanner in = new Scanner(System.in);
		int n = in.nextInt();
		int q = in.nextInt();
		Map<Integer, Boolean> map = new HashMap<Integer, Boolean>();
		/* found that this series is repeated, 
		 * example parity (hackonacci(4)) == parity (hackonacci(11))   */		
		map.put(1, true); 
		map.put(2, false);
		map.put(3, true);
		map.put(4, false);
		map.put(5, false);
		map.put(6, true);
		map.put(0, true);
		int[] possibleResults = new int[4];
		for (int i = 1; i <= n; i++) {
			for (int j = 1; j <= n; j++) {
				BigInteger bigInteger = BigInteger.valueOf(i).multiply(BigInteger.valueOf(j));
				bigInteger = bigInteger.pow(2);
				bigInteger = bigInteger.mod(BigInteger.valueOf(7));
				int valueMod7 = bigInteger.intValue();
				for (int k = 1; k <= 2; k++) {
					int iNew = 0;
					int jNew = 0;
					if (k == 1) {
						iNew = j;
						jNew = n - i + 1;
					} else if (k == 2) {
						iNew = n - i + 1;
						jNew = n - j + 1;
					} 
					BigInteger bigIntegerRotation = BigInteger.valueOf(iNew).multiply(BigInteger.valueOf(jNew));
					bigIntegerRotation = bigIntegerRotation.pow(2);
					bigIntegerRotation = bigIntegerRotation.mod(BigInteger.valueOf(7));
					int valueMod7Rotation = bigIntegerRotation.intValue();
					boolean areDistinct = !map.get(valueMod7) == map.get(valueMod7Rotation);
					if (areDistinct) {
						possibleResults[k]++;
					}
				}
			}
		}
		possibleResults[0] = 0;
		possibleResults[3] = possibleResults[1];		
		for (int i = 0; i < q; i++) {
			int rotationsSimplified = (in.nextInt() / 90) % 4;
			System.out.println(possibleResults[rotationsSimplified]);
		}
		in.close();
	}
}