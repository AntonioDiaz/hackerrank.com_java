package algorithms.implementation.hard;

import java.io.*;
import java.util.*;

public class MatrixLayerRotation {
	public static void main(String[] args) throws IOException {
		InputStream inputStream = MatrixLayerRotation.class.getClassLoader().getResourceAsStream("config.properties");
		Properties properties = new Properties();
		properties.load(inputStream);
		File file = new File(properties.getProperty("input.path") + "matrix_layer_rotation.txt");
		Scanner in = new Scanner(file);
		// Scanner in = new Scanner(System.in);
		int rows = in.nextInt();
		int cols = in.nextInt();
		int rotations = in.nextInt();
		int[][] matrix = new int[rows][cols];
		for (int i = 0; i < rows; i++) {
			for (int j = 0; j < cols; j++) {
				Coordinate oldCoordinate = new Coordinate(i, j);
				Coordinate coordinate = calculateNewCoordinate(oldCoordinate, rotations, rows, cols);
				matrix[coordinate.row][coordinate.col] = in.nextInt();
			}
		}
		printMatrix(matrix);
		in.close();
	}
	
	private static Coordinate calculateNewCoordinate(Coordinate oldCoordinate, int rotationsNumber, int rows, int cols) {
		int newRow = oldCoordinate.getRow() + rotationsNumber;
		int newCol = oldCoordinate.getCol() + rotationsNumber;				
		Coordinate newCoordinate = new Coordinate(newRow, newCol);
		return newCoordinate;
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
	}
}
