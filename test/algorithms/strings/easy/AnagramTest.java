package algorithms.strings.easy;

import static org.junit.Assert.assertEquals;
import org.junit.Test;

public class AnagramTest {


	@Test
	public void test01(){
		String input = "aaabbb";
		Integer output = 3;
		assertEquals(output, Anagram.calculateAnagram(input));
	}
	
	@Test
	public void test02(){
		String input = "ab";
		Integer output = 1;
		assertEquals(output, Anagram.calculateAnagram(input));
	}

	@Test
	public void test03(){
		String input = "abc";
		Integer output = -1;
		assertEquals(output, Anagram.calculateAnagram(input));
	}
	
	@Test
	public void test04(){
		String input = "mnop";
		Integer output = 2;
		assertEquals(output, Anagram.calculateAnagram(input));
	}
	
	@Test
	public void test05(){
		String input = "xyyx";
		Integer output = 0;
		assertEquals(output, Anagram.calculateAnagram(input));
	}

	@Test
	public void test06(){
		String input = "xaxbbbxx";
		Integer output = 1;
		assertEquals(output, Anagram.calculateAnagram(input));
	}
}
