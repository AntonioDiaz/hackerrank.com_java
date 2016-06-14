package algorithms.moderate;

import java.util.Scanner;

public class TimeInWords {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int h = in.nextInt();
		int m = in.nextInt();
		String hInWords = convertLessThanOneThousand(h).trim();
		String hNextInWords = convertLessThanOneThousand((h + 1) % 12).trim();
		String mInWords = convertLessThanOneThousand(m);
		String mLeftInWords = convertLessThanOneThousand(60 - m);
		String result;
		if (m == 0) {
			result = hInWords + " o' clock";
		} else if (m == 15) {
			result = "quarter past " + hInWords;
		} else if (m == 30) {
			result = "half past " + hInWords;
		} else if (m == 45) {
			result = "quarter to " + hNextInWords;
		} else if (m < 30) {
			result = mInWords + " minutes past " + hInWords;
		} else {
			result = mLeftInWords + " minutes to " + hNextInWords;

		}
		System.out.println(result.trim());
		in.close();
	}

	private static final String[] tensNames = { "", " ten", " twenty", " thirty", " forty", " fifty", " sixty", " seventy", " eighty", " ninety" };

	private static final String[] numNames = { "", " one", " two", " three", " four", " five", " six", " seven", " eight", " nine", " ten", " eleven", " twelve",
			" thirteen", " fourteen", " fifteen", " sixteen", " seventeen", " eighteen", " nineteen" };

	private static String convertLessThanOneThousand(int number) {
		String soFar;
		if (number % 100 < 20) {
			soFar = numNames[number % 100];
			number /= 100;
		} else {
			soFar = numNames[number % 10];
			number /= 10;
			soFar = tensNames[number % 10] + soFar;
			number /= 10;
		}
		if (number == 0) {
			return soFar;
		}
		return numNames[number] + " hundred" + soFar;
	}

}
