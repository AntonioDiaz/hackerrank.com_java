package algorithms.strings.easy;

import org.junit.Test;

import algorithms.strings.easy.SuperReducedString;

import static org.junit.Assert.*;

public class SuperReducedStringTest {

  @Test
  public void test01() {
    final String input = "aaabccddd";
    final String expected = "abd";
    String obtained = SuperReducedString.calculateReducedString(input);
    assertEquals("TestCase 01 failed", expected, obtained);
  }

  @Test
  public void test02() {
    final String input = "baab";
    final String expected = "Empty String";
    String obtained = SuperReducedString.calculateReducedString(input);
    assertEquals("TestCase 02 failed", expected, obtained);
  }

  @Test
  public void test03() {
    final String input = "aa";
    final String expected = "Empty String";
    String obtained = SuperReducedString.calculateReducedString(input);
    assertEquals("TestCase 03 failed", expected, obtained);
  }

}
