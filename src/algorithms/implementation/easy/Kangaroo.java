package algorithms.implementation.easy;

import java.util.Scanner;

public class Kangaroo {

	public static void main(String[] args) throws Exception {
		Scanner in = new Scanner(System.in);
        int x1 = in.nextInt();
        int v1 = in.nextInt();
        int x2 = in.nextInt();
        int v2 = in.nextInt();
        while (x1<x2) {
        	x1 += v1;
        	x2 += v2;
        }
        System.out.println(x1==x2?"YES":"NO");
		in.close();
	}
}
