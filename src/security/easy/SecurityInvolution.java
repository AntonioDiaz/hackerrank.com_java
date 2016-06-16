package security.easy;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;
import java.util.Scanner;

public class SecurityInvolution {

	public static void main(String[] args) throws IOException {
		InputStream input = SecurityInvolution.class.getClassLoader().getResourceAsStream("config.properties");
		Properties properties = new Properties();
		properties.load(input);
		File file = new File(properties.getProperty("input.path") + "security_involution.txt");
		Scanner in = new Scanner(file);
		// Scanner in = new Scanner(System.in);
		int n = in.nextInt();
		Map<Integer, Integer> map = new HashMap<Integer, Integer>();
		for (int i = 0; i < n; i++) {
			map.put(i, in.nextInt()-1);
		}
		boolean isInvolution = true;
		for (int i = 0; i < n; i++) {
			int val1 = map.get(i);
			int val2 = map.get(val1);
			if (val2!=i) {
				isInvolution = false;
			}
		}		
		System.out.println(isInvolution?"YES":"NO");
		in.close();
	}	
}