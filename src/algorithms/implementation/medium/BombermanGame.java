package algorithms.implementation.medium;

import java.io.*;
import java.util.*;

public class BombermanGame {
	public static void main(String[] args) throws IOException {
		InputStream inputStream = BombermanGame.class.getClassLoader().getResourceAsStream("config.properties");
		Properties properties = new Properties();
		properties.load(inputStream);
		File file = new File(properties.getProperty("input.path") + "bomberman_game.txt");
		Scanner in = new Scanner(file);
		// Scanner in = new Scanner(System.in);
		int rows = in.nextInt();
		int cols = in.nextInt();
		int seconds = in.nextInt();
		int[][] grid = new int[rows][cols];
		for (int i = 0; i < rows; i++) {
			String rowStr = in.next();
			for (int j = 0; j < cols; j++) {
				grid[i][j] = rowStr.charAt(j) == 'O' ? 3 : 5;
			}
		}
		if (seconds % 4==0) { 
			seconds = 2;
		} else if (seconds!=1 && seconds % 4==1) { 
				seconds = 5;
		} else {
			seconds = seconds % 4; 			
		}
		for (int s = 0; s < seconds; s++) {
			for (int i = 0; i < rows; i++) {
				for (int j = 0; j < cols; j++) {
					grid[i][j]--;
				}
			}
			for (int i = 0; i < rows; i++) {
				for (int j = 0; j < cols; j++) {
					if (grid[i][j] == 0) {
						grid[i][j] = 4;
						destroyNeighbors(grid, i, j);
					}
				}
			}
		}
		printGrid(grid);
		in.close();
	}

	/** destroy all neibors */
	private static void destroyNeighbors(int[][] grid, int row, int col) {
		if (row - 1 >= 0 && grid[row - 1][col] != 0) {
			grid[row - 1][col] = 4;
		}
		if (col - 1 >= 0 && grid[row][col - 1] != 0) {
			grid[row][col - 1] = 4;
		}
		if (row + 1 < grid.length && grid[row + 1][col] != 0) {
			grid[row + 1][col] = 4;
		}
		if (col + 1 < grid[0].length && grid[row][col + 1] != 0) {
			grid[row][col + 1] = 4;
		}

	}

	private static void printGrid(int[][] grid) {
		for (int i = 0; i < grid.length; i++) {
		//for (int i = 0; i < 1; i++) {
			int[] row = grid[i];
			for (int element : row) {
				System.out.print(element>3?".":"O");
				//System.out.print(" " + i);
			}
			System.out.println("");
		}
	}
}