package algorithms.implementation.easy;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;
import java.util.Scanner;

/**
 * Created by toni on 13/04/2017.
 */
public class PickingNumbers {

    public static void main(String[] args) throws IOException {
        InputStream inputStream = PickingNumbers.class.getClassLoader().getResourceAsStream("config.properties");
        Properties properties = new Properties();
        properties.load(inputStream);
        File file = new File(properties.getProperty("input.path") + "picking_numbers.txt");
        Scanner in = new Scanner(file);
        // Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        List<Integer> numbersArround = new ArrayList<>();
        for (int i = 0; i < 100; i++) {
            numbersArround.add(0);
        }
        for (int i = 0; i < n; i++) {
            int myNumber = in.nextInt() -1;
            numbersArround.set(myNumber, numbersArround.get(myNumber) + 1);
        }
        int maxGroup = 0;
        for (int i = 0; i < n -1; i++) {
            int currentGroup = numbersArround.get(i) + numbersArround.get(i + 1);
            if (currentGroup>maxGroup) {
                maxGroup = currentGroup;
            }
        }
        System.out.println(maxGroup);
        in.close();
    }
}
