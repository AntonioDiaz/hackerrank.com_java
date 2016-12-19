package algorithms.implementation.hard;

/**
 * @author Antonio Diaz Arroyo
 * https://www.hackerrank.com/challenges/matrix-rotation-algo/
 */

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;
import java.util.Scanner;

public class MatrixLayerRotation {
	public static void main(String[] args) throws IOException {
		InputStream inputStream = MatrixLayerRotation.class.getClassLoader().getResourceAsStream("config.properties");
		Properties properties = new Properties();
		properties.load(inputStream);
		File file = new File(properties.getProperty("input.path") + "matrix_layer_rotation_big.txt");
		Scanner in = new Scanner(file);
		// Scanner in = new Scanner(System.in);
		int rows = in.nextInt();
		int cols = in.nextInt();
		int rotations = in.nextInt();
		int[][] matrix = new int[rows][cols];
		for (int i = 0; i < rows; i++) {
			for (int j = 0; j < cols; j++) {
				//Coordinate oldCoordinate = new Coordinate(i, j);
				//Coordinate coordinate = calculateNewCoordinate(oldCoordinate, rotations, rows, cols);
				matrix[i][j] = in.nextInt();
			}
		}
		int minRowsCols = rows < cols ? rows : cols;
		int[][] matrixNew = new int[rows][cols];
		for (int i = 0; i < minRowsCols / 2; i++) {
			int rowsLayer = rows - (i * 2);
			int colsLayer = cols - (i * 2);
			List<Coordinate> positions = calculatePositions(i, rowsLayer, colsLayer);
			int layerSize = rowsLayer * 2 + (colsLayer - 2) * 2;
			for (int j = 0; j < layerSize; j++) {
				int newj = (j + rotations) % layerSize;
				matrixNew[positions.get(newj).row][positions.get(newj).col] = matrix[positions.get(j).row][positions.get(j).col];
			}
		}
		printMatrix(matrixNew);
		in.close();
	}

	private static List<Coordinate> calculatePositions(int initPosition, int rows, int cols) {
		List<Coordinate> temp = new ArrayList<MatrixLayerRotation.Coordinate>();
		int size = rows * 2 + (cols - 2) * 2;
		int row = initPosition;
		int col = initPosition;
		for (int i = 0; i < size; i++) {
			temp.add(new Coordinate(row, col));
			if (col == initPosition) {
				if (row < (rows + initPosition) - 1) {
					row++;
				} else {
					col++;
				}
			} else if (row == (rows + initPosition) - 1) {
				if (col < cols + initPosition - 1) {
					col++;
				} else {
					row--;
				}
			} else if (col == (cols + initPosition) - 1) {
				if (row > initPosition) {
					row--;
				} else {
					col--;
				}
			} else if (row == initPosition) {
				if (col > initPosition) {
					col--;
				}
			}
		}
		return temp;
	}

	private static void printMatrix(int[][] matrix) {
		int rows = matrix.length;
		int cols = matrix[0].length;
		for (int i = 0; i < rows; i++) {
			for (int j = 0; j < cols; j++) {
				System.out.print(matrix[i][j] + " ");
			}
			System.out.println("");
		}
	}

	static class Coordinate {
		int row;
		int col;

		public Coordinate(int row, int col) {
			super();
			this.row = row;
			this.col = col;
		}

		public int getRow() {
			return row;
		}

		public void setRow(int row) {
			this.row = row;
		}

		public int getCol() {
			return col;
		}

		public void setCol(int col) {
			this.col = col;
		}

		@Override
		public String toString() {
			return row + " " + col;
		}
	}
}
