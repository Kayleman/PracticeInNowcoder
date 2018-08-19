package algorithm.nowcoder_algorithm;

import java.util.Arrays;

public class test2_7 {
    public static int[] heapSort(int[] A, int n) {
        for (int i = n; i > 0; i--) {
            maxHeapify(A, i);
            int temp = A[0];
            A[0] = A[i - 1];
            A[i - 1] = temp;
        }
        return A;
    }

    public static void maxHeapify(int[] array, int limit) {
        if(array.length <= 0 || array.length < limit) return;
        int parentIndex = limit / 2;
        for(; parentIndex >= 0; parentIndex--) {
            if(parentIndex * 2 >= limit) {
                continue;
            }
            int left = parentIndex * 2;
            int right = (left + 1) >= limit ? left : (left + 1);
            int maxChildIndex = array[left] >= array[right] ? left : right;
            if(array[maxChildIndex] > array[parentIndex]) {
                int temp = array[maxChildIndex];
                array[maxChildIndex] = array[parentIndex];
                array[parentIndex] = temp;
            }
        }
    }

    public static void main(String[] args) {
        int[] array = {1, 2, 3, 5, 2, 3};
        int[] array2 = {54,35,48,36,27,12,44,44,8,14,26,17,28};
        int[] ans = heapSort(array2, array2.length);
        System.out.println(Arrays.toString(ans));
    }
}
