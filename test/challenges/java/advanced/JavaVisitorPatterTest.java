package challenges.java.advanced;

import org.junit.Test;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;

import static org.junit.Assert.assertEquals;

public class JavaVisitorPatterTest {


  @Test
  public void testingList_creation() {
    List<List<Integer>> l = new ArrayList();
    IntStream.rangeClosed(0, 4).forEach(i->l.add(new ArrayList<>()));
    assertEquals(5, l.size());

  }
}