package challenges.java.introduction;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;
import java.util.Scanner;

public class JavaStaticInitializerBlock {

	private static Integer B;
	private static Integer H;
	private static boolean flag;
	
	static {
		try {
			InputStream inputStream = JavaStaticInitializerBlock.class.getClassLoader().getResourceAsStream("config.properties");
			Properties properties = new Properties();
			properties.load(inputStream);
			File file = new File(properties.getProperty("input.path") + "java_static_initializer_block.txt");
			Scanner in = new Scanner(file);
			B = in.nextInt();
			H = in.nextInt();
			flag = true;
			if (B <= 0 || H <= 0) {
				System.out.println("java.lang.Exception: Breadth and height must be positive");
				flag = false;
			}
			in.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public static void main(String[] args) {
		if (flag) {
			int area = B * H;
			System.out.print(area);
		}
	}
}