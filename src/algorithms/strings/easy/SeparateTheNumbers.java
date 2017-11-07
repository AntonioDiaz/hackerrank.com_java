package algorithms.strings.easy;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.math.BigInteger;
import java.util.Properties;
import java.util.Scanner;

/**
 * Created by toni on 08/04/2017.
 */
public class SeparateTheNumbers {

    public static final String NOT_FOUND = "-1";

    public static void main(String[] args) throws IOException {
        InputStream inputStream = SeparateTheNumbers.class.getClassLoader().getResourceAsStream("config.properties");
        Properties properties = new Properties();
        properties.load(inputStream);
        File file = new File(properties.getProperty("input.path") + "separate_the_numbers.txt");
        Scanner in = new Scanner(file);
        // Scanner in = new Scanner(System.in);
        int cases = in.nextInt();
        for (int i = 0; i < cases; i++) {
            String n = in.next();
            String firstNumber = isBeautiful(n);
            System.out.println(firstNumber.equals(NOT_FOUND) ? "NO" : "YES " + firstNumber);
        }
        in.close();
    }

    public static String isBeautiful(String n) {
        String firstNumber = NOT_FOUND;
        for (int i = 1; i < n.length(); i++) {
            BigInteger actualNumber = new BigInteger(n.substring(0, i));
            firstNumber = n.substring(0, i);
            int nextNumberIndex = i;
            boolean isNext = false;
            do {
                String nextNumberStr = actualNumber.add(new BigInteger("1")).toString();
                isNext = n.startsWith(nextNumberStr, nextNumberIndex);
                nextNumberIndex += nextNumberStr.length();
                actualNumber = new BigInteger(nextNumberStr);
            } while (nextNumberIndex < n.length() && isNext);
            if (isNext) {
                return firstNumber;
            }
        }
        return NOT_FOUND;
    }

}
