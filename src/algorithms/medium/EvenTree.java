package algorithms.medium;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Properties;
import java.util.Scanner;
import java.util.Set;

public class EvenTree {

	public static void main(String[] args) throws IOException {
		InputStream input = EvenTree.class.getClassLoader().getResourceAsStream("config.properties");
		Properties properties = new Properties();
		properties.load(input);
		File file = new File(properties.getProperty("input.path") + "even_tree.txt");
		Scanner in = new Scanner(file);
		Map<Integer, List<Integer>> graph = new HashMap<Integer, List<Integer>>();
		in.nextInt();
		in.nextInt();
		while(in.hasNextLine()) {
			int to = in.nextInt();
			int from = in.nextInt();
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
		Set<Integer> keySet = graph.keySet();
		int cont = 0;
		for (Integer n : keySet) {
			System.out.println(n + "-" + calculateDesdendents(graph, n));
			if (calculateDesdendents(graph, n)%2==1) {
				cont++;
			}
		}
		System.out.println(cont-1);
		in.close();
	}
	
	public static final int calculateDesdendents(Map<Integer, List<Integer>> graph, int node) {
		int descendent = 0;
		List<Integer> children = graph.get(node);
		for (Integer child : children) {
			descendent += (1 + calculateDesdendents(graph, child)); 
		}
		return descendent;
	}
}
