package challenges.java.errorhandling;

import org.junit.Test;

import java.util.InputMismatchException;

import static org.junit.Assert.*;

public class TryCatchExampleTest {

    @Test(expected = NumberFormatException.class)
    public void testIfIsNum() {
        String a = "a";
        Integer.parseInt(a);
    }

    @Test(expected = InputMismatchException.class)
    public void testDivision_InputMismatchException_first_parameter (){
        new TryCatchExample().divide("xxx", "1");
    }

    @Test(expected = InputMismatchException.class)
    public void testDivision_InputMismatchException_second_parameter (){
        new TryCatchExample().divide("1", "a");
    }

    @Test(expected = ArithmeticException.class)
    public void testDivision_ArithmeticException(){
        new TryCatchExample().divide("1", "0");
    }

    @Test
    public void testDivision(){
        int divide = new TryCatchExample().divide("10", "3");
        assertEquals(3, divide);
    }

}