package challenges.java.advanced;

/** https://www.hackerrank.com/challenges/java-vistor-pattern/ */

import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

enum Color { RED, GREEN }

abstract class Tree {
  private int value;
  private Color color;
  private int depth;
  public Tree(int value, Color color, int depth) {
    this.value = value;
    this.color = color;
    this.depth = depth;
  }

  public int getValue() {
    return value;
  }
  public Color getColor() {
    return color;
  }
  public int getDepth() {
    return depth;
  }
  public abstract void accept(TreeVis visitor);
}

class TreeNode extends Tree {

  private ArrayList<Tree> children = new ArrayList<>();

  public TreeNode(int value, Color color, int depth) {
    super(value, color, depth);
  }

  public void accept(TreeVis visitor) {
    visitor.visitNode(this);
    for (Tree child : children) {
      child.accept(visitor);
    }
  }

  public void addChild(Tree child) {
    children.add(child);
  }
}

class TreeLeaf extends Tree {
  public TreeLeaf(int value, Color color, int depth) {
    super(value, color, depth);
  }
  public void accept(TreeVis visitor) {
    visitor.visitLeaf(this);
  }
}

abstract class TreeVis {
  public abstract int getResult();
  public abstract void visitNode(TreeNode node);
  public abstract void visitLeaf(TreeLeaf leaf);
}


class SumInLeavesVisitor extends TreeVis {
  /** sum of the values in the tree's leaves only. */
  private int result = 0;
  public int getResult() {
    return result;
  }

  public void visitNode(TreeNode node) { }

  public void visitLeaf(TreeLeaf leaf) {
    result += leaf.getValue();
  }
}

class ProductOfRedNodesVisitor extends TreeVis {
  /** Return the product of values stored in all red nodes, including leaves, computed modulo.
   * Note that the product of zero values is equal to. */
  private long result = 1;
  private int MODULE = 1000000007;
  public int getResult() {
    return (int)(result % MODULE);
  }
  public void visitNode(TreeNode node) {
    updateResult(node);
  }
  public void visitLeaf(TreeLeaf leaf) {
    updateResult(leaf);
  }
  private void updateResult(Tree node) {
    if (node.getColor()== Color.RED) {
      //result = result * node.getValue();
    }
  }
}

class FancyVisitor extends TreeVis {

  private int resultEvenDepth = 0;
  private int resultGreenLeaf = 0;
  public int getResult() {
    return Math.abs(resultEvenDepth - resultGreenLeaf);
  }

  public void visitNode(TreeNode node) {
    if (node.getDepth()%2==0) {
      resultEvenDepth += node.getValue();
    }
  }

  public void visitLeaf(TreeLeaf leaf) {
    if (leaf.getColor()== Color.GREEN) {
      resultGreenLeaf += leaf.getValue();
    }
  }
}

public class JavaVisitorPattern {

  private static List<Integer> valuesList;
  private static List<Color> colorsList;
  private static Map<Integer, Set<Integer>> mapTree = new HashMap<>();

  private static List<Color> generateColorList(String nextLine) {
    List<Color> colorList = new ArrayList<>();
    for (String s : nextLine.split(" ")) {
      colorList.add(s.equals("1")?Color.GREEN:Color.RED);
    }
    return colorList;
  }

  private static List<Integer> generateValuesList(String nextLine) {
    List<Integer> valuesList = new ArrayList<>();
    for (String s : nextLine.split(" ")) {
      valuesList.add(Integer.parseInt(s));
    }
    return valuesList;
  }

  public static Tree createTree (int currentElement, int depth) {
    Color color = colorsList.get(currentElement);
    Integer value = valuesList.get(currentElement);
    if (mapTree.get(currentElement).isEmpty()) {
      return new TreeLeaf(value, color, depth);
    } else {
      TreeNode tree = new TreeNode(value, color, depth);
      List<Integer> sonsList = new ArrayList<>(mapTree.get(currentElement));
      for (Integer son : sonsList) {
        mapTree.get(currentElement).remove(son);
        mapTree.get(son).remove(currentElement);
        tree.addChild(createTree(son, depth + 1));
      }
      return tree;
    }
  }



  public static Tree solve() throws FileNotFoundException {
    try {
      ClassLoader classLoader = new JavaVisitorPattern().getClass().getClassLoader();
      File file = new File(classLoader.getResource("java_visitor_pattern_04.txt").getFile());
      Scanner in = new Scanner(file);
      //Scanner in = new Scanner(System.in);
      in.nextLine();
      valuesList = generateValuesList(in.nextLine());
      colorsList = generateColorList(in.nextLine());
      while (in.hasNextInt()) {
        Integer nodeA = in.nextInt() - 1;
        Integer nodeB = in.nextInt() - 1;
        if (!mapTree.containsKey(nodeA)) {
          mapTree.put(nodeA, new HashSet<>());
        }
        if (!mapTree.containsKey(nodeB)) {
          mapTree.put(nodeB, new HashSet<>());
        }
        mapTree.get(nodeA).add(nodeB);
        mapTree.get(nodeB).add(nodeA);
      }
      return createTree(0, 0);
      } catch (Exception e) {
        e.printStackTrace();
        throw e;
    }
  }


  public static void main(String[] args) throws FileNotFoundException {
    Tree root = solve();
    SumInLeavesVisitor vis1 = new SumInLeavesVisitor();
    root.accept(vis1);
    int res1 = vis1.getResult();
    System.out.println(res1);

    ProductOfRedNodesVisitor vis2 = new ProductOfRedNodesVisitor();
    root.accept(vis2);
    int res2 = vis2.getResult();
    System.out.println(res2);

    FancyVisitor vis3 = new FancyVisitor();
    root.accept(vis3);
    int res3 = vis3.getResult();
    System.out.println(res3);
  }
}

