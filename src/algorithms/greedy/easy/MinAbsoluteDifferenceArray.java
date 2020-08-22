package algorithms.greedy.easy;

import java.util.Arrays;

public class MinAbsoluteDifferenceArray {

    static int minimumAbsoluteDifference(int[] arr) {
        Arrays.sort(arr);
        int minDiff = Integer.MAX_VALUE;
        for (int i = 1; i < arr.length; i++) {
            int tempDiff = Math.abs(arr[i - 1] - arr[i]);
            if (tempDiff<minDiff) {
                minDiff = tempDiff;
            }
        }
        return minDiff;
    }
}
