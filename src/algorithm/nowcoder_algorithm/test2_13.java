package algorithm.nowcoder_algorithm;

import java.util.Arrays;

public class test2_13 {
    public static int[] sortElement(int[] A, int n, int k) {
        for(int i = n - 1; i > 0; i--) {
            int right = i;
            int left = (i - k) <= 0 ? 0 : (i - k);
            maxHeapify(A, left, right);
        }
        return A;
    }


    public static void maxHeapify(int[] array, int leftIndex, int rightIndex) {
        // 数组从 0 ~ n-1
        int limit = rightIndex - leftIndex;
        int parentIndex = (limit - 1) / 2;
        for (; parentIndex >= 0; parentIndex--) {
            int left = parentIndex * 2 + 1;
            int right = (left + 1) > limit ? left : (left + 1);
            int maxChildIndex = array[left + leftIndex] >= array[right + leftIndex] ? left : right;
            if(array[maxChildIndex + leftIndex] > array[parentIndex + leftIndex]) {
                int temp = array[maxChildIndex + leftIndex];
                array[maxChildIndex + leftIndex] = array[parentIndex + leftIndex];
                array[parentIndex + leftIndex] = temp;
            }
        }
        System.out.println("交换前：" + Arrays.toString(array));
        int temp = array[leftIndex];
        array[leftIndex] = array[rightIndex];
        array[rightIndex] = temp;
        System.out.println("交换后：" + Arrays.toString(array));
        System.out.println("----------------------------");
    }

    public static void main(String[] args) {
        int[] array = {1, 2, 3, 5, 2, 3};
        int[] array2 = {54,35,48,36,27,12,44,44,8,14,26,17,28};
        int[] array3 = {2,1,4,3,6,5,8,7,10,9};
        int[] ans = sortElement(array3, array3.length, 2);
        System.out.println(Arrays.toString(ans));
    }
}
