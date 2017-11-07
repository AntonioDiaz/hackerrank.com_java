package algorithms.strings.easy;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by toni on 10/04/2017.
 */
public class SeparateTheNumbersTest {


    @Test
    public void isBeautiful01() throws Exception {
        assertEquals("1", SeparateTheNumbers.isBeautiful("1234"));
    }

    @Test
    public void isBeautiful02() throws Exception {
        assertEquals("-1", SeparateTheNumbers.isBeautiful("010203"));
    }

    @Test
    public void isBeautiful03() throws Exception {
        assertEquals("9933272057275866", SeparateTheNumbers.isBeautiful("99332720572758669933272057275867"));
    }

    @Test
    public void isBeautiful04() throws Exception {
        assertEquals("-1", SeparateTheNumbers.isBeautiful("99332720572758669933272057274867"));
    }


}