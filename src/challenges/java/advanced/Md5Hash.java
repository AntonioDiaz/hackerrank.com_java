package challenges.java.advanced;

/** https://www.hackerrank.com/challenges/java-md5/problem */

import javax.xml.bind.DatatypeConverter;
import java.security.MessageDigest;
import java.util.Scanner;

public class Md5Hash {

  public static void main(String[] args) throws Exception {
    /*
    ClassLoader classLoader = new JavaVisitorPattern().getClass().getClassLoader();
    File file = new File(classLoader.getResource("java_visitor_pattern_04.txt").getFile());
    Scanner in = new Scanner(file);
    */
    Scanner in = new Scanner(System.in);
    String inputString = in.next();
    MessageDigest md = MessageDigest.getInstance("MD5");
    md.update(inputString.getBytes());
    byte[] digest = md.digest();
    String myHash = DatatypeConverter.printHexBinary(digest).toLowerCase();
    System.out.println(myHash);
    in.close();
  }

}
