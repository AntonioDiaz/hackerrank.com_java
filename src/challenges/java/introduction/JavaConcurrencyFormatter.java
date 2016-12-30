package challenges.java.introduction;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.text.NumberFormat;
import java.util.Locale;
import java.util.Properties;
import java.util.Scanner;

public class JavaConcurrencyFormatter {
	public static void main(String[] args) throws IOException {
		InputStream inputStream = JavaConcurrencyFormatter.class.getClassLoader().getResourceAsStream("config.properties");
		Properties properties = new Properties();
		properties.load(inputStream);
		File file = new File(properties.getProperty("input.path") + "java_concurrency_formatter.txt");
		Scanner in = new Scanner(file);
		// Scanner in = new Scanner(System.in);
		String str = in.nextLine();
		double payment = Double.parseDouble(str);
		System.out.println("US: " + NumberFormat.getCurrencyInstance(Locale.US).format(payment));
		System.out.println("India: " + NumberFormat.getCurrencyInstance(new Locale("en", "IN")).format(payment));
		System.out.println("China: " + NumberFormat.getCurrencyInstance(Locale.CHINA).format(payment));
		System.out.println("France: " + NumberFormat.getCurrencyInstance(Locale.FRANCE).format(payment));
		in.close();
	}
}
