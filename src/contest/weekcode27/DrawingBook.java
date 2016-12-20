package contest.weekcode27;

/** @author Antonio Diaz */

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;
import java.util.Scanner;

public class DrawingBook {
  public static void main(String[] args) throws IOException {
      InputStream inputStream = DrawingBook.class.getClassLoader().getResourceAsStream("config.properties");
      Properties properties = new Properties();
      properties.load(inputStream);
      File file = new File(properties.getProperty("input.path") + "drawing_book.txt");
      Scanner in = new Scanner(file);
      // Scanner in = new Scanner(System.in);
      int pages = in.nextInt();
      int p = in.nextInt();
      int fromBegining = p/2;
      int fromEnd = (pages-p)/2;
      System.out.println(fromBegining<fromEnd?fromBegining:fromEnd);
      in.close();
    }
}