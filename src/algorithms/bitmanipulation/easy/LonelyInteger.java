package algorithms.bitmanipulation.easy;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class LonelyInteger {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int n = in.nextInt();
		Set<Integer> set = new HashSet<Integer>();
		for (int i = 0; i < n; i++) {
			Integer integer = in.nextInt();
			if (set.contains(integer)) {
				set.remove(integer);
			} else {
				set.add(integer);
			}				
		}
		System.out.println(set.toArray()[0]);
		in.close();
	}
	
}
