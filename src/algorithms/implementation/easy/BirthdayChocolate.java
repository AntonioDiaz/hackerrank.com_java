package algorithms.implementation.easy;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;
import java.util.Scanner;

/**
 * Created by toni on 06/04/2017.
 */

public class BirthdayChocolate {

    public static void main(String[] args) throws IOException {
        InputStream inputStream = BirthdayChocolate.class.getClassLoader().getResourceAsStream("config.properties");
        Properties properties = new Properties();
        properties.load(inputStream);
        File file = new File(properties.getProperty("input.path") + "birthday_chocolate.txt");
        Scanner in = new Scanner(file);
        // Scanner in = new Scanner(System.in);
        int squares = in.nextInt();

        List<Integer> tablet = new ArrayList<>();
        for (int i = 0; i < squares; i++) {
            tablet.add(in.nextInt());
        }
        int d = in.nextInt();
        int m = in.nextInt();
        int countSquaresToShare = 0;
        for (int i = 0; i <= tablet.size() - m ; i++) {
            int countSum = 0;
            for (int j = i; j < i + m; j++) {
                countSum += tablet.get(j);
            }
            if (countSum==d) {
                countSquaresToShare++;
            }
        }
        System.out.println(countSquaresToShare);
        in.close();
    }

}
