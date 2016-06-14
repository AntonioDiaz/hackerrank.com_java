package security.easy;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
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
		for (int i = 0; i < n; i++) {
			list01.add(in.nextInt() - 1);
		}
		for (int i = 0; i < n; i++) {
			System.out.println(list01.get(list01.get(i)) + 1);
		}		
		in.close();
	}	
}
