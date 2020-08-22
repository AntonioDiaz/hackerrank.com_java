package algorithms.greedy.easy;

import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

public class GridChallengeTest {

    @Test
    public void test01 () {
        String[] input = {"ebacd","fghij","olmkn","trpqs","xywuv"};
        Assert.assertEquals("YES", GridChallenge.gridChallenge(input));
    }
}