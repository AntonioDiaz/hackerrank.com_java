package algorithms.search.medium;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;
import java.util.Scanner;

public class ConnectedCellsGrid {
	public static void main(String[] args) throws IOException {
		InputStream inputStream = ConnectedCellsGrid.class.getClassLoader().getResourceAsStream("config.properties");
		Properties properties = new Properties();
		properties.load(inputStream);
		File file = new File(properties.getProperty("input.path") + "connected_cells_grid.txt");
		Scanner in = new Scanner(file);
		// Scanner in = new Scanner(System.in);
		int rows = in.nextInt();
		int cols = in.nextInt();
		boolean[][] matrix = new boolean[rows][cols];
		for (int i = 0; i < rows; i++) {
			for (int j = 0; j < cols; j++) {
				matrix[i][j] = in.nextInt() == 1 ? true : false;
			}
		}
		int maxConnected = Integer.MIN_VALUE;
		for (int i = 0; i < rows; i++) {
			for (int j = 0; j < cols; j++) {
				int connected = calculateConnected(matrix, i, j, rows, cols);
				if (connected > maxConnected) {
					maxConnected = connected;
				}
			}
		}
		System.out.println(maxConnected);
		in.close();
	}

	private static int calculateConnected(boolean[][] matrix, int row, int col, int rows, int cols) {
		int connections = 0;
		if(matrix[row][col]) {
			System.out.println("row: " + row);
			System.out.println("col: " + col);
			System.out.println(matrix[row][col]);
			printMatrix(matrix);
			matrix[row][col] = false;
			connections = 1;
			if (row > 0) {
				//connections += matrix[row - 1][col] ? 1 : 0;
				connections += calculateConnected(matrix, row -1 , col, rows, cols);
				if (col > 0) {
					//connections += matrix[row - 1][col - 1] ? 1 : 0;
					connections += calculateConnected(matrix, row -1 , col -1, rows, cols);
				}
				if (col < cols - 1) {
					//connections += matrix[row - 1][col + 1] ? 1 : 0;
					connections += calculateConnected(matrix, row -1 , col +1, rows, cols);
				}
			}
			if (row < rows - 1) {
				//connections += matrix[row + 1][col] ? 1 : 0;
				connections += calculateConnected(matrix, row + 1 , col, rows, cols);
				if (col > 0) {
					//connections += matrix[row + 1][col - 1] ? 1 : 0;
					connections += calculateConnected(matrix, row + 1 , col - 1, rows, cols);
				}
				if (col < cols - 1) {
					//connections += matrix[row + 1][col + 1] ? 1 : 0;
					connections += calculateConnected(matrix, row + 1 , col + 1, rows, cols);
				}
			}
			if (col > 0) {
				//connections += matrix[row][col - 1] ? 1 : 0;
				connections += calculateConnected(matrix, row , col -1, rows, cols);
			}
			if (col < cols - 1) {
				//connections += matrix[row][col + 1] ? 1 : 0;
				connections += calculateConnected(matrix, row , col +1, rows, cols);
			}
		}
		return connections;
	}

	private static void printMatrix(boolean[][] matrix) {
		for (int i = 0; i < matrix.length; i++) {
			for (int j = 0; j < matrix[i].length; j++) {
				System.out.print((matrix[i][j] ? 1 : 0) + "\t");
			}
			System.out.println("");
		}

	}
}