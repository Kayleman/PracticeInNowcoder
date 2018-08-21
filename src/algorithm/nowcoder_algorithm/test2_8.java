package algorithm.nowcoder_algorithm;

import java.util.Arrays;

public class test2_8 {
    public static int[] shellSort(int[] A, int n) {
        for (int gap = n / 2; gap > 0; gap /= 2) {
            for (int i = 0; (i + gap) < n; i++) {
                for (int j = 0; (j + gap) < n; j += gap) {
                    if(A[j] > A[j + gap]) {
                        int temp = A[j];
                        A[j] = A[j + gap];
                        A[j + gap] = temp;
                        System.out.println(Arrays.toString(A));
                    }
                }
            }
        }
        return A;
    }

    public static void main(String[] args) {
        int[] array = {1, 2, 3, 5, 2, 3};
        int[] array2 = {54,35,48,36,27,12,44,44,8,14,26,17,28};
        int[] ans = shellSort(array2, array2.length);
        System.out.println(Arrays.toString(ans));
    }
}
