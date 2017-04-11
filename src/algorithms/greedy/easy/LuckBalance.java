package algorithms.greedy.easy;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.util.*;

/**
 * Created by toni on 11/04/2017.
 */
public class LuckBalance {
    public static void main(String[] args) throws IOException {
        InputStream inputStream = LuckBalance.class.getClassLoader().getResourceAsStream("config.properties");
        Properties properties = new Properties();
        properties.load(inputStream);
        File file = new File(properties.getProperty("input.path") + "luck_balance.txt");
        Scanner in = new Scanner(file);
        // Scanner in = new Scanner(System.in);
        int contestCount = in.nextInt();
        int contestLoses = in.nextInt();
        List<Integer> importantContest = new ArrayList<>();
        List<Integer> noImportantContest = new ArrayList<>();
        for (int i = 0; i < contestCount; i++) {
            int contestLuck = in.nextInt();
            if (in.nextInt()==1) {
                importantContest.add(contestLuck);
            } else {
                noImportantContest.add(contestLuck);
            }
        }
        Collections.sort(importantContest, Collections.<Integer>reverseOrder());
        int luck = 0;
        for (int i = 0; i < importantContest.size(); i++) {
            if (i<contestLoses) {
                luck += importantContest.get(i);
            } else {
                luck -= importantContest.get(i);
            }
        }
        for (Integer integer : noImportantContest) {
            luck += integer;
        }
        System.out.println(luck);
        in.close();
    }
}
