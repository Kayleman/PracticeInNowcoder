package algorithm.nowcoder_algorithm;

import java.util.Arrays;
import java.util.Stack;
/**
 * 题目：
 * 实现一个栈的逆序，但是只能用递归函数和这个栈本身的pop操作来实现，而不能自己申请另外的数据结构。
 * 给定一个整数数组A即为给定的栈，同时给定它的大小n，请返回逆序后的栈。
 *
 * 测试样例：
 * [4,3,2,1],4
 * 返回：[1,2,3,4]
 *
 * 解题思路：
 * 使用递归的方法，每次取出栈底元素，然后调用逆序函数，不断递归，
 * 在递归最后一层入栈，不断向上层返回，最终序列就为逆序后的栈
 * */
public class test4_5 {

    public int[] reverseStack(int[] A, int n) {
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < n; i++) {
            stack.push(A[i]);
        }
        reverse(stack);
        int index = n - 1;
        while (!stack.isEmpty()) {
            A[index--] = stack.pop();
        }
        return A;
    }

    public void reverse(Stack<Integer> stack) {
        if (stack.isEmpty()) {
            return;
        }
        int num = getDeepNum(stack);
        reverse(stack);
        stack.push(num);
    }

    public int getDeepNum(Stack<Integer> stack) {
        int result = stack.pop();
        if (stack.isEmpty()) {
            return result;
        } else {
            int last = getDeepNum(stack);
            stack.push(result);
            return last;
        }
    }

    public static void main(String[] args) {
        test4_5 t = new test4_5();
        int[] array = {4, 3, 2, 1};
        System.out.println(Arrays.toString(t.reverseStack(array, array.length)));
    }
}
