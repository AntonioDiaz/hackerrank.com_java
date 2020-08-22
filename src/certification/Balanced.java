package certification;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Scanner;

public class Balanced {
    public static boolean isBalanced(String input) {
        if (input.isEmpty()) {
            return true;
        }
        if (input.length()==1) {
            return false;
        }
        if (input.charAt(0)=='{') {
            if (input.charAt(1) == '}') {
                return isBalanced(input.substring(2));
            }
            if (input.charAt(input.length()-1) == '}') {
                return isBalanced(input.substring(1, input.length() - 1));
            }
        }
        if (input.charAt(0)=='(') {
            if (input.charAt(1) == ')') {
                return isBalanced(input.substring(2));
            }
            if (input.charAt(input.length()-1) == ')') {
                return isBalanced(input.substring(1, input.length() - 1));
            }
        }
        return false;
    }
}
