package algorithms.implementation.easy;

/* Created by toni on 04/04/2017. */

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;
import java.util.Scanner;

public class TheHurdleRace {


    public static void main(String[] args) throws IOException {
        InputStream inputStream = TheHurdleRace.class.getClassLoader().getResourceAsStream("config.properties");
        Properties properties = new Properties();
        properties.load(inputStream);
        File file = new File(properties.getProperty("input.path") + "the_hurdle_race.txt");
        Scanner in = new Scanner(file);
        // Scanner in = new Scanner(System.in);
        int jumps = in.nextInt();
        int maxHeightCanJump = in.nextInt();
        int maxHudlesHeight = Integer.MIN_VALUE;
        for (int i = 0; i < jumps; i++) {
            int hudlesHeight = in.nextInt();
            if (hudlesHeight>maxHudlesHeight) {
                maxHudlesHeight = hudlesHeight;
            }
        }
        int drinks = maxHudlesHeight - maxHeightCanJump;
        System.out.println(drinks>0?drinks:0);
        in.close();

    }

}
