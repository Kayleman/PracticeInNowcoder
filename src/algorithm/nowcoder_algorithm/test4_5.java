package algorithm.nowcoder_algorithm;

import java.util.Arrays;
import java.util.Stack;

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
