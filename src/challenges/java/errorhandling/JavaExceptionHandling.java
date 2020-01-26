/**
 * https://www.hackerrank.com/challenges/java-exception-handling/problem?h_r=next-challenge&h_v=zen&h_r=next-challenge&h_v=zen
 */
package challenges.java.errorhandling;


import java.util.Scanner;

class MyCalculator {

    public static final String N_OR_P_SHOULD_NOT_BE_NEGATIVE = "n or p should not be negative.";
    public static final String N_AND_P_SHOULD_NOT_BE_ZERO = "n and p should not be zero.";

    public long power(int n, int p) throws Exception {
        if (n<0 || p<0) {
            throw new Exception(N_OR_P_SHOULD_NOT_BE_NEGATIVE);
        }
        if (n==0 && p==0) {
            throw new Exception(N_AND_P_SHOULD_NOT_BE_ZERO);
        }
        Double nDouble = Double.parseDouble(Integer.toString(n));
        Double pDouble = Double.parseDouble(Integer.toString(p));
        return (long)Math.pow(nDouble, pDouble);
    }
}

public class JavaExceptionHandling {

    public static final MyCalculator myCalculator = new MyCalculator();
    public static final Scanner in = new Scanner(System.in);

    public static void main(String[] args) {
        while (in .hasNextInt()) {
            int n = in .nextInt();
            int p = in .nextInt();
            try {
                System.out.println(myCalculator.power(n, p));
            } catch (Exception e) {
                System.out.println(e);
            }
        }
    }

}
