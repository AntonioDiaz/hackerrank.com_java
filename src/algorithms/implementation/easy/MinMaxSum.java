package algorithms.implementation.easy;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.math.BigInteger;
import java.util.Properties;
import java.util.Scanner;

public class MinMaxSum {

	public static void main(String[] args) {
		try {
			InputStream input = MinMaxSum.class.getClassLoader().getResourceAsStream("config.properties");
			Properties properties = new Properties();
			properties.load(input);
			File file = new File(properties.getProperty("input.path") + "min_max_sum.txt");
			Scanner in = new Scanner(file);
			//Scanner in = new Scanner(System.in);
			int inputSize = 5;
			BigInteger array[] = new BigInteger[inputSize];
			BigInteger max = null;
			BigInteger min = null;
			BigInteger sumMax = new BigInteger("0");
			BigInteger sumMin = new BigInteger("0");
			int maxPosition = 0;
			int minPosition = 0;			
			for (int i = 0; i < inputSize; i++) {
				array[i] = new BigInteger(in.next());
				if (i==0) {
					max = array [0];
					min = array [0];
				} else {
					if (array[i].compareTo(max)<0) {
						max = array[i];
						maxPosition = i;
					}
					if (array[i].compareTo(min)>0) {
						min = array[i];
						minPosition = i;
					}
				}
			}
			System.out.println(maxPosition);
			System.out.println(minPosition);
			for (int i = 0; i < inputSize; i++) {
				if (i!=maxPosition) {
					sumMax = sumMax.add(array[i]);
				}
				if (i!=minPosition) {
					sumMin = sumMin.add(array[i]);
				}
			}			
			System.out.println(sumMin + " " + sumMax);
			in.close();
		} catch (IOException e) {
			
			e.printStackTrace();
		}

	}

}
