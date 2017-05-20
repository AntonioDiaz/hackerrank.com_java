package algorithms.bitmanipulation.medium;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.math.BigInteger;
import java.util.*;

/**
 * Created by toni on 16/04/2017.
 */
public class SansaAndXOR {

    public static void main(String[] args) throws IOException {
        InputStream inputStream = SansaAndXOR.class.getClassLoader().getResourceAsStream("config.properties");
        Properties properties = new Properties();
        properties.load(inputStream);
        File file = new File(properties.getProperty("input.path") + "sansa_and_xor.txt");
        Scanner in = new Scanner(file);
        // Scanner in = new Scanner(System.in);
        int testCases = in.nextInt();
        for (int i = 0; i < testCases; i++) {
            Integer arrayElements = in.nextInt();
            int[] array = new int[arrayElements];
            for (int i1 = 0; i1 < arrayElements; i1++) {
                array[i1] = in.nextInt();
            }
            int myXor = calculateCongiguousXor(array);
            System.out.println(myXor);
        }
        in.close();
    }

    private static int calculateCongiguousXor(int[] array) {
        BigInteger xorBigInteger = BigInteger.valueOf(0);
        if (array.length%2==1) {
            for (int i = 0; i < array.length; i++) {
                if (i % 2 == 0) {
                    if (xorBigInteger == null) {
                        xorBigInteger = BigInteger.valueOf(array[i]);
                    } else {
                        xorBigInteger = xorBigInteger.xor(BigInteger.valueOf(array[i]));
                    }
                }
            }
        }
        return xorBigInteger.intValue();
    }
    private static int calculateCongiguousXorError(int[] array) {
        BigInteger xorBigInteger = BigInteger.valueOf(0);
        for (int i = 0; i < array.length; i++) {
            int m = (array.length - i) * (i + 1);
            if (m%2==1) {
                if (xorBigInteger==null) {
                    xorBigInteger = BigInteger.valueOf(array[i]);
                } else {
                    xorBigInteger = xorBigInteger.xor(BigInteger.valueOf(array[i]));
                }
            }
        }
        return xorBigInteger.intValue();
    }

    private static int calculateCongiguousXorSlow(int[] array) {
        Set<Integer> mySet = new HashSet<>();
        BigInteger xorBigInteger = BigInteger.valueOf(0);
        for (int i = 0; i < array.length; i++) {
            for (int j = i; j < array.length; j++) {
                for (int k = i; k <=j ; k++) {
                    if (mySet.contains(array[k])) {
                        mySet.remove(array[k]);
                    } else {
                        mySet.add(array[k]);
                    }
                }
            }
        }
        for (Integer integer : mySet) {
            xorBigInteger = xorBigInteger.xor(BigInteger.valueOf(integer));
        }
        return xorBigInteger.intValue();
    }
}
