package challenges.java.objectoriendedprogramming.interfaceexample;

import org.junit.Test;

import java.util.stream.IntStream;

import static org.junit.Assert.assertEquals;

public class MyCalculatorTest {

    @Test
    public void testRange() {
        int n = 6;
        int sum = IntStream.rangeClosed(1, n).filter(i-> n%i==0).sum();
        assertEquals(12, sum);
    }

    @Test
    public void divisor_sum() {
        MyCalculator myCalculator = new MyCalculator();
        assertEquals(12, myCalculator.divisorSum(6));
    }
}