package contest.weekcode27;

/** @author Antonio Diaz */

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
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
		boolean previous[] = new boolean[3];
		previous[0] = true; // 1
		previous[1] = false; // 2
		previous[2] = true; // 3
		Map<Integer, Boolean> map = new HashMap<Integer, Boolean>();
		map.put(0, true);
		map.put(1, false);
		/** each hackonacci element depends of the 3 previous it is necessary keep trak of the last 3 */
		int maxPosible = (new Double(Math.pow(n * n, 2))).intValue();
		for (int i = 3; i <= maxPosible; i++) {
			previous[i % 3] = previous[(i - 1) % 3] ^ previous[(i - 3) % 3];
			if (Math.sqrt(i) % 1 == 0) {
				map.put(i, previous[i % 3]);
			}
		}
		// System.out.println(Arrays.asList(queries));
		int[] possibleResults = new int[4];
		possibleResults[0] = 0;
		for (int i = 1; i <= n; i++) {
			for (int j = 1; j <= n; j++) {
				Integer valueOriginal = new Double(Math.pow(i * j, 2)).intValue();
				for (int k = 1; k <= 3; k++) {					
					int iNew = 0;
					int jNew = 0;
					if (k == 1) {
						iNew = n - i + 1;
						jNew = j;
					} else if (k == 2) {
						iNew = n - i + 1;
						jNew = n - j + 1;
					} else if (k == 3) {
						iNew = j;
						jNew = n - i + 1;
					}
					Integer valueRotation = new Double(Math.pow(iNew * jNew, 2)).intValue();
					boolean areDistinct = !map.get(valueOriginal) == map.get(valueRotation);
					if (areDistinct) {
						possibleResults[k]++;
					}
				}
			}
		}
		for (int i = 0; i < q; i++) {
			int rotationsSimplified = (in.nextInt() / 90)%4;
			System.out.println(possibleResults[rotationsSimplified]);
		}
		in.close();
	}
}