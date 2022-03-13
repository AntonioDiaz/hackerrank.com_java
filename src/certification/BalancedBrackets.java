package certification;

import java.util.LinkedList;
import java.util.Queue;

public class BalancedBrackets {


  private static boolean areMatched (char c1, char c2) {
    return (c1=='{' && c2=='}')
            || (c1=='[' && c2==']')
            || (c1=='(' && c2==')');
  }

  private static boolean isOpen(Character c) {
    return c=='{' || c=='[' || c=='(';
  }


  public static String isBalanced(String s) {
    LinkedList<Character> queue = new LinkedList<>();
    for (int i = 0; i < s.length(); i++) {
      Character c = s.charAt(i);
      if (isOpen(c)) {
        queue.add(c);
      } else {
        if (queue.isEmpty())
          return "NO";
        Character characterOpen = queue.removeLast();
        if (!areMatched(characterOpen, c)) {
          return "NO";
        }
      }

    }
    return queue.isEmpty()?"YES":"NO";
  }
}
