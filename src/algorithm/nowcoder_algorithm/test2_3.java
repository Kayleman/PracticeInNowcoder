package algorithm.nowcoder_algorithm;

import java.util.Arrays;

public class test2_3 {
    public static int [] selectSort(int[] A, int n) {
        int minIndex;
        for (int i = 0; i < n; i++) {
            minIndex = i;
            for (int j = i; j < n; j++) {
                if(A[j] < A[minIndex]) {
                    minIndex = j;
                }
            }
            int temp = A[i];
            A[i] = A[minIndex];
            A[minIndex] = temp;

        }
        return A;
    }

    public static void main(String[] args) {
        int[] array = {1, 2, 3, 5, 2, 3};
        int[] ans = selectSort(array, array.length);
        System.out.println(Arrays.toString(ans));
    }
}
