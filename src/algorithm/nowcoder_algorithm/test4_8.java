package algorithm.nowcoder_algorithm;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;

public class test4_8 {
    public int[] slide(int[] arr, int n, int w) {
        if(arr == null || w < 1 || n < w) {
            return null;
        }
        Deque<Integer> deque = new ArrayDeque<>();
        int[] ans = new int[n - w + 1];
        int index = 0;
        for (int i = 0; i < n; i++) {
            while(!deque.isEmpty() && arr[deque.peekLast()] <= arr[i]) {
                deque.removeLast();
            }
            deque.addLast(i);
            if(deque.peekFirst() == i - w) {
                deque.removeFirst();
            }
            if(i >= w - 1) {
                ans[index++] = arr[deque.peekFirst()];
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        test4_8 t = new test4_8();
        int[] array = {4, 3, 5, 4, 3, 3, 6, 7};
        System.out.println(Arrays.toString(t.slide(array, 8, 3)));
    }
}
