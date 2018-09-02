package algorithm.nowcoder_algorithm;

import java.util.Arrays;
import java.util.Stack;

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
