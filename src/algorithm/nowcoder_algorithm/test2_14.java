package algorithm.nowcoder_algorithm;

import java.util.Arrays;

public class test2_14 {
    public static boolean checkDuplicate(int[] a, int n) {
        heapSort(a);
        for (int i = 1; i < n; i++) {
            if(a[i - 1] == a[i]) {
                return true;
            }
        }
        return false;
    }

    public static void heapSort(int[] array) {
        for (int i = array.length - 1; i > 0; i--) {
            maxHeapify(array, i);
        }
    }

    public static void maxHeapify(int[] array, int index) {
        int parentIndex = (index - 1) / 2;
        for(; parentIndex >= 0; parentIndex--) {
            int left = parentIndex * 2 + 1;
            int right = (left + 1) > index ? left : (left + 1);
            int maxChildIndex = array[left] >= array[right] ? left : right;
            if(array[maxChildIndex] > array[parentIndex]) {
                int temp = array[maxChildIndex];
                array[maxChildIndex] = array[parentIndex];
                array[parentIndex] = temp;
            }
        }
        int temp = array[0];
        array[0] = array[index];
        array[index] = temp;
    }

    public static void main(String[] args) {
        int[] array = {1, 2, 3, 5, 2, 3};
        int[] array2 = {54,35,48,36,27,12,44,44,8,14,26,17,28};
        int[] array3 = {2,1,4,3,6,5,8,7,10,9};
        System.out.println(checkDuplicate(array, array.length));
        System.out.println(Arrays.toString(array));
    }
}
