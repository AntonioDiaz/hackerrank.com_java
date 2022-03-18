package challenges.java.datastructures.trie;


import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

//https://www.hackerrank.com/challenges/no-prefix-set/
public class NoPrefixSet {

  static class Node {
    boolean endWord = false;
    Map<Character, Node> edges = new HashMap<>();
  }

  public static boolean addWord (String word, Node root) {
    Node node = root;
    boolean isPrefix = true;
    boolean thereWasPrefix = false;
    for (int i = 0; i < word.length(); i++) {
      char currentChar = word.charAt(i);
      if (node.edges.containsKey(currentChar)) {
        node = node.edges.get(currentChar);
        if (node.endWord) {
          thereWasPrefix = true;
        }
      } else {
        Node newNode = new Node();
        node.edges.put(currentChar, newNode);
        node = newNode;
        isPrefix = false;
      }
    }
    node.endWord = true;
    return isPrefix || thereWasPrefix;
  }


  public static Optional<String> findFirstPrefix(List<String> words) {
    Node root = new Node();
    for (String word : words) {
      if (addWord(word, root)) {
        return Optional.of(word);
      }
    }
    return Optional.empty();
  }

  public static void noPrefix(List<String> words) {
    findFirstPrefix(words).ifPresentOrElse(
            e -> System.out.println("BAD SET \n" + e),
            () -> System.out.println("GOOD SET"));
  }

}
