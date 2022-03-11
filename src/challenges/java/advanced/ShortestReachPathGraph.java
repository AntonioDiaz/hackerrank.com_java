package challenges.java.advanced;

import java.util.List;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

//https://www.hackerrank.com/challenges/ctci-bfs-shortest-reach/

public class ShortestReachPathGraph {

  static List<Integer> calculateDistances(List<List<Integer>> graph, Integer startNode) {
    List<Integer> distances = new ArrayList<>();
    IntStream.range(0, graph.size()).forEach(e -> distances.add(-1));
    distances.set(startNode, 0);
    Queue<Integer> queue = new LinkedList<>();
    queue.add(startNode);
    while (!queue.isEmpty()) {
      Integer currentNode = queue.poll();
      for (Integer nextNode : graph.get(currentNode)) {
        //only adding next node if is not the start to avoid cycles and if the distance is shorter.
        if (!nextNode.equals(startNode) && distances.get(nextNode) == -1) {
          distances.set(nextNode, distances.get(currentNode) + 1);
          queue.add(nextNode);
        }
      }
    }
    return distances.stream().filter(e -> !e.equals(0)).map(e -> e == -1 ? e : e * 6).collect(Collectors.toList());
  }

  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);
    int cases = Integer.parseInt(scanner.nextLine());

    for (int i = 0; i < cases; i++) {
      String firstLine = scanner.nextLine();
      int nodes = Integer.parseInt(firstLine.split(" ")[0]);
      int edges = Integer.parseInt(firstLine.split(" ")[1]);
      //System.out.println(nodes + " " + edges);
      List<List<Integer>> graph = new ArrayList<>();
      IntStream.range(0, nodes).forEach(j -> graph.add(new ArrayList<>()));
      for (int j = 0; j < edges; j++) {
        String edgeLine = scanner.nextLine();
        int nodeA = Integer.parseInt(edgeLine.split(" ")[0]) - 1;
        int nodeB = Integer.parseInt(edgeLine.split(" ")[1]) - 1;
        graph.get(nodeA).add(nodeB);
        graph.get(nodeB).add(nodeA);
      }
      String startNodeStr = scanner.nextLine();
      Integer startNode = Integer.parseInt(startNodeStr) - 1;
      List<Integer> distances = ShortestReachPathGraph.calculateDistances(graph, startNode);
      String distancesString = distances.stream().map(e -> Integer.toString(e)).collect(Collectors.joining(" "));
      System.out.println("distances: " + distancesString);
    }
    scanner.close();
  }

}
