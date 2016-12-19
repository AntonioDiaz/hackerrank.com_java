package algorithms.implementation.medium;

import java.io.File;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;
import java.util.Scanner;

public class AbsolutePermutation {

	private Integer n;
	private Integer k;

	public AbsolutePermutation(Integer n, Integer k) {
		this.n = n;
		this.k = k;
	}
	public static void main (String[] args) throws Exception{
		InputStream input = AbsolutePermutation.class.getClassLoader().getResourceAsStream("config.properties");
		Properties properties = new Properties();
		properties.load(input);
		File file = new File(properties.getProperty("input.path") + "absolute_position_09.txt");
		File fileOutput = new File(properties.getProperty("input.path") + "absolute_position_09_output.txt");
		Scanner in = new Scanner(file);
		Scanner out = new Scanner(fileOutput);
		//Scanner in = new Scanner(System.in);
		int testCases = in.nextInt();
		for (int i = 0; i < testCases; i++) {
			String permutationsExpected = out.nextLine();			
			System.out.println(permutationsExpected);
			int n = in.nextInt();
			int k = in.nextInt();
			AbsolutePermutation absolutePermutation = new AbsolutePermutation(n, k);
			List<Integer> permutation = absolutePermutation.calculatePermutation();
			String strPermutation = listToString(permutation);
			System.out.println(permutationsExpected.equals(strPermutation));
		}
		in.close();
		out.close();
	}

	/** -If n is an even number (n%k == 0) lets you know if there is a valid permutation or you should just print -1 -If k=0 just print 1...
	 * n -If n is an odd number and it also is greater than 0, print -1
	 * 
	 * @return */

	public List<Integer> calculatePermutation() {
		List<Integer> permutation = new ArrayList<Integer>();
		if (k==0) {
			for (int i = 1; i <= this.n; i++) {
				permutation.add(i);
			}
		} else if (n%k==0) {
			for (int i = 1; i <= this.n; i++) {
				int pos = i - k;
				int iTaken = pos - k;
				if (pos <= 0 || (iTaken > 0 && permutation.get(iTaken-1) == pos)) {
					pos = i + k;
				}
				permutation.add(pos);
			}			
		} else {
			permutation.add(-1);
		}
		return permutation;
	}

	public static String listToString(List<Integer> list) {
		StringBuilder strConverted = new StringBuilder("");
		for (int i = 0; i < list.size(); i++) {
			strConverted.append(list.get(i));
			if (i < list.size() - 1) {
				strConverted.append(" ");
			}
		}
		return strConverted.toString();
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
