package easy;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Properties;
import java.util.Scanner;
import java.util.Set;

public class MakeItAnagram {

	public static void main(String[] args) throws IOException {
		InputStream input = MakeItAnagram.class.getClassLoader().getResourceAsStream("config.properties");
		Properties properties = new Properties();
		properties.load(input);
		File file = new File(properties.getProperty("input.path") + "make_it_anagram_01.txt");
		Scanner in = new Scanner(file);
		//Scanner in = new Scanner(System.in);
		Map<Byte, Integer> map1 = bytesToMap(in.nextLine().getBytes());
		Map<Byte, Integer> map2 = bytesToMap(in.nextLine().getBytes());
		int deletions = 0;
		/* counting characters in string1 and in string2. */
		Set<Byte> keysIntersect = new HashSet<Byte>(map1.keySet());
		keysIntersect.retainAll(map2.keySet());
		for (Byte byte1 : keysIntersect) {
			deletions += Math.abs(map1.get(byte1) - map2.get(byte1));
		}
		/* counting characters from string 1 not present in string2 */		
		Set<Byte> keysRemove1 =  new HashSet<Byte>(map1.keySet());
		keysRemove1.removeAll(map2.keySet());		
		for (Byte byte1 : keysRemove1) {
			deletions += map1.get(byte1);
		}
		/* counting characters from string2 not present in string1. */
		Set<Byte> keysRemove2 =  new HashSet<Byte>(map2.keySet());
		keysRemove2.removeAll(map1.keySet());		
		for (Byte byte1 : keysRemove2) {
			deletions += map2.get(byte1);
		}
		System.out.println(deletions);
		in.close();
	}

	private static Map<Byte, Integer> bytesToMap(byte[] bytes) {
		Map<Byte, Integer> map = new HashMap<Byte, Integer>();
		for (byte b : bytes) {
			Integer repetitions = 1;
			if (map.containsKey(b)) {
				repetitions = map.get(b) + 1;
			}
			map.put(b, repetitions);
		}
		return map;
	}

}
