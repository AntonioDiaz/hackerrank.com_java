package algorithms.strings.medium;

import static org.junit.Assert.*;

import org.junit.Test;

public class SherlockAndAnagramsTest {

	@Test
	public void testCalculateAnagrams01() {
		String input = "abba";
		Integer outputCalculated = SherlockAndAnagrams.calculateAnagrams(input);
		Integer outputExpected = 4 ;
		assertEquals(outputExpected, outputCalculated);		
	}
	
	@Test
	public void testCalculateAnagrams02() {
		String input = "abcd";
		Integer outputCalculated = SherlockAndAnagrams.calculateAnagrams(input);
		Integer outputExpected = 0 ;
		assertEquals(outputExpected, outputCalculated);		
	}
	
	@Test
	public void testCalculateAnagrams03() {
		String input = "ifailuhkqq";
		Integer outputCalculated = SherlockAndAnagrams.calculateAnagrams(input);
		Integer outputExpected = 3;
		assertEquals(outputExpected, outputCalculated);		
	}

	@Test
	public void testCalculateAnagrams04() {
		String input = "hucpoltgty";
		Integer outputCalculated = SherlockAndAnagrams.calculateAnagrams(input);
		Integer outputExpected = 2;
		assertEquals(outputExpected, outputCalculated);		
	}
	
	@Test
	public void testCalculateAnagrams05() {
		String input = "ovarjsnrbf";
		Integer outputCalculated = SherlockAndAnagrams.calculateAnagrams(input);
		Integer outputExpected = 2;
		assertEquals(outputExpected, outputCalculated);		
	}

	@Test
	public void testCalculateAnagrams06() {
		String input = "pvmupwjjjf";
		Integer outputCalculated = SherlockAndAnagrams.calculateAnagrams(input);
		Integer outputExpected = 6;
		assertEquals(outputExpected, outputCalculated);		
	}
	
	@Test
	public void testCalculateAnagrams07() {
		String input = "iwwhrlkpek";
		Integer outputCalculated = SherlockAndAnagrams.calculateAnagrams(input);
		Integer outputExpected = 3;
		assertEquals(outputExpected, outputCalculated);		
	}
}
