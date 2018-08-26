package algorithm.nowcoder_algorithm;

import java.util.Arrays;

public class test2_17 {
    public static int[] sortThreeColor(int[] A, int n) {
        int left = 0;
        int right = n - 1;
        for (int i = 0; i <= right;) {

            if(A[i] == 0) {
                int temp = A[i];
                A[i] = A[left];
                A[left] = temp;
                System.out.println("是0交换："+ Arrays.toString(A));
                left++;
            } else if(A[i] == 2) {
                int temp = A[i];
                A[i] = A[right];
                A[right] = temp;
                System.out.println("是2交换："+ Arrays.toString(A));
                right--;
                continue;
            }
            i++;
        }
        return A;
    }

    public static void main(String[] args) {
        int[] array = {1, 2, 3, 5, 2, 3};
        int[] array2 = {54,35,48,36,27,12,44,44,8,14,26,17,28};
        int[] array3 = {2,1,4,3,6,5,8,7,10,9};
        int[] array4 = {0, 1, 1, 0, 2, 2};
        int[] array5 = {1, 2, 0, 2};
        int[] ans = sortThreeColor(array5, array5.length);
        System.out.println(Arrays.toString(ans));
    }
}
