/**
 * https://www.hackerrank.com/challenges/java-exception-handling-try-catch/problem?h_r=next-challenge&h_v=zen
 * */
package challenges.java.errorhandling;


import java.util.InputMismatchException;
import java.util.Scanner;

public class TryCatchExample {

    public int divide(String a, String b) throws InputMismatchException, ArithmeticException {
        int intA;
        int intB;
        try {
            intA = Integer.parseInt(a);
            intB = Integer.parseInt(b);
        } catch (NumberFormatException e) {
            throw new InputMismatchException();
        }
        if (intB==0) {
            throw new ArithmeticException();
        }
        return intA/intB;
    }


    public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
        Scanner in = new Scanner(System.in);
        String firstInput = in.next();
        String secondInput = in.next();
        try {
            System.out.println(new TryCatchExample().divide(firstInput, secondInput));
        } catch (InputMismatchException e) {
            System.out.println("java.util.InputMismatchException");
        } catch (ArithmeticException e) {
            System.out.println("java.lang.ArithmeticException: / by zero");
        }
        in.close();
    }
}
