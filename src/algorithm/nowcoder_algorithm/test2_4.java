package algorithm.nowcoder_algorithm;

import java.util.Arrays;

public class test2_4 {
    public static int[] insertSort(int[] A, int n) {
        for (int i = 1; i < n; i++) {
            int temp = A[i];
            int j = i - 1;
            for (; j >= 0 && temp < A[j]; j--) {
                A[j + 1] = A[j];
            }
            A[j + 1] = temp;
        }
        return A;
    }

    public static void main(String[] args) {
        int[] array = {1, 2, 3, 5, 2, 3};
        int[] array2 = {54,35,48,36,27,12,44,44,8,14,26,17,28};
        int[] ans = insertSort(array2, array2.length);
        System.out.println(Arrays.toString(ans));
    }
}
