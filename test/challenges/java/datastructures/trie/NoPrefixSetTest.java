package challenges.java.datastructures.trie;

import org.junit.Assert;
import org.junit.Test;

import java.util.List;
import java.util.Optional;

import static org.junit.Assert.*;

public class NoPrefixSetTest {

  @Test
  public void findFirstPrefix_GOOD_SET() {
    List<String> inputList = List.of("ab", "bc", "cd");
    Assert.assertEquals(Optional.empty(), NoPrefixSet.findFirstPrefix(inputList));
  }

  @Test
  public void findFirstPrefix_BAD_SET_easy() {
    List<String> inputList = List.of("ab", "a");
    Assert.assertEquals(Optional.of("a"), NoPrefixSet.findFirstPrefix(inputList));
  }

  @Test
  public void findFirstPrefix_BAD_SET_easy_reverse() {
    List<String> inputList = List.of("a", "ab");
    Assert.assertEquals(Optional.of("ab"), NoPrefixSet.findFirstPrefix(inputList));
  }


  @Test
  public void findFirstPrefix_BAD_SET() {
    List<String> inputList = List.of("abcd", "bcd", "abcde", "bcde");
    Assert.assertEquals(Optional.of("abcde"), NoPrefixSet.findFirstPrefix(inputList));
  }

  @Test
  public void findFirstPrefix_BAD_SET_02() {
    List<String> inputList = List.of("aab", "defgab", "abcde", "aabcde", "bbbbbbbbbb", "bbbbbbbbbb");
    Assert.assertEquals(Optional.of("aabcde"), NoPrefixSet.findFirstPrefix(inputList));
  }
}