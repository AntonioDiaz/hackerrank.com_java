package algorithms.greedy.easy;


//https://www.hackerrank.com/challenges/jim-and-the-orders/problem?isFullScreen=false

import java.util.AbstractMap;
import java.util.ArrayList;
import java.util.List;

import static java.util.stream.Collectors.toList;

public class JimAndTheOrders {

  public static List<Integer> jimOrders(List<List<Integer>> orders) {
    // Write your code here
    List<AbstractMap.SimpleEntry<Integer, Integer>> sum = new ArrayList<>();
    for (int i = 0; i < orders.size(); i++) {
      sum.add(new AbstractMap.SimpleEntry<>(i + 1, orders.get(i).get(0) + orders.get(i).get(1)));
    }
    return sum.stream()
            .sorted((a, b) -> (a.getValue().equals(b.getValue()) ? (a.getKey() - b.getKey()) : (a.getValue() - b.getValue())))
            .map(AbstractMap.SimpleEntry::getKey)
            .collect(toList());
  }
}

