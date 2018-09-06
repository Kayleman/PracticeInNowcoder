package algorithm.nowcoder_algorithm;

import java.util.Arrays;
import java.util.Stack;

/**
 * 题目：
 * 对于一个没有重复元素的整数数组，请用其中元素构造一棵MaxTree，MaxTree定义为一棵二叉树，
 * 其中的节点与数组元素一一对应，同时对于MaxTree的每棵子树，它的根的元素值为子树的最大值。
 * 现有一建树方法，对于数组中的每个元素，其在树中的父亲为数组中它左边比它大的第一个数和右边比它大的第一个数中更小的一个。
 * 若两边都不存在比它大的数，那么它就是树根。请设计O(n)的算法实现这个方法。
 * 给定一个无重复元素的数组A和它的大小n，
 * 请返回一个数组，其中每个元素为原数组中对应位置元素在树中的父亲节点的编号，若为根则值为-1。
 *
 * 测试样例：
 * [3,1,4,2],4
 * 返回：[2,0,-1,2]
 *
 * 解题思路：
 * 遍历数组，去寻找每个数字左边最靠近的且比它大的数，没有就记为null
 * 再去寻找右边最靠近且比它大的数字，没有就记为null
 * 这样可以得到两个数组，这两个数组中对应位置取更小的值，即为父节点。
 * 所以可以用栈来找到相应的数组
 * */
public class test4_9 {
    public int[] buildMaxTree(int[] A, int n) {
        int[] res = new int[A.length];
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < n; i++) {
            while (!stack.isEmpty() && A[stack.peek()] < A[i]) {
                stack.pop();
            }
            if(stack.isEmpty()) {
                res[i] = -1;
            } else {
                res[i] = stack.peek();
            }
            stack.push(i);
        }
        stack.clear();

        for (int i = n - 1; i >= 0; i--) {
            while (!stack.isEmpty() && A[stack.peek()] < A[i]) {
                stack.pop();
            }
            if(!stack.isEmpty() && (res[i] == -1 || A[stack.peek()] < A[res[i]])) {
                res[i] = stack.peek();
            }
            stack.push(i);
        }
        return res;
    }

    public static void main(String[] args) {
        int[] array = {3, 1, 4, 2};
        test4_9 t = new test4_9();
        System.out.println(Arrays.toString(t.buildMaxTree(array, array.length)));
    }
}
