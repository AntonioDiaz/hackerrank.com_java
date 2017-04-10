package algorithms.greedy.easy;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.math.BigInteger;
import java.util.*;

/**
 * Created by toni on 10/04/2017.
 */
public class MarcsCakewalk {
    public static void main(String[] args) throws IOException {
        InputStream inputStream = MarcsCakewalk.class.getClassLoader().getResourceAsStream("config.properties");
        Properties properties = new Properties();
        properties.load(inputStream);
        File file = new File(properties.getProperty("input.path") + "marcs_cakewalk.txt");
        Scanner in = new Scanner(file);
        // Scanner in = new Scanner(System.in);
        int cakesCount = in.nextInt();
        BigInteger miles = BigInteger.valueOf(0);
        List<Integer> cakesList = new ArrayList<>();
        for (int i = 0; i < cakesCount; i++) {
            cakesList.add(in.nextInt());
        }
        Collections.sort(cakesList, Collections.reverseOrder());
        for (int i = 0; i < cakesList.size(); i++) {
            BigInteger calories = BigInteger.valueOf(cakesList.get(i));
            miles = miles.add(BigInteger.valueOf(2).pow(i).multiply(calories));
        }
        System.out.println(miles);
        in.close();
    }
}
