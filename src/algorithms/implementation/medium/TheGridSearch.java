package algorithms.implementation.medium;

import java.io.FileNotFoundException;
import java.util.Scanner;

public class TheGridSearch {

	public static void main(String[] args) throws FileNotFoundException {
		//File file = new File(INPUT);
		Scanner in = new Scanner(System.in);
		int t = in.nextInt();
		for (int a0 = 0; a0 < t; a0++) {
			int R = in.nextInt();
			in.nextInt();
			String G[] = new String[R];
			for (int G_i = 0; G_i < R; G_i++) {
				G[G_i] = in.next();
			}
			int r = in.nextInt();
			in.nextInt();
			String P[] = new String[r];
			for (int P_i = 0; P_i < r; P_i++) {
				P[P_i] = in.next();
			}
			Boolean matches = false;
			for (int i=0; i<G.length && !matches; i++) {
				int indexFrom = G[i].indexOf(P[0], 0);
				while(indexFrom!=-1 && !matches) {
					Boolean found = true;
					for (int j=1; j<P.length && found; j++) {
						String subLine = G[i+j].substring(indexFrom, indexFrom + P[j].length());
						found = subLine.equals(P[j]);
					}
					if (found) {
						matches = true;
					}
					indexFrom = G[i].indexOf(P[0], indexFrom + 1);
				}
			}
			System.out.println(matches?"YES":"NO");
		}
		in.close();
	}
}
