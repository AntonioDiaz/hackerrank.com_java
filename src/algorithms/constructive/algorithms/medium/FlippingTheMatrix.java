package algorithms.constructive.algorithms.medium;

import java.io.*;
import java.util.*;

/**
 * Created by toni on 15/04/2017.
 */
public class FlippingTheMatrix {

    public static void main(String[] args) throws IOException {
        InputStream inputStream = FlippingTheMatrix.class.getClassLoader().getResourceAsStream("config.properties");
        Properties properties = new Properties();
        properties.load(inputStream);
        File file = new File(properties.getProperty("input.path") + "flipping_the_matrix.txt");
        Scanner in = new Scanner(file);
        // Scanner in = new Scanner(System.in);
        int queries = in.nextInt();
        for (int i = 0; i < queries; i++) {
            int n = in.nextInt();
            int matrixSize = n*2;
            int[][] matrix = new int[matrixSize][matrixSize];
            for (int row = 0; row < matrixSize; row++) {
                for (int column = 0; column < matrixSize; column++) {
                    matrix[row][column] = in.nextInt();
                }
            }
            int valuesSum = 0;
            for (int row = 0; row < n; row++) {
                for (int column = 0; column < n; column++) {
                    int maxValueElement =  matrix[row][column];
                    if (maxValueElement<matrix[matrixSize - row - 1][column]) {
                        maxValueElement = matrix[matrixSize - row - 1][column];
                    }
                    if (maxValueElement<matrix[row][matrixSize - column - 1]) {
                        maxValueElement = matrix[row][matrixSize - column - 1];
                    }
                    if (maxValueElement<matrix[matrixSize - row - 1][matrixSize - column - 1]) {
                        maxValueElement = matrix[matrixSize - row - 1][matrixSize - column - 1];
                    }
                    valuesSum += maxValueElement;
                }
            }
            System.out.println(valuesSum);
        }
        in.close();
    }

    private static void printMatrix(int[][] matrix, int n) {
        for (int row = 0; row < n; row++) {
            for (int column = 0; column < n; column++) {
                System.out.print("\t" + matrix[row][column]);
            }
            System.out.println("");
        }
    }
}
