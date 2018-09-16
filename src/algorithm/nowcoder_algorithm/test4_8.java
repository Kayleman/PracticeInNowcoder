package algorithm.nowcoder_algorithm;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;
/**
 * 题目：
 * 有一个整型数组 arr 和一个大小为 w 的窗口从数组的最左边滑到最右边,窗口每次向右边滑一个位置。
 * 返回一个长度为n-w+1的数组res，res[i]表示每一种窗口状态下的最大值。
 * 以数组为[4,3,5,4,3,3,6,7]，w=3为例。
 * 因为第一个窗口[4,3,5]的最大值为5，第二个窗口[3,5,4]的最大值为5，第三个窗口[5,4,3]的最大值为5。
 * 第四个窗口[4,3,3]的最大值为4。第五个窗口[3,3,6]的最大值为6。
 * 第六个窗口[3,6,7]的最大值为7。所以最终返回[5,5,5,4,6,7]。
 *
 * 给定整形数组arr及它的大小n，同时给定w，请返回res数组。保证w小于等于n，同时保证数组大小小于等于500。
 *
 * 测试样例：
 * [4,3,5,4,3,3,6,7],8,3
 * 返回：[5,5,5,4,6,7]
 *
 * 解题思路：
 * 用双端队列来存储最大值下标序列
 * 如果队列尾部对应的值小于当前位置的值，则从尾部出队，直到没有小于i的值，将i从尾部入队
 * 判断最左端数字是否过时，如果过时则从头部出队，每次记录队列头部值为当前窗口最大值
 * */
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
