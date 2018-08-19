package algorithm.nowcoder_algorithm;

import java.util.Arrays;

public class test2_5 {
    public static int[] mergeSort(int[] A, int n) {
        split(A, 0, n - 1);
        return A;
    }

    public static void split(int[] array, int left, int right) {
        int mid = (left + right) / 2;
        if(left < right) {
            split(array, left, mid);
            split(array, mid + 1, right);
            merge(array, left, mid, right);
        }
    }

    public static void merge(int[] array, int left, int mid, int right) {
        int[] ans = new int[right - left + 1];
        int index = 0;
        int i = left;
        int j = mid + 1;
        while (i <= mid && j <= right) {
            if(array[i] < array[j]) {
                ans[index++] = array[i++];
            } else {
                ans[index++] = array[j++];
            }
        }
        while (i <= mid) {
            ans[index++] = array[i++];
        }
        while (j <= right) {
            ans[index++] = array[j++];
        }
        for (int k = 0; k < ans.length; k++) {
            array[k + left] = ans[k];
        }
    }

    public static void main(String[] args) {
        int[] array = {1, 2, 3, 5, 2, 3};
        int[] array2 = {54,35,48,36,27,12,44,44,8,14,26,17,28};
        int[] ans = mergeSort(array2, array2.length);
        System.out.println(Arrays.toString(ans));
    }
}
