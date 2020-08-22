package algorithms.greedy.easy;

import org.junit.Assert;
import org.junit.Test;

public class MinAbsoluteDifferenceArrayTest {

    @Test
    public void test01() {
        int [] input = {3, -7, 0};
        Assert.assertEquals(3, MinAbsoluteDifferenceArray.minimumAbsoluteDifference(input));
    }

    @Test
    public void test02() {
        int [] input = {-59, -36, -13, 1, -53, -92, -2, -96, -54, 75};
        Assert.assertEquals(1, MinAbsoluteDifferenceArray.minimumAbsoluteDifference(input));
    }

    @Test
    public void test03() {
        int [] input = {1, -3, 71, 68, 17};
        Assert.assertEquals(3, MinAbsoluteDifferenceArray.minimumAbsoluteDifference(input));
    }
}