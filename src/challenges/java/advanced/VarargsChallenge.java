package challenges.java.advanced;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.lang.reflect.Method;
import java.util.HashSet;
import java.util.Set;

class Add {
  public void add(int... varArgsInt) {
    String line = "";
    int sum = 0;
    for (int i : varArgsInt) {
      if (!line.equals("")) {
        line += "+";
      }
      line += Integer.toString(i);
      sum += i;
    }
    System.out.println(line + "=" + sum);
  }
}

public class VarargsChallenge {

  public static void main(String[] args) {
    Add ob = new Add();
    ob.add(22, 33, 88);
  }
}
