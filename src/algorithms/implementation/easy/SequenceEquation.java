package algorithms.implementation.easy;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;
import java.util.Scanner;

/**
 * Created by toni on 06/04/2017.
 */

public class SequenceEquation {

    public static void main(String[] args) throws IOException {
        InputStream inputStream = SequenceEquation.class.getClassLoader().getResourceAsStream("config.properties");
        Properties properties = new Properties();
        properties.load(inputStream);
        File file = new File(properties.getProperty("input.path") + "sequence_equation.txt");
        Scanner in = new Scanner(file);
        // Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < n; i++) {
            map.put(in.nextInt() -1, i);
        }
        for (int i = 0; i < n; i++) {
            System.out.println(map.get(map.get(i)) + 1);
        }

        in.close();
    }

}


