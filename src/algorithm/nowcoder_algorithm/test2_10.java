package algorithm.nowcoder_algorithm;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;


public class test2_10 {
    public static int[] countingSort(int[] A, int n) {
        int min = A[0];
        int max = A[0];
        for(int a:A) {
            min = Math.min(min, a);
            max = Math.max(max, a);
        }

        int[] arrayCount = new int[max - min + 1];
        for (int i = 0; i < n; i++) {
            arrayCount[A[i] - min]++;
        }

        int index = 0;
        for (int i = 0; i < arrayCount.length; i++) {
            while (arrayCount[i]-- > 0) {
                A[index++] = i + min;
            }
        }
        return A;
    }

    public static void main(String[] args) {
        int[] array = {1, 2, 3, 5, 2, 3};
        int[] array2 = {54,35,48,36,27,12,44,44,8,14,26,17,28};
        int[] ans = countingSort(array2, array2.length);
        System.out.println(Arrays.toString(ans));
    }
}
