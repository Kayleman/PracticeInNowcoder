package algorithm.nowcoder_algorithm;

import java.util.Arrays;

public class test2_7 {
    public static int[] heapSort(int[] A, int n) {
        for (int i = n - 1; i > 0; i--) {
            maxHeapify_2(A, i);
//            int temp = A[0];
//            A[0] = A[i];
//            A[i] = temp;
            System.out.println("交换后："  + Arrays.toString(A));
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

    public static void maxHeapify_2(int[] array, int index) {
        // 数组从 0 ~ n-1
        int parentIndex = (index - 1) / 2;
        for (; parentIndex >= 0; parentIndex--) {
            int left = parentIndex * 2 + 1;
            int right = (left + 1) > index ? left : (left + 1);
            int maxChildIndex = array[left] >= array[right] ? left : right;
            if(array[maxChildIndex] > array[parentIndex]) {
                int temp = array[maxChildIndex];
                array[maxChildIndex] = array[parentIndex];
                array[parentIndex] = temp;
            }
        }
        System.out.println("交换前：" + Arrays.toString(array));
        int temp = array[0];
        array[0] = array[index];
        array[index] = temp;
    }

    public static void main(String[] args) {
        int[] array = {1, 2, 3, 5, 2, 3};
        int[] array2 = {54,35,48,36,27,12,44,44,8,14,26,17,28};
        int[] array3 = {3, 1, 5, 1, 3, 8, 1, 3, 0};
        int[] ans = heapSort(array2, array2.length);
        System.out.println(Arrays.toString(ans));
    }
}
