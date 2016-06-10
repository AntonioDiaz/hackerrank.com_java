package moderate;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Properties;
import java.util.Scanner;

public class BreadthFirstSearch {

	public static void main(String[] args) throws IOException {
		InputStream input = BreadthFirstSearch.class.getClassLoader().getResourceAsStream("config.properties");
		Properties properties = new Properties();
		properties.load(input);
		File file = new File(properties.getProperty("input.path") + "breadth_first_search.txt");
		Scanner in = new Scanner(file);
		//Scanner in = new Scanner(System.in);
		int t = in.nextInt();
		for (int i = 0; i < t; i++) {
			int nodesCount = in.nextInt();
			int edgesCount = in.nextInt();
			Map<Integer, List<Integer>> graph = new HashMap<Integer, List<Integer>>();
			for (int j = 0; j < edgesCount; j++) {
				int x = in.nextInt();
				int y = in.nextInt();
				addEdgeGraph(graph, x, y);
				addEdgeGraph(graph, y, x);
			}
			int startNode = in.nextInt();
			Map<Integer, Integer> nodesVisited = new HashMap<Integer, Integer>();
			travelGraph (graph, startNode, nodesVisited, 0);
			for (int j = 1; j <= nodesCount; j++) {
				if (j!=startNode) {
					if (nodesVisited.containsKey(j)) {
						System.out.print(nodesVisited.get(j) + " ");
					} else {
						System.out.print(-1 + " ");
					}
				}
			}
			System.out.println();
		}
		in.close();
	}
	
	private static void addEdgeGraph(Map<Integer, List<Integer>> graph, int x, int y) {
		if (graph.get(x)!=null) {
			graph.get(x).add(y);				
		} else {
			List<Integer> children = new ArrayList<Integer>();
			children.add(y);
			graph.put(x, children);
		}
	}

	/**
	 * @param nodesVisited   */
	public static void travelGraph (Map<Integer, List<Integer>> graph, int startNode, Map<Integer, Integer> nodesVisited, Integer steps) {
		nodesVisited.put(startNode, steps * 6);
		List<Integer> children = graph.get(startNode);
		for (Integer child : children) {
			if (!nodesVisited.containsKey(child)) {
				travelGraph(graph, child, nodesVisited, steps + 1);
			}
		}
	}	
}