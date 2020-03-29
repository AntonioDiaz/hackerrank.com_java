package interview.dynamicprogramming;

import org.junit.Before;
import org.junit.Test;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.Collectors;

import static org.junit.Assert.*;

public class MaxArraySumTest {

    @Test
    public void maxSubsetSum_01() {
        int[] arrayIn = new int[] {-2, 1, 3, -4, 5};
        assertEquals(8, MaxArraySum.maxSubsetSum(arrayIn));
    }

    @Test
    public void maxSubsetSum_02() {
        int[] arrayIn = new int[] {3,7,4,6,5};
        assertEquals(13, MaxArraySum.maxSubsetSum(arrayIn));
    }

    @Test
    public void maxSubsetSum_03() {
        int[] arrayIn = new int[] {2,1,5,8,4};
        assertEquals(11, MaxArraySum.maxSubsetSum(arrayIn));
    }

    @Test
    public void maxSubsetSum_04() throws FileNotFoundException {
        ClassLoader classLoader = getClass().getClassLoader();
        File file = new File(classLoader.getResource("max_array_sum_01.txt").getFile());
        Scanner in = new Scanner(file);
        in.nextLine();
        int[] s = Arrays.stream(in.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();

        assertEquals(15, MaxArraySum.maxSubsetSum(s));
    }

}