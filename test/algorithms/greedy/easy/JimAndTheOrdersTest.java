package algorithms.greedy.easy;

import org.junit.Assert;
import org.junit.Test;

import java.util.List;

public class JimAndTheOrdersTest {


  @Test
  public void testEasyInput() {
    List<List<Integer>> inputList = List.of(
            List.of(1, 3),
            List.of(2, 3),
            List.of(3, 3)
    );
    List<Integer> ordersList = JimAndTheOrders.jimOrders(inputList);
    List<Integer> expectedOutput = List.of(1, 2, 3);
    Assert.assertEquals(expectedOutput, ordersList);
  }

  @Test
  public void testMediumInput() {
    List<List<Integer>> inputList = List.of(
            List.of(8, 1),
            List.of(4, 2),
            List.of(5, 6),
            List.of(3, 1),
            List.of(4, 3)
    );
    List<Integer> ordersList = JimAndTheOrders.jimOrders(inputList);
    List<Integer> expectedOutput = List.of(4, 2, 5, 1, 3);
    Assert.assertEquals(expectedOutput, ordersList);
  }

}
