package contest.weekcode27;

import static org.junit.Assert.assertEquals;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

public class ZeroMoveNimTest {

	@Test
	public void testCalculateIfFirstWins01(){
		List<BigInteger> piles = new ArrayList<BigInteger>();
		piles.add(BigInteger.valueOf(1));
		piles.add(BigInteger.valueOf(2));
		Boolean firstWins = ZeroMoveNim.calculateIfFirstWins(piles);
		assertEquals(true, firstWins);
	}
	
	@Test
	public void testCalculateIfFirstWins02(){
		List<BigInteger> piles = new ArrayList<BigInteger>();
		piles.add(BigInteger.valueOf(2));
		piles.add(BigInteger.valueOf(2));
		Boolean firstWins = ZeroMoveNim.calculateIfFirstWins(piles);
		assertEquals(false, firstWins);		
	}
	
}
