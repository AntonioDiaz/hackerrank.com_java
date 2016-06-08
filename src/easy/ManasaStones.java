package easy;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Properties;
import java.util.Scanner;
import java.util.Set;

public class ManasaStones {

	public static void main(String[] args) throws IOException {
		InputStream input = ManasaStones.class.getClassLoader().getResourceAsStream("config.properties");
		Properties properties = new Properties();
		properties.load(input);
		File file = new File(properties.getProperty("input.path") + "manasa_stones.txt");
		Scanner scanner = new Scanner(file);
		Integer testCases = scanner.nextInt();
		for (int i = 0; i < testCases; i++) {
			Integer stones = scanner.nextInt() -1;
			Integer a = scanner.nextInt();
			Integer b = scanner.nextInt();
			Set<Integer> set = new HashSet<Integer>(); 
			for (int j = 0; j <= stones; j++) {
				int aNum = stones - j;
				int bNum = j;
				//System.out.println("a: " + aNum);
				//System.out.println("b: " + bNum);
				set.add(aNum * a + bNum * b);
			}
			List<Integer> list = new ArrayList<Integer>(set);
			Collections.sort(list);
			for (Integer integer : list) {
				System.out.print(integer + " ");
			}
			System.out.println("");
		}		
		scanner.close();
	}
	
}
