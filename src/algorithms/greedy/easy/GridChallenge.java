package algorithms.greedy.easy;

//https://www.hackerrank.com/challenges/grid-challenge/problem?h_r=next-challenge&h_v=zen

import java.util.Arrays;

public class GridChallenge {

    // Complete the gridChallenge function below.
    static String gridChallenge(String[] grid) {
        for (int i = 0; i < grid.length; i++) {
            char[] chars = grid[i].toCharArray();
            Arrays.sort(chars);
            grid[i] = new String(chars);
        }
        for (int i = 0; i < grid[0].length(); i++) {
            for (int j = 1; j < grid.length; j++) {
                if (grid[j-1].charAt(i)>grid[j].charAt(i))
                    return "NO";
            }
        }
        return "YES";
    }
}
