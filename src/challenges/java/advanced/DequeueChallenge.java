package challenges.java.advanced;

/** https://www.hackerrank.com/challenges/java-dequeue/problem */

import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;
import java.util.stream.Collectors;

public class DequeueChallenge {

  public static void main(String[] args) throws FileNotFoundException {
    ClassLoader classLoader = new JavaVisitorPattern().getClass().getClassLoader();
    File file = new File(classLoader.getResource("deque_01.txt").getFile());
    Scanner in = new Scanner(file);
    //Scanner in = new Scanner(System.in);
    Deque<Integer> deque = new ArrayDeque<>();
    Set<Integer> setOccurrences = new HashSet<>();
    Map<Integer, Integer> mapOccurrences = new HashMap<>();
    int n = in.nextInt();
    int setElementsCount = in.nextInt();
    long numElements = 0;
    int cyclesCount = 0;
    for (int i = 0; i < n; i++) {
      Integer added = in.nextInt();
      Integer removed = null;
      deque.addFirst(added);
      if (!mapOccurrences.containsKey(added)) {
        mapOccurrences.put(added, 0);
      }
      if (i>=setElementsCount) {
        cyclesCount++;
        removed = deque.removeLast();
      }
      mapOccurrences.put(added, mapOccurrences.get(added) + 1);
      setOccurrences.add(added);
      if (removed!=null) {
        mapOccurrences.put(removed, mapOccurrences.get(removed) - 1);
        if (mapOccurrences.get(removed) == 0) {
          setOccurrences.remove(removed);
        }
      }
      System.out.println("deque =" + deque);
      System.out.println("mapOccurrences =" + mapOccurrences);
      System.out.println("setOccurrences " + setOccurrences);
      System.out.println("----------------");
      if (deque.size()==setElementsCount) {
        long count = setOccurrences.size();
        if (count>numElements) {
          numElements = count;
        }
      }
    }
    System.out.println(numElements);
    System.out.println("cyclescount " + cyclesCount);
  }
}
