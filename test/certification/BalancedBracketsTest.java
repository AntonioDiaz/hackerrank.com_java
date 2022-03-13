package certification;

import org.junit.Assert;
import org.junit.Test;


public class BalancedBracketsTest {

  @Test
  public void isBalancedTest01() {
    Assert.assertEquals("YES", BalancedBrackets.isBalanced("{[()]}"));
  }

  @Test
  public void isBalancedTest02() {
    Assert.assertEquals("NO", BalancedBrackets.isBalanced("{[(])}"));
  }

  @Test
  public void isBalancedTest03() {
    Assert.assertEquals("YES", BalancedBrackets.isBalanced("{{[[(())]]}}"));
  }

}