package algorithms.implementation.easy;

import java.util.Calendar;
import java.util.Scanner;

public class LibraryFee {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int fee = 0;
		int dayReturn = in.nextInt();
		int monthReturn = in.nextInt();
		int yearReturn = in.nextInt();
		int dayExpected = in.nextInt();
		int monthExpected = in.nextInt();
		int yearExpected = in.nextInt();
		Calendar cReturn = Calendar.getInstance();
		cReturn.set(yearReturn, monthReturn, dayReturn);
		Calendar cExpected = Calendar.getInstance();
		cExpected.set(yearExpected, monthExpected, dayExpected);
		if (cReturn.compareTo(cExpected)>0) {
			if (yearReturn > yearExpected) {
				fee = 10000;
			} else if (monthReturn > monthExpected) {
				fee = 500 * (monthReturn - monthExpected);
			} else if (dayReturn > dayExpected) {
				fee = 15 * (dayReturn - dayExpected);
			}
		}
		System.out.println(fee);	
		in.close();
	}
}
