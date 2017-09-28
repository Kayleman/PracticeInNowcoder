package kayle.practice.nowcoder;


import java.util.Stack;
/*
 * 题目描述:
 * 定义栈的数据结构，请在该类型中实现一个能够得到栈最小元素的min函数。
 * 解题思路:
 * 定义两个栈，一个存储原始数据，一个存放最小数据
 * 进栈的时候先进初始数据栈，当最小数据栈是空的或者新的结点小于最小数据栈的顶部元素(即最小元素)
 * 那么就进最小数据栈，否则再一次把当前最小的元素进栈(防止出栈的时候栈的元素个数出错)
 * 出栈就两个栈一起出栈
 * top就是dataStack的栈顶元素
 * min就是minStack的栈顶元素
 * */
public class MinOfStack {
	Stack<Integer> dataStack = new Stack<>();
    Stack<Integer> minStack = new Stack<>();
    
    
    public void push(int node) {
        dataStack.push(node);
        if(minStack.empty() || node < minStack.peek()) {
            minStack.push(node);
        }else {
            minStack.push(minStack.peek());
        }
    }
    
    public void pop() {
        dataStack.pop();
        minStack.pop();
    }
    
    public int top() {
        return dataStack.peek();
    }
    
    public int min() {
        return minStack.peek();
    }
}
