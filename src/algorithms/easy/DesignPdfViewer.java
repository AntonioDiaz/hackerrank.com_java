package algorithms.easy;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;
import java.util.Scanner;

public class DesignPdfViewer {

	public static void main(String[] args) throws IOException {
		InputStream input = DesignPdfViewer.class.getClassLoader().getResourceAsStream("config.properties");
		Properties properties = new Properties();
		properties.load(input);
		File file = new File(properties.getProperty("input.path") + "design_pdf_viewer.txt");
		Scanner in = new Scanner(file);
		// Scanner in = new Scanner(System.in);
		int n = 26;
		int h[] = new int[n];
		for (int h_i = 0; h_i < n; h_i++) {
			h[h_i] = in.nextInt();
		}
		String word = in.next();
		byte[] bytes = word.getBytes();
		int maxHeigh = 0;
		for (byte b : bytes) {
			if (h[b - 97] > maxHeigh) {
				maxHeigh = h[b - 97];
			}
		}
		System.out.println(maxHeigh * word.length());
		in.close();
	}
}
