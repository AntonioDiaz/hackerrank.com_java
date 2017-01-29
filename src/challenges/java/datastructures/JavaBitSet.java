package challenges.java.datastructures;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.util.BitSet;
import java.util.Properties;
import java.util.Scanner;

public class JavaBitSet {
	
	private static final String OPERATION_AND = "AND";
	private static final String OPERATION_SET = "SET";
	private static final String OPERATION_FLIP = "FLIP";
	private static final String OPERATION_OR = "OR";
	private static final String OPERATION_XOR = "XOR";
	
	public static void main(String[] args) throws IOException {
		InputStream inputStream = JavaBitSet.class.getClassLoader().getResourceAsStream("config.properties");
		Properties properties = new Properties();
		properties.load(inputStream);
		File file = new File(properties.getProperty("input.path") + "java_bitset.txt");
		Scanner in = new Scanner(file);
		// Scanner in = new Scanner(System.in);
		int setSize = in.nextInt();
		BitSet bitSet01 = new BitSet(setSize);
		BitSet bitSet02 = new BitSet(setSize);
		
		int operationsCount = in.nextInt();
		in.nextLine();
		for (int i = 0; i < operationsCount; i++) {
			String line = in.nextLine();
			String[] split = line.split(" ");
			String operation = split[0];
			int operator01 = Integer.parseInt(split[1]);
			int operator02 = Integer.parseInt(split[2]);
			switch (operation) {
			case OPERATION_AND:
				if (operator01==1) {
					bitSet01.and(bitSet02);
				} else {
					bitSet02.and(bitSet01);
				}
				break;
			case OPERATION_SET:
				if (operator01==1) {
					bitSet01.set(operator02);
				} else {
					bitSet02.set(operator02);
				}
				break;
			case OPERATION_FLIP:
				if (operator01==1) {
					bitSet01.flip(operator02);
				} else {
					bitSet02.flip(operator02);
				}		
				break;
			case OPERATION_OR:
				if (operator01==1) {
					bitSet01.or(bitSet02);
				} else {
					bitSet02.or(bitSet01);
				}
				break;
			case OPERATION_XOR:
				if (operator01==1) {
					bitSet01.xor(bitSet02);
				} else {
					bitSet02.xor(bitSet01);
				}
				break;
			default:
				break;
			}
			System.out.println(bitSet01.cardinality() + " " + bitSet02.cardinality());
		}		
		in.close();
	}
}