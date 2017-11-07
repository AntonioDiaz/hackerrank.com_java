package algorithms.graphtheory.medium;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Properties;
import java.util.Scanner;
import java.util.Set;

public class BreadthFirstSearch {

	public static void main(String[] args) throws IOException {
		InputStream input = BreadthFirstSearch.class.getClassLoader().getResourceAsStream("config.properties");
		Properties properties = new Properties();
		properties.load(input);
		File file = new File(properties.getProperty("input.path") + "breadth_first_search_02.txt");
		Scanner in = new Scanner(file);
		// Scanner in = new Scanner(System.in);
		int t = in.nextInt();
		for (int i = 0; i < t; i++) {
			int nodesCount = in.nextInt();
			int edgesCount = in.nextInt();
			Map<Integer, Set<Integer>> graph = new HashMap<Integer, Set<Integer>>();
			for (int j = 0; j < edgesCount; j++) {
				int x = in.nextInt();
				int y = in.nextInt();
				addEdgeGraph(graph, x, y);
				addEdgeGraph(graph, y, x);
			}
			int startNode = in.nextInt();
			// Map<Integer, Integer> nodesVisited = new HashMap<Integer, Integer>();
			List<Integer> queue = new ArrayList<Integer>();
			Map<Integer, Integer> visited = new HashMap<Integer, Integer>();
			Map<Integer, Integer> parents = new HashMap<Integer, Integer>();
			// visited.put(startNode, 0);
			queue.add(startNode);
			while (queue.size() > 0) {
				Integer node = queue.get(0);
				queue.remove(0);
				/* getting parent distance */
				int distance = 0;
				if (parents.containsKey(node)) {
					distance = visited.get(parents.get(node)) + 1;
				}
				visited.put(node, distance);
				Set<Integer> children = graph.get(node);
				if (children != null) {
					for (Integer son : children) {
						if (!visited.containsKey(son) && !queue.contains(son)) {
							parents.put(son, node);
							queue.add(son);
						}
					}
				}
			}
			for (int j = 1; j <= nodesCount; j++) { 
				if (j!=startNode) { 
					if (visited.containsKey(j)) { 
						System.out.print(visited.get(j) * 6 + " "); 
					} else { 
						System.out.print(-1 + " "); 
					} 
				} 
			}
			System.out.println();
		}
		in.close();
	}

	private static void addEdgeGraph(Map<Integer, Set<Integer>> graph, int x, int y) {
		if (graph.get(x) != null) {
			graph.get(x).add(y);
		} else {
			Set<Integer> children = new HashSet<Integer>();
			children.add(y);
			graph.put(x, children);
		}
	}
}