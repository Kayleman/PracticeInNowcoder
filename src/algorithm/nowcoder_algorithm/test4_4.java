package algorithm.nowcoder_algorithm;

import java.util.Arrays;
import java.util.Stack;

public class test4_4 {
    Stack<Integer> stack1 = new Stack<>();
    Stack<Integer> stack2 = new Stack<>();

    public int[] twoStack(int[] ope, int n) {
        int count = 0;
        for (int i = 0; i < n; i++) {
            if(ope[i] == 0) {
                count++;
            }
        }
        int[] ans = new int[count];
        int index = 0;
        for (int i = 0; i < n; i++) {
            if(ope[i] != 0) {
                push(ope[i]);
            } else {
                int temp = pop();
                ans[index++] = temp;
            }
        }
        return ans;
    }

    public void push(int value) {
        stack1.push(value);
    }

    public int pop() {
        if(stack2.isEmpty()) {
            while (!stack1.isEmpty()) {
                stack2.push(stack1.pop());
            }
            return stack2.pop();
        } else {
            return stack2.pop();
        }
    }

    public static void main(String[] args) {
        test4_4 t = new test4_4();
        int[] array = {1, 2, 3, 0, 4, 0};
        System.out.println(Arrays.toString(t.twoStack(array, array.length)));
    }

}
