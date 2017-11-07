package algorithms.implementation.easy;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;
import java.util.Scanner;

/** Created by toni on 21/06/2017. */

public class FormingMagicSquare {
    public static void main(String[] args) throws IOException {
        InputStream inputStream = FormingMagicSquare.class.getClassLoader().getResourceAsStream("config.properties");
        Properties properties = new Properties();
        properties.load(inputStream);
        File file = new File(properties.getProperty("input.path") + "repeated_string.txt");
        Scanner in = new Scanner(file);
        // Scanner in = new Scanner(System.in);
        in.close();
    }

}
