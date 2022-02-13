package algorithms.implementation.easy;

import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.IntStream;
import java.util.stream.Stream;

import static java.util.stream.Collectors.toList;

//https://www.hackerrank.com/challenges/3d-surface-area

public class SurfaceArea3D {

  public static int surfaceArea(List<List<Integer>> list) {
    int rows = list.size();
    int columns = list.get(0).size();
    int surfacesTop = rows * columns;
    int surfacesDown = rows * columns;
    int surfacesLeft = 0;
    int surfacesRight = 0;
    for (int x = 0; x < rows; x++) {
      for (int y = 0; y < columns; y++) {
        surfacesLeft += Math.max(0, list.get(x).get(y) - (x > 0 ? list.get(x - 1).get(y) : 0));
        surfacesRight += Math.max(0, list.get(x).get(y) - ((x < rows-1) ? list.get(x + 1).get(y) : 0));
      }
    }
    int surfacesFront = 0;
    int surfacesBack = 0;
    for (int x = 0; x < rows; x++) {
      for (int y = 0; y < columns; y++) {
        surfacesFront += Math.max(0, list.get(x).get(y) - (y > 0 ? list.get(x).get(y - 1) : 0));
        surfacesBack += Math.max(0, list.get(x).get(y) - ((y < columns-1) ? list.get(x).get(y + 1) : 0));
      }
    }
    return surfacesDown + surfacesTop + surfacesLeft + surfacesRight + surfacesFront + surfacesBack;
  }

  public static void main(String[] args) throws IOException {
    BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));

    String[] firstMultipleInput = bufferedReader.readLine().replaceAll("\\s+$", "").split(" ");

    int H = Integer.parseInt(firstMultipleInput[0]);

    int W = Integer.parseInt(firstMultipleInput[1]);

    List<List<Integer>> A = new ArrayList<>();

    IntStream.range(0, H).forEach(i -> {
      try {
        A.add(
                Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
                        .map(Integer::parseInt)
                        .collect(toList())
        );
      } catch (IOException ex) {
        throw new RuntimeException(ex);
      }
    });

    int result = SurfaceArea3D.surfaceArea(A);

    bufferedWriter.write(String.valueOf(result));
    bufferedWriter.newLine();

    bufferedReader.close();
    bufferedWriter.close();
  }}
