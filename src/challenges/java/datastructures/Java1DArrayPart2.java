package challenges.java.datastructures;

import challenges.java.advanced.JavaVisitorPattern;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

/** https://www.hackerrank.com/challenges/java-1d-array/problem */

public class Java1DArrayPart2 {

  private static Set<Integer> visited;

  public static boolean win (int i, int leap, int[] game) {
    //System.out.println(String.format("i=%s, leap=%s, game=%s", i, leap, game.toString() ));
    if (i>=game.length)
      return true;
    if (visited.contains(i) || i<0 || game[i]!=0)
      return false;
    visited.add(i);
    return win(i-1, leap, game) || win(i+1, leap, game) || win(i+leap, leap, game);
  }

  public static boolean canWin(int leap, int[] game) {
    // Return true if you can win the game; otherwise, return false.
    visited = new HashSet<>();
    return win(0, leap, game);
  }

  public static void main(String[] args) throws FileNotFoundException {
    ClassLoader classLoader = new JavaVisitorPattern().getClass().getClassLoader();
    File file = new File(classLoader.getResource("array1d_part2_01.txt").getFile());
    Scanner scan = new Scanner(file);
    //Scanner scan = new Scanner(System.in);
    int q = scan.nextInt();
    while (q-- > 0) {
      int n = scan.nextInt();
      int leap = scan.nextInt();
      int[] game = new int[n];
      for (int i = 0; i < n; i++) {
        game[i] = scan.nextInt();
      }
      System.out.println( (canWin(leap, game)) ? "YES" : "NO" );
    }
    scan.close();
  }
}
