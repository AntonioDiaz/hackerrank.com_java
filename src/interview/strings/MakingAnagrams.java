package interview.strings;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class MakingAnagrams {

    int makeAnagram(String a, String b) {
        int charsToDelete = 0;
        for (char c : a.toCharArray()) {
            String s = Character.toString(c);
            if (!b.contains(s)) {
                charsToDelete++;
            } else {
                b = b.replaceFirst(s, "");
            }
        }
        return charsToDelete + b.length();
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        String a = scanner.nextLine();

        String b = scanner.nextLine();

        int res = (new MakingAnagrams()).makeAnagram(a, b);

        bufferedWriter.write(String.valueOf(res));
        bufferedWriter.newLine();

        bufferedWriter.close();

        scanner.close();
    }
}
