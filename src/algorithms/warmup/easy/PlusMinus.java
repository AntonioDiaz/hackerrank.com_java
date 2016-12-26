package algorithms.warmup.easy;

import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.util.Locale;
import java.util.Scanner;

public class PlusMinus {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int n = in.nextInt();
		int positives = 0;
		int negatives = 0;
		int zeros = 0;
		for (int i = 0; i < n; i++) {
			int p = in.nextInt();
			if (p > 0) {
				positives++;
			} else if (p < 0) {
				negatives++;
			} else {
				zeros++;
			}
		}
		in.close();
		
		double fPositives = (double)positives / (double)n;
		double fNegatives = (double)negatives / (double)n;
		double fZeros = (double)zeros / (double)n;
		DecimalFormatSymbols otherSymbols = new DecimalFormatSymbols(Locale.ENGLISH);
		DecimalFormat df = new DecimalFormat("0.000000",otherSymbols); 
		System.out.println(df.format(fPositives));
		System.out.println(df.format(fNegatives));
		System.out.println(df.format(fZeros));
	}
}
