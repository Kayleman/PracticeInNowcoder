package algorithm.nowcoder_algorithm;

import java.util.ArrayList;
import java.util.Stack;

public class test4_6 {
    public ArrayList<Integer> twoStacksSort(int[] numbers) {
        Stack<Integer> stack = new Stack<>();
        for (int i = numbers.length - 1; i >= 0; i--) {
            stack.push(numbers[i]);
        }
        sort(stack);
        ArrayList<Integer> list = new ArrayList<>();
        while (!stack.isEmpty()) {
            list.add(stack.pop());
        }
        return list;
    }

    public void sort(Stack<Integer> stack) {
        Stack<Integer> helpStack = new Stack<>();

        while(!stack.isEmpty()) {
            int cur = stack.pop();
            if(helpStack.isEmpty()) {
                helpStack.push(cur);
                continue;
            }
            while (!helpStack.isEmpty()) {
                int help = helpStack.pop();
                if(help < cur) {
                    stack.push(help);
                } else {
                    helpStack.push(help);
                    break;
                }
            }
            helpStack.push(cur);
        }

        while (!helpStack.isEmpty()) {
            stack.push(helpStack.pop());
        }
    }

    public static void main(String[] args) {
        int[] array = {3, 4, 5 ,1, 2};
        test4_6 t = new test4_6();

        System.out.println(t.twoStacksSort(array));
    }
}
