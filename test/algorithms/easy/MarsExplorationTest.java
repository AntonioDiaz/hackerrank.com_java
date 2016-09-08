package algorithms.easy;

import static org.junit.Assert.assertEquals;
import org.junit.Test;

public class MarsExplorationTest {

	
	@Test
	public void changedLettersInput01(){
		MarsExploration marsExploration = new MarsExploration("SOSSPSSQSSOR");
		assertEquals(3, marsExploration.changedLetters());
	}
	
	@Test
	public void changedLettersInput02(){
		MarsExploration marsExploration = new MarsExploration("SOSSOT");
		assertEquals(1, marsExploration.changedLetters());
	}
}
