package challenges.java.bignumber;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Properties;
import java.util.Scanner;

public class JavaBigDecimal {

	public static void main(String[] args) throws IOException {
		InputStream inputStream = JavaBigDecimal.class.getClassLoader().getResourceAsStream("config.properties");
		Properties properties = new Properties();
		properties.load(inputStream);
		File file = new File(properties.getProperty("input.path") + "java_bigdecimal.txt");
		Scanner in = new Scanner(file);
		int n = in.nextInt();
		String[] s = new String[n + 2];
		for (int i = 0; i < n; i++) {
			s[i] = in.next();
		}
		in.close();

		class CustomElement {
			public String strRepresentation;
			public BigDecimal bigDecimalRepresentation;

			public CustomElement(String str){
				strRepresentation = str;
				bigDecimalRepresentation = new BigDecimal(str);
			}
		}	
		List<CustomElement> list = new ArrayList<>();
		for (int i = 0; i < n; i++) {
			CustomElement customElement = new CustomElement(s[i]);
			list.add(customElement);
		}
		Collections.sort(list, new Comparator<CustomElement>() {
			@Override
			public int compare(CustomElement o1, CustomElement o2) {
				return o2.bigDecimalRepresentation.compareTo(o1.bigDecimalRepresentation);
			}
		});
		for (int i = 0; i < n; i++) {
			s[i] = list.get(i).strRepresentation;
		}
		// Output
		for (int i = 0; i < n; i++) {
			System.out.println(s[i]);
		}
	}

		
}
