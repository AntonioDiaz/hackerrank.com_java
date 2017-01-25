package challenges.java.datastructures;

public class JavaGenericsPrinter {

	public  <T> void  printArray (T[] myArray) {
		for (T t2 : myArray) {
			System.out.println(t2);
		}
	}
 
}