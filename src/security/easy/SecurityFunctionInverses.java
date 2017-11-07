package security.easy;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Properties;
import java.util.Scanner;

public class SecurityFunctionInverses {

	public static void main(String[] args) throws IOException {
		InputStream input = SecurityFunctionInverses.class.getClassLoader().getResourceAsStream("config.properties");
		Properties properties = new Properties();
		properties.load(input);
		File file = new File(properties.getProperty("input.path") + "security_function_inverses_02.txt");
		Scanner in = new Scanner(file);
		// Scanner in = new Scanner(System.in);
		int n = in.nextInt();
		List<Integer> list01 = new ArrayList<Integer>();
		Map<Integer, Integer> map = new HashMap<Integer, Integer>();
		for (int i = 0; i < n; i++) {
			int myInt = in.nextInt() - 1;
			list01.add(myInt);
			map.put(myInt, i);
		}
		
		for (int i = 0; i < n; i++) {
			System.out.println(map.get(i) + 1);
		}		
		in.close();
	}	
}
