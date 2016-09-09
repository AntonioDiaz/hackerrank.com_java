package algorithms.medium;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class AbsolutePermutation {

	private Integer n;
	private Integer k;

	public AbsolutePermutation(Integer n, Integer k) {
		this.n = n;
		this.k = k;
	}

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int testCases = in.nextInt();
		for (int i = 0; i < testCases; i++) {
			int n = in.nextInt();
			int k = in.nextInt();
			AbsolutePermutation absolutePermutation = new AbsolutePermutation(n, k);
			System.out.println(listToString(absolutePermutation.calculatePermutation()));
		}
		in.close();
	}

	/**
	 * -If n is an even number (n%k == 0) lets you know if there is a valid permutation or you should just print -1
	 * -If k=0 just print 1... n
	 * -If n is an odd number and it also is greater than 0, print -1
	 * @return
	 */	
	
	public List<Integer> calculatePermutation() {
		List<Integer> permutation = new ArrayList<Integer>();
		if (this.k == 0) {
			for (int i = 0; i < n; i++) {
				permutation.add(i + 1);
			}
		} else if (this.k == n - 1 && k==1 ) {
			for (int i = n - 1; i >= 0; i--) {
				permutation.add(i + 1);
			}
		} else {
			permutation.add(-1);
		}
		return permutation;
	}

	private static String listToString(List<Integer> list) {
		String strConverted = "";
		for (int i = 0; i < list.size(); i++) {
			strConverted += list.get(i);
			if (i<list.size()-1) {
				strConverted += " ";
			}
		}
		return strConverted;
	}
	
	public Integer getN() {
		return n;
	}

	public void setN(Integer n) {
		this.n = n;
	}

	public Integer getK() {
		return k;
	}

	public void setK(Integer k) {
		this.k = k;
	}

}
