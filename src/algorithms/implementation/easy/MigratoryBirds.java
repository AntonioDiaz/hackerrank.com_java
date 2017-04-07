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
public class MigratoryBirds {

    private static final int NUMBER_TYPES = 5;
    
    public static void main(String[] args) throws IOException {

        InputStream inputStream = MigratoryBirds.class.getClassLoader().getResourceAsStream("config.properties");
        Properties properties = new Properties();
        properties.load(inputStream);
        File file = new File(properties.getProperty("input.path") + "migratory_birds.txt");
        Scanner in = new Scanner(file);
        // Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        List<Integer> typesList = new ArrayList<>();
        for (int i = 0; i < NUMBER_TYPES; i++) {
            typesList.add(0);
        }

        for (int i = 0; i < n; i++) {
            int myType = in.nextInt() - 1;
            typesList.set(myType, typesList.get(myType) + 1);
        }

        int maxNumberType = Integer.MIN_VALUE;
        int maxType = 0;
        for (int i = 0; i < NUMBER_TYPES; i++) {
            if (maxNumberType<typesList.get(i)) {
                maxNumberType = typesList.get(i);
                maxType = i;
            }
        }


        System.out.println(maxType + 1);
        in.close();
    }
}
