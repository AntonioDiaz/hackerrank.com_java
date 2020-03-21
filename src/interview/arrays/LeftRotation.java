package interview.arrays;

import java.util.Arrays;

public class LeftRotation {

    static int[] rotLeft(int[] a, int d) {
        int[] arrayLeft = new int[a.length];
        for (int i = 0; i < a.length; i++) {
            int newIndex = (i + (a.length-d) )% a.length;
            arrayLeft[newIndex] = a[i];
        }
        return arrayLeft;
    }

    public static void main(String[] args) {
        int[] arrayInput = new int[]{1, 2, 3, 4, 5};
        int d = 4;
        System.out.println(Arrays.toString(LeftRotation.rotLeft(arrayInput, d)));
    }


}
