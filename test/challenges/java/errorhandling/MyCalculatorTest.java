package challenges.java.errorhandling;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import static challenges.java.errorhandling.MyCalculator.N_AND_P_SHOULD_NOT_BE_ZERO;
import static challenges.java.errorhandling.MyCalculator.N_OR_P_SHOULD_NOT_BE_NEGATIVE;
import static org.junit.Assert.*;

public class MyCalculatorTest {

    @Rule
    public ExpectedException exceptionRule = ExpectedException.none();

    @Test
    public void power_both_zero() throws Exception {
        exceptionRule.expect(Exception.class);
        exceptionRule.expectMessage(N_AND_P_SHOULD_NOT_BE_ZERO);
        new MyCalculator().power(0, 0);
    }

    @Test
    public void power_one_negative() throws Exception {
        exceptionRule.expect(Exception.class);
        exceptionRule.expectMessage(N_OR_P_SHOULD_NOT_BE_NEGATIVE);
        new MyCalculator().power(-1, 0);
    }

    @Test
    public void power() throws Exception {
        long power = new MyCalculator().power(3, 5);
        assertEquals(243, power);
    }



}