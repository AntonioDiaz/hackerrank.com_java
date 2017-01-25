package challenges.java.datastructures;


import java.lang.reflect.Method;

public class JavaGenerics{


    public static void main( String args[] ) {
        JavaGenericsPrinter myPrinter = new JavaGenericsPrinter();
        Integer[] intArray = { 1, 2, 3 };
        String[] stringArray = {"Hello", "World"};
        myPrinter.printArray(intArray);
        myPrinter.printArray(stringArray);
        int count = 0;

        for (Method method : JavaGenericsPrinter.class.getDeclaredMethods()) {
            String name = method.getName();

            if(name.equals("printArray"))
                count++;
        }

        if(count > 1)System.out.println("Method overloading is not allowed!");
      
    }
    

}