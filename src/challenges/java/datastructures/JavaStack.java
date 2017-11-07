package challenges.java.datastructures;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;
import java.util.Scanner;

public class JavaStack {
	
	public static final char OPEN_BRACKET = '[';
	public static final char CLOSE_BRACKET = ']';
	
	public static final char OPEN_PARENTHESES = '(';
	public static final char CLOSE_PARENTHESES= ')';
	
	public static final char OPEN_BRACE = '{';
	public static final char CLOSE_BRACE = '}';
	
	public static void main(String[] args) throws IOException {
		InputStream inputStream = JavaStack.class.getClassLoader().getResourceAsStream("config.properties");
		Properties properties = new Properties();
		properties.load(inputStream);
		File file = new File(properties.getProperty("input.path") + "java_stack.txt");
		Scanner in = new Scanner(file);
		// Scanner in = new Scanner(System.in);
		while (in.hasNextLine()) {
			String line = in.nextLine();
			char [] characters = line.toCharArray();
			boolean balanced = true;
			List<Character> stack = new ArrayList<Character>();
			for (int i = 0; i < characters.length && balanced; i++) {
				if (isOpen(characters[i])){
					stack.add(characters[i]);
				} else if (isClose(characters[i])) {
					if (stack.isEmpty()) {
						balanced = false;
					} else {
						char last = stack.get(stack.size()-1);
						stack.remove(stack.size()-1);
						if (last==OPEN_BRACE && characters[i]!=CLOSE_BRACE 
								|| last==OPEN_BRACKET && characters[i]!=CLOSE_BRACKET 
								|| last==OPEN_PARENTHESES && characters[i]!=CLOSE_PARENTHESES) {
							balanced = false;
						}
					}
				} 
			}
			if (!stack.isEmpty()) {
				balanced = false;
			}
			System.out.println(balanced);
		}
		in.close();
	}

	private static boolean isClose(char c) {
		return c==CLOSE_BRACE|| c==CLOSE_BRACKET || c==CLOSE_PARENTHESES;
	}

	private static boolean isOpen(char c) {
		return c==OPEN_BRACE|| c==OPEN_BRACKET || c==OPEN_PARENTHESES;
	}

}
