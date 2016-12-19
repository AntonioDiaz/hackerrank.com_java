package algorithms.implementation.easy;


import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;
import java.util.Scanner;

public class BonAppetit {

	public static void main(String[] args) throws IOException {
		InputStream input = BonAppetit.class.getClassLoader().getResourceAsStream("config.properties");
		Properties properties = new Properties();
		properties.load(input);
		
		File file = new File(properties.getProperty("input.path") + "bon_appetit.txt");
		Scanner in = new Scanner(file);
		//Scanner in = new Scanner (System.in);
		int dishesNumber = in.nextInt();
		int dishDeclined = in.nextInt();
		int dishesSharedAmount = 0;
		for (int i = 0; i < dishesNumber; i++) {
			int dishPrice = in.nextInt();
			if (i!=dishDeclined) {
				dishesSharedAmount += dishPrice; 
			} 
		}
		int amountPaid = in.nextInt();
		if (amountPaid==dishesSharedAmount/2) {
			System.out.println("Bon Appetit");
		} else {
			System.out.println(amountPaid - dishesSharedAmount/2);
		}
		
		in.close();
	}
}
