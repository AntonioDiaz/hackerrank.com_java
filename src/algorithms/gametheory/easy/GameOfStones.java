package algorithms.gametheory.easy;

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
public class GameOfStones {
    public static void main(String[] args) throws IOException {
        InputStream inputStream = GameOfStones.class.getClassLoader().getResourceAsStream("config.properties");
        Properties properties = new Properties();
        properties.load(inputStream);
        File file = new File(properties.getProperty("input.path") + "game_of_stones.txt");
        Scanner in = new Scanner(file);
        // Scanner in = new Scanner(System.in);
        int testCases = in.nextInt();
        List<Boolean> firstWinsList = new ArrayList<>();
        for (int i = 0; i <= 100; i++) {
            if (i==0 || i==1 || i==7) {
                firstWinsList.add(false);
            } else if (i>1 && i<7) {
                firstWinsList.add(true);
            } else {
                /* posibilities are: */
                if (firstWinsList.get(i-2) && firstWinsList.get(i-3) && firstWinsList.get(i-5)) {
                    firstWinsList.add(false);
                } else {
                    firstWinsList.add(true);
                }
             }
        }
        for (int i = 0; i < testCases; i++) {
            //System.out.println((i) + " " + firstWinsList.get(i));
            System.out.println(firstWinsList.get(in.nextInt()) ? "First" : "Second");
        }
        in.close();
    }

    private static boolean firstToPlayWin(int i) {
        return false;
    }


}
