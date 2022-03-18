package challenges.java.datastructures.trie;

import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class TrieContactsTest {

  @Test
  public void addStringTest() {
    TrieContacts.Node node = new TrieContacts.Node();
    TrieContacts.addString(node,"ed");
    Assert.assertNotNull(node);
    Assert.assertEquals(1, node.edges.size());
    Assert.assertEquals(1, node.edges.get('e').cont);
    TrieContacts.addString(node, "eddie");
    Assert.assertEquals(2, node.edges.get('e').cont);
  }

  @Test
  public void findTest() {
    TrieContacts.Node node = new TrieContacts.Node();
    TrieContacts.addString(node, "ed");
    TrieContacts.addString(node, "eddie");
    TrieContacts.addString(node, "edward");
    Assert.assertEquals(3, TrieContacts.find(node, "ed"));
    TrieContacts.addString(node, "edwina");
    Assert.assertEquals(2, TrieContacts.find(node, "edw"));
    Assert.assertEquals(0, TrieContacts.find(node, "ad"));
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
    Assert.assertEquals(listExpected, TrieContacts.contacts(queries));
  }

}