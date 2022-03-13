package challenges.java.datastructures;

import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

public class TrieContactsTest {

  @Test
  public void addStringTest() {
    Result.Node node = new Result.Node();
    Result.addString(node,"ed");
    Assert.assertNotNull(node);
    Assert.assertEquals(1, node.edges.size());
    Assert.assertEquals(1, node.edges.get('e').cont);
    Result.addString(node, "eddie");
    Assert.assertEquals(2, node.edges.get('e').cont);
  }

  @Test
  public void findTest() {
    Result.Node node = new Result.Node();
    Result.addString(node, "ed");
    Result.addString(node, "eddie");
    Result.addString(node, "edward");
    Assert.assertEquals(3, Result.find(node, "ed"));
    Result.addString(node, "edwina");
    Assert.assertEquals(2, Result.find(node, "edw"));
    Assert.assertEquals(0, Result.find(node, "ad"));
  }

  @Test
  public void contactsTest() {
    List<List<String>> queries = new ArrayList<>();
    queries.add(List.of("add", "ed"));
    queries.add(List.of("add", "eddie"));
    queries.add(List.of("add", "edward"));
    queries.add(List.of("find", "ed"));
    queries.add(List.of("add", "edwina"));
    queries.add(List.of("find", "edw"));
    queries.add(List.of("find", "a"));
    List<Integer> listExpected = List.of(3,2,0);
    Assert.assertEquals(listExpected, Result.contacts(queries));
  }

}