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
		int t = in.nextInt();
		for (int i = 0; i < t; i++) {
			int nodesCount = in.nextInt();
			int edgesCount = in.nextInt();
			Map<Integer, List<Integer>> graph = new HashMap<Integer, List<Integer>>();
			for (int j = 0; j < edgesCount; j++) {
				int from = in.nextInt();
				int to = in.nextInt();
				if (graph.get(from)!=null) {
					graph.get(from).add(to);				
				} else {
					List<Integer> children = new ArrayList<Integer>();
					children.add(to);
					graph.put(from, children);
				}
				if (graph.get(to)==null) {
					graph.put(to, new ArrayList<Integer>());
				}				
			}
			int startNode = in.nextInt();
			System.out.println(startNode);
		}
		in.close();
	}
}
