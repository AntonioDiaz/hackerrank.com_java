package linkedin;

import linkedin.mypackage.Math;
import linkedin.mypackage.elementary.*;

interface  one {
    default void method() {
        System.out.println("linkedin.mypackage.one");
    }
}
interface  two {
    default void method() {
        System.out.println("linkedin.mypackage.one");
    }
}

public class TestLinkedin implements  one, two{


    @Override
    public void method() {
        one.super.method();
    }

    public static void main(String[] args) {
        int i1 = 1;
        int i2 = 1;
        System.out.println((i1 | i2));
        System.out.println((i1 ^ i2));

        int array[] = {};

        String str = "abcde";

        System.out.println(Math.abs(123));

        System.out.println(args.length);
        System.out.println(args[2]);

        //int a = 123451234512345;

        String string = "xxx";
        string.substring(6, 12);
        string.substring(12, 6);
    }
}
