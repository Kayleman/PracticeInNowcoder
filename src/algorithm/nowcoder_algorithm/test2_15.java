package algorithm.nowcoder_algorithm;

import java.util.Arrays;

public class test2_15 {
    public static int[] mergeAB(int[] A, int[] B, int n, int m) {
        int indexA = n - 1;
        int indexB = m - 1;

        int index = n + m - 1;
        while (indexA >= 0 && indexB >= 0) {
            if(A[indexA] >= B[indexB]) {
                A[index--] = A[indexA--];
            } else {
                A[index--] = B[indexB--];
            }
        }

        while(indexA >= 0) {
            A[index--] = A[indexA--];
        }

        while (indexB >= 0) {
            A[index--] = B[indexB--];
        }
        return A;
    }

    public static void main(String[] args) {
        int[] array = {1, 2, 3, 5, 2, 3};
        int[] array2 = {54,35,48,36,27,12,44,44,8,14,26,17,28};
        int[] array3 = {2,1,4,3,6,5,8,7,10,9};
        int[] A = {1, 2, 3, 4, 5, 0, 0 ,0 ,0};
        int[] B = {2, 3, 7, 9};
        int[] ans = mergeAB(A, B, 5, B.length);
        System.out.println(Arrays.toString(ans));
    }
}
