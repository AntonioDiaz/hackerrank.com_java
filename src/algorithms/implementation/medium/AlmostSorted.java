package algorithms.implementation.medium;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;
import java.util.Scanner;

public class AlmostSorted {
	public static void main(String[] args) throws IOException {
		InputStream inputStream = AlmostSorted.class.getClassLoader().getResourceAsStream("config.properties");
		Properties properties = new Properties();
		properties.load(inputStream);
		File file = new File(properties.getProperty("input.path") + "almost_sorted.txt");
		Scanner in = new Scanner(file);
		// Scanner in = new Scanner(System.in);
		int numberOfElements = in.nextInt();
		List<Integer> list = new ArrayList<Integer>();
		for (int i = 0; i < numberOfElements; i++) {
			list.add(in.nextInt());
		}
		/* checking is list is sorted */
		if (AlmostSorted.isSorted(list)) {
			System.out.println("yes");
		} else {
			Integer previous = Integer.MIN_VALUE;
			Integer indexFirst = null;
			Integer indexSecond = null;
			/* example: 1 5 3 2 6 --> swap 5 by 2. */
			for (int i = 0; i < list.size() && indexFirst == null; i++) {
				if (previous > list.get(i)) {
					indexFirst = i - 1;
					Integer minNext = Integer.MAX_VALUE;
					for (int j = i; j < list.size(); j++) {
						if (list.get(j) < minNext) {
							indexSecond = j;
							minNext = list.get(j);
						}
					}
				}
				previous = list.get(i);
			}
			boolean checkReversingSegment = false;
			if (indexFirst != null && indexSecond != null) {
				List<Integer> listCopy = new ArrayList<Integer>();
				listCopy.addAll(list);
				Integer swap = list.get(indexFirst);
				listCopy.set(indexFirst, list.get(indexSecond));
				listCopy.set(indexSecond, swap);
				if (AlmostSorted.isSorted(listCopy)) {
					System.out.println("yes");
					System.out.println("swap " + (indexFirst + 1) + " " + (indexSecond + 1));
				} else {
					checkReversingSegment = true;
				}
			} else {
				checkReversingSegment = true;
			}
			if (checkReversingSegment) {
				previous = Integer.MIN_VALUE;
				Integer startSegment = null;
				Integer endSegment = null;
				for (int i = 0; i < list.size() && endSegment == null; i++) {
					if (previous > list.get(i)) {
						startSegment = i - 1;
						for (int j = i; j < list.size(); j++) {
							if (list.get(j) < list.get(j - 1)) {
								endSegment = j;
							}
						}
					}
					previous = list.get(i);
				}
				/* create a (posible) list sorted. */
				List<Integer> listSorted = new ArrayList<Integer>();
				if (startSegment == null || endSegment == null) {
					System.out.println("no");
				} else {
					for (int i = 0; i < list.size(); i++) {
						if (i >= startSegment && i <= endSegment) {
							listSorted.add(list.get(endSegment - i + startSegment));
						} else {
							listSorted.add(list.get(i));
						}
					}
					if (AlmostSorted.isSorted(listSorted)) {
						System.out.println("yes");
						System.out.println("reverse " + (startSegment + 1) + " " + (endSegment + 1));
					} else {
						System.out.println("no");
					}
				}
			}
		}
		in.close();
	}

	/* return true is list is sorted in ascending order */
	private static boolean isSorted(List<Integer> list) {
		boolean sorted = true;
		Integer previous = Integer.MIN_VALUE;
		for (Integer i : list) {
			if (i < previous) {
				sorted = false;
			}
			previous = i;
		}
		return sorted;
	}
}