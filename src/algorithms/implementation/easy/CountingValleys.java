package algorithms.implementation.easy;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;
import java.util.Scanner;

/**
 * Created by toni on 07/04/2017.
 */
public class CountingValleys {

    private static final char UP_CHAR = 'U';
    private static final char DOWN_CHAR = 'D';

    public static void main(String[] args) throws IOException {
        InputStream inputStream = CountingValleys.class.getClassLoader().getResourceAsStream("config.properties");
        Properties properties = new Properties();
        properties.load(inputStream);
        File file = new File(properties.getProperty("input.path") + "counting_valleys.txt");
        Scanner in = new Scanner(file);
        // Scanner in = new Scanner(System.in);
        int stepsNum = in.nextInt();
        String stepsStr = in.next();
        int levelsOverTheSea = 0;
        int valleysCount = 0;
        for (int i = 0; i < stepsNum; i++) {
            if (stepsStr.charAt(i)==UP_CHAR) {
                levelsOverTheSea++;
            } else {
                levelsOverTheSea--;
            }
            if (levelsOverTheSea==0 && stepsStr.charAt(i)==UP_CHAR) {
                valleysCount++;
            }
        }
        System.out.println(valleysCount);
        in.close();
    }
}
