package algorithm.nowcoder_algorithm;

import java.util.Arrays;

public class test2_6 {
    public static int[] quickSort(int[] A, int n) {
        sort(A, 0, n - 1);
        return A;
    }

    public static void sort(int[] arr, int low, int high) {
        if(arr.length <= 0) return;
        if(low >= high) return;
        int left = low;
        int right = high;

        int pivot = arr[left];
        while(left < right) {
            while (left < right && arr[right] >= pivot) {
                right--;
            }
            arr[left] = arr[right];
            while (left < right && arr[left] <= pivot) {
                left++;
            }
            arr[right] = arr[left];
        }
        arr[left] = pivot;
        sort(arr, low, left - 1);
        sort(arr, left + 1, high);
    }

    public static void main(String[] args) {
        int[] array = {1, 2, 3, 5, 2, 3};
        int[] array2 = {54,35,48,36,27,12,44,44,8,14,26,17,28};
        int[] ans = quickSort(array2, array2.length);
        System.out.println(Arrays.toString(ans));
    }
}
