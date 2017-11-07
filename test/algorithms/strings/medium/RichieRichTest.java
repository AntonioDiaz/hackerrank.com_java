package algorithms.strings.medium;

import static org.junit.Assert.assertEquals;


import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;
import java.util.Scanner;

import org.junit.Test;


public class RichieRichTest {

	@Test
	public void calculateLargestPalindromeEasy(){
		RichieRich richieRich = new RichieRich("3943", 1);
		assertEquals("3993", richieRich.calculateLargestPalindrome());
	}
	
	@Test
	public void calculateLargestPalindromeModerate(){
		RichieRich richieRich = new RichieRich("092282", 3);
		assertEquals("992299", richieRich.calculateLargestPalindrome());
	}
	
	@Test
	public void calculateLargestPalindromeNoSolution(){
		RichieRich richieRich = new RichieRich("0011", 1);
		assertEquals("-1", richieRich.calculateLargestPalindrome());
	}
	
	@Test
	public void calculateLargestPalindromeOdd() {
		RichieRich richieRich = new RichieRich("00100", 1);
		assertEquals("00900", richieRich.calculateLargestPalindrome());
	}
	
	@Test
	public void calculateLargestPalindromeHuge() throws IOException {
		InputStream input = RichieRich.class.getClassLoader().getResourceAsStream("config.properties");
		Properties properties = new Properties();
		properties.load(input);
		File file = new File(properties.getProperty("input.path") + "richie_rich_input_01.txt");
		Scanner in = new Scanner(file);
        in.nextInt();
        int k = in.nextInt();
        String number = in.next();
		RichieRich richieRich = new RichieRich(number, k);
		File fileResults = new File(properties.getProperty("input.path") + "richie_rich_output_01.txt");
		Scanner inResults = new Scanner(fileResults);
		String result = inResults.next();
		System.out.println(result.length());
		System.out.println(richieRich.calculateLargestPalindrome().length());
		assertEquals(result, richieRich.calculateLargestPalindrome());
		in.close();
		inResults.close();
	}	
}
