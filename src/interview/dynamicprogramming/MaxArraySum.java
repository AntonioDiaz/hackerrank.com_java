package interview.dynamicprogramming;

//https://www.hackerrank.com/challenges/max-array-sum

import javafx.util.Pair;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class MaxArraySum {

    static int maxSubsetSum(int[] arr) {
        int max = Integer.MIN_VALUE;
        int [] arrMax = new int[arr.length];
        for (int i = 0; i < arr.length; i++) {
            if (i==0) {
                arrMax[0] = arr[0];
            } else if ( i == 1) {
                arrMax[1] = Math.max(arr[0], arr[i]);
                max = arrMax[1];
            } else {
                max = Math.max(Math.max(max, arr[i]), arrMax[i - 2] + arr[i]);
                arrMax[i] = max;
            }
        }
        return max;
    }

    static int maxSubsetSumOld(int[] arr) {
        List<Pair<Integer, Integer>> pairlistSorted = IntStream.range(0,arr.length).boxed()
                .map(e -> new Pair<>(new Integer(arr[e]), e))
                .sorted(Comparator.comparing(Pair::getKey))
                .collect(Collectors.toList());
        Collections.reverse(pairlistSorted);
        int maxSum = Integer.MIN_VALUE;
        for (int i = 0; i < pairlistSorted.size(); i++) {
            Set<Integer> visited = new HashSet<>();
            visited.add(pairlistSorted.get(i).getValue());
            int sum = pairlistSorted.get(i).getKey();
            for (int j = i+1; j < pairlistSorted.size(); j++) {
                Integer valueCandidate = pairlistSorted.get(j).getKey();
                Integer indexCandidate = pairlistSorted.get(j).getValue();
                if (!visited.contains(indexCandidate-1) && !visited.contains(indexCandidate+1) && valueCandidate>0) {
                    sum += valueCandidate;
                    visited.add(indexCandidate);
                }
            }
            if (sum>maxSum) {
                maxSum = sum;
            }
        }
        return maxSum;
    }

}
