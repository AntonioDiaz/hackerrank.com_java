package algorithms.implementation.easy;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;
import java.util.Scanner;

public class AppendAndDelete {
	public static void main(String[] args) throws IOException {
		InputStream inputStream = AppendAndDelete.class.getClassLoader().getResourceAsStream("config.properties");
		Properties properties = new Properties();
		properties.load(inputStream);
		File file = new File(properties.getProperty("input.path") + "append_and_delete.txt");
		Scanner in = new Scanner(file);
		// Scanner in = new Scanner(System.in);
		String original = in.nextLine();
		String desided = in.nextLine();
		int operationsCount = in.nextInt();
		byte[] bytesOriginal = original.getBytes();
		byte[] bytesTarget = desided.getBytes();
		boolean charEqual = true;
		int index = 0;
		/* letters equals */
		while (charEqual && index < original.length()) {
			if (index < bytesTarget.length && bytesTarget[index] == bytesOriginal[index]) {
				index++;
			} else {
				charEqual = false;
			}
		}
		/* calculate how many letters must be delete */
		int lettersToDelete = original.length() - index;
		/* calculate how many letters must added */
		int lettersToAdd = desided.length() - index;
		int operationsNeeded = lettersToDelete + lettersToAdd;
		/* there are 3 cases in which its is possible to convert the string.
		 	1. operations needed are equals.
		 	2. operation count is bigger than operations needed and the difference is even. 
		 	3. it is possible to delete all characters and then all.*/
		if (operationsNeeded == operationsCount 
				|| (operationsCount > operationsNeeded && (operationsCount - operationsNeeded)%2==0)
				|| (operationsCount > operationsNeeded && (operationsCount - operationsNeeded)>index*2)) {
			System.out.println("Yes");
		} else {
			System.out.println("No");
		}
		in.close();
	}
}