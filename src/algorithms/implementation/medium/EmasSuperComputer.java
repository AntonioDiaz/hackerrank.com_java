package algorithms.implementation.medium;

import java.io.*;
import java.util.*;

/**
 * 
 * @author antonio.diaz Strategy: for every element: 1. calculate cross size. 2.
 *         remove the cross, remove green elements. 3. calculate the cross size
 *         of the other elements and get the bigger. 4. sum crosses of step 1
 *         and the step 3 and get the bigger.
 */
public class EmasSuperComputer {
	public static void main(String[] args) throws IOException {
		InputStream inputStream = EmasSuperComputer.class.getClassLoader().getResourceAsStream("config.properties");
		Properties properties = new Properties();
		properties.load(inputStream);
		File file = new File(properties.getProperty("input.path") + "ema_super_computer_02.txt");
		Scanner in = new Scanner(file);
		// Scanner in = new Scanner(System.in);
		int rows = in.nextInt();
		int columns = in.nextInt();
		boolean[][] grid = new boolean[rows][columns];
		for (int i = 0; i < rows; i++) {
			String rowStr = in.next();
			for (int j = 0; j < columns; j++) {
				grid[i][j] = rowStr.charAt(j) == 'G';
			}
		}
		/** find maximun cross */
		int biggerArea = Integer.MIN_VALUE;
		for (int i = 0; i < rows; i++) {
			for (int j = 0; j < columns; j++) {
				int crossSize = maxGreenCross(grid, i, j);
				int area = calculateCrossArea(crossSize);
				boolean[][] gridAux = gridWithoutFirstCross(grid, i, j, crossSize);
				int maxCrossSizeSub = Integer.MIN_VALUE;
				for (int iSub = 0; iSub < rows; iSub++) {
					for (int jSub = 0; jSub < columns; jSub++) {
						if (i!=iSub && j!=jSub)  {
							int crossSizeSub = maxGreenCross(gridAux, iSub, jSub);
							if (maxCrossSizeSub < crossSizeSub) {
								maxCrossSizeSub = crossSizeSub;
							}
						}
					}
				}
				int areaSub = calculateCrossArea(maxCrossSizeSub);
				if (area * areaSub > biggerArea) {
					biggerArea = area * areaSub;
				}
			}
		}
		System.out.println(biggerArea);
		in.close();
	}

	private static int calculateCrossArea(int crossSize) {
		int area;
		if (crossSize <= 0) {
			area = 0;
		} else if (crossSize == 1) {
			area = 1;
		} else {
			area = 1 + (crossSize - 1) * 4;
		}
		return area;
	}

	/** remove green cross of an element. */
	private static boolean[][] gridWithoutFirstCross(boolean[][] grid, int row, int col, int crossSize) {
		boolean[][] newGrid = new boolean[grid.length][grid[0].length];
		for (int i = 0; i < grid.length; i++) {
			for (int j = 0; j < grid[0].length; j++) {
				newGrid[i][j] = grid[i][j];
			}
		}
		for (int k = 0; k < crossSize; k++) {
			newGrid[row - k][col] = false;
			newGrid[row][col - k] = false;
			newGrid[row + k][col] = false;
			newGrid[row][col + k] = false;
		}
		return newGrid;
	}

	/** find max */
	public static int maxGreenCross(boolean[][] grid, int row, int col) {
		int gridRows = grid.length;
		int gridCols = grid[0].length;
		int branchSize = 0;
		if (grid[row][col]) {
			boolean inRange = true;
			boolean validCross = true;
			/** calculate cross up size */
			while (inRange && validCross) {
				/* check up left */
				validCross = grid[row - branchSize][col];
				/* check left top */
				validCross &= grid[row][col - branchSize];
				/* check position right */
				validCross &= grid[row][col + branchSize];
				/* check position down */
				validCross &= grid[row + branchSize][col];
				if (validCross) {
					branchSize++;
				}
				inRange = row - branchSize >= 0;
				inRange &= col - branchSize >= 0;
				inRange &= (row + branchSize) < gridRows;
				inRange &= (col + branchSize) < gridCols;
			}
		}
		return branchSize;
	}
}