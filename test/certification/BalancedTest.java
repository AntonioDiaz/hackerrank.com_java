package certification;

import org.junit.Assert;
import org.junit.Test;

public class BalancedTest {

    @Test
    public void balanced01() {
        Assert.assertTrue (Balanced.isBalanced("()"));
    }

    @Test
    public void balanced02() {
        Assert.assertTrue (Balanced.isBalanced("(())()"));
    }

    @Test
    public void notBalanced01() {
        Assert.assertFalse(Balanced.isBalanced("{{)}}"));
    }

}