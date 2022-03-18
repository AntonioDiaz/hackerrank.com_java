package challenges.java.datastructures.trie;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

//https://www.hackerrank.com/challenges/contacts/problem

class TrieContacts {
  static class Node {
    int cont = 1;
    Map <Character, TrieContacts.Node> edges = new HashMap<>();
  }
  public static List<Integer> contacts(List<List<String>> queries) {
    List<Integer> results = new ArrayList<>();
    Node root = new Node();
    queries.forEach(e->{
      String action = e.get(0);
      String word = e.get(1);
      if ("add".equals(action)) {
        addString(root, word);
      }
      if ("find".equals(action)) {
        results.add(find (root, word));
      }
    });
    return results;
  }

  public static int find(Node root, String wordToFind) {
    Node node = root;
    for (int i = 0; i < wordToFind.length(); i++) {
      char currentChar = wordToFind.charAt(i);
      if (node.edges.containsKey(currentChar)) {
        node = node.edges.get(currentChar);
      } else {
        return 0;
      }
    }
    return node.cont;
  }

  public static Node addString(Node root, String wordToAdd) {
    Node node = root;
    for (int i = 0; i < wordToAdd.length(); i++) {
      char currentChar = wordToAdd.charAt(i);
      Node currentNode;
      if (node.edges.containsKey(currentChar)) {
        currentNode = node.edges.get(currentChar);
        currentNode.cont++;
      }  else {
        currentNode = new Node();
        node.edges.put(currentChar, currentNode);
      }
      node = currentNode;
    }
    return root;
  }
}