package algorithms.strings.easy;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;
import java.util.Scanner;

/**
 * Created by toni on 08/04/2017.
 */
public class HackerRankInAString {
    private static final String WORD_TO_FIND  = "hackerrank";
    public static void main(String[] args) throws IOException {
        InputStream inputStream = HackerRankInAString.class.getClassLoader().getResourceAsStream("config.properties");
        Properties properties = new Properties();
        properties.load(inputStream);
        File file = new File(properties.getProperty("input.path") + "hackerrank_string.txt");
        Scanner in = new Scanner(file);
        // Scanner in = new Scanner(System.in);
        int queries = in.nextInt();
        for (int i = 0; i < queries; i++) {
            String line = in.next();
            boolean found = findWord (WORD_TO_FIND, line);
            System.out.println(found?"YES":"NO");

        }
        in.close();
    }

    private static boolean findWord(String wordToFind, String line) {
        byte[] wordBytes = wordToFind.getBytes();
        int wordBytesIndex = 0;
        byte[] lineBytes = line.getBytes();
        for (int i = 0; i < lineBytes.length && wordBytesIndex<wordBytes.length; i++) {
            if (lineBytes[i]==wordBytes[wordBytesIndex]) {
                wordBytesIndex++;
            }
        }
        return wordBytesIndex==wordBytes.length;
    }
}
