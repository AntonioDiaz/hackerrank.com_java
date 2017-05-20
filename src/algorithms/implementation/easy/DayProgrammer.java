package algorithms.implementation.easy;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;
import java.util.Scanner;

/** Created by toni on 20/05/2017. */

public class DayProgrammer {

    public static void main(String[] args) throws IOException {
        InputStream inputStream = DayProgrammer.class.getClassLoader().getResourceAsStream("config.properties");
        Properties properties = new Properties();
        properties.load(inputStream);
        File file = new File(properties.getProperty("input.path") + "day_programmer.txt");
        Scanner in = new Scanner(file);
        // Scanner in = new Scanner(System.in);
        int year = in.nextInt();
        String programmerDay;
        if (year <= 1917) {
            if (year % 4 == 0) {
                programmerDay = "12.09." + year;
            } else {
                programmerDay = "13.09." + year;
            }
        } else if (year>1918) {
            if (year%400==0 || (year%4==0 && !(year%100==0)) ) {
                programmerDay = "12.09." + year;
            } else {
                programmerDay = "13.09." + year;
            }
        } else {
            programmerDay = "26.09." + year;
        }
        System.out.println(programmerDay);
        in.close();
    }
}
