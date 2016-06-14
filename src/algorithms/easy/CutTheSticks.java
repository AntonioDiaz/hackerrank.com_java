package algorithms.easy;
import java.util.Arrays;
import java.util.Scanner;

public class CutTheSticks {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int arr[] = new int[n];
        for(int arr_i=0; arr_i < n; arr_i++){
            arr[arr_i] = in.nextInt();
        }
        Arrays.sort(arr);
        int cont = arr.length;
        int prev = -1;
        for (int i : arr) {
			if (i!=prev) {
				System.out.println(cont);
				prev = i;
			}
			cont--;
		}
        in.close();
    }
}