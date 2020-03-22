package interview.strings;

import org.junit.Test;

import static org.junit.Assert.*;

public class MakingAnagramsTest {

    @Test
    public void makeAnagram_0() {
        MakingAnagrams makingAnagrams = new MakingAnagrams();
        String a = "";
        String b = "";
        assertEquals(0, makingAnagrams.makeAnagram(a, b));
    }

    @Test
    public void makeAnagram_4() {
        MakingAnagrams makingAnagrams = new MakingAnagrams();
        String a = "cde";
        String b = "abc";
        assertEquals(4, makingAnagrams.makeAnagram(a, b));
    }
}