package algorithms.greedy.easy;

import java.io.*;
import java.util.*;

/**
 * Created by toni on 12/04/2017.
 */
public class MaximumPerimeterTriangle {

    public static void main(String[] args) throws IOException {
        InputStream inputStream = MaximumPerimeterTriangle.class.getClassLoader().getResourceAsStream("config.properties");
        Properties properties = new Properties();
        properties.load(inputStream);
        File file = new File(properties.getProperty("input.path") + "maximun_perimeter_triangle.txt");
        Scanner in = new Scanner(file);
        // Scanner in = new Scanner(System.in);
        int sticksNumber = in.nextInt();
        List<Integer> sticksList = new ArrayList<>();
        for (int i = 0; i < sticksNumber; i++) {
            sticksList.add(in.nextInt());
        }
        Collections.sort(sticksList, Collections.<Integer>reverseOrder());
        int n = 0;
        while (n<sticksList.size() - 2) {
            if (isNonGenerateTrianble(sticksList.get(n), sticksList.get(n + 1), sticksList.get(n + 2))) {
                System.out.print(sticksList.get(n + 2) + " ");
                System.out.print(sticksList.get(n + 1) + " ");
                System.out.print(sticksList.get(n));
                return;
            }
            n++;
        }
        System.out.println("-1");
        in.close();
    }


    private static boolean isNonGenerateTrianble(Integer x, Integer y, Integer z) {
        return y + z > x;
    }
}
