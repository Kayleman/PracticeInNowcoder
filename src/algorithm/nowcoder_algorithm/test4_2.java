package algorithm.nowcoder_algorithm;

import java.util.Stack;

public class test4_2 {
    Stack<Integer> stackData = new Stack();
    Stack<Integer> stackMin = new Stack();
    int min = 9999;
    public void push(int node) {
        stackData.push(node);
        if(min >= node) {
            stackMin.push(node);
            min = node;
        } else {
            stackMin.push(min);
        }
    }

    public void pop() {
        stackData.pop();
        stackMin.pop();
    }

    public int top() {
        return stackData.peek();
    }

    public int min() {
        return stackMin.peek();
    }
}
