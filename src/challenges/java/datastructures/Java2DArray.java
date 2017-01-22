package challenges.java.datastructures;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;
import java.util.Scanner;

public class Java2DArray {

	private static final int SIZE_ARRAY = 6;

	public static void main(String[] args) throws IOException {
		InputStream inputStream = Java2DArray.class.getClassLoader().getResourceAsStream("config.properties");
		Properties properties = new Properties();
		properties.load(inputStream);
		File file = new File(properties.getProperty("input.path") + "java_2d_array.txt");
		Scanner in = new Scanner(file);
		// Scanner in = new Scanner(System.in);	
		int[][] arrayInput = new int[SIZE_ARRAY][SIZE_ARRAY];
		for (int row = 0; row < SIZE_ARRAY; row++) {
			for (int col = 0; col < SIZE_ARRAY; col++) {
				arrayInput[row][col] = in.nextInt();
			}
		}
		int maxHourGlassSum = Integer.MIN_VALUE;
		for (int row = 0; row < SIZE_ARRAY - 2; row++) {
			for (int col = 0; col < SIZE_ARRAY - 2; col++) {
				int hourGlassSum = calculateSum(arrayInput, row, col);
				if (hourGlassSum>maxHourGlassSum) {
					maxHourGlassSum = hourGlassSum;
				}
			}
		}		
		System.out.println(maxHourGlassSum);
		in.close();
	}

	private static int calculateSum(int[][] arrayInput, int row, int col) {
		int sum = 0;
		sum += arrayInput[row][col];
		sum += arrayInput[row][col+1];
		sum += arrayInput[row][col+2];
		sum += arrayInput[row+1][col+1];
		sum += arrayInput[row+2][col];
		sum += arrayInput[row+2][col+1];
		sum += arrayInput[row+2][col+2];
		return sum;
	}

}
