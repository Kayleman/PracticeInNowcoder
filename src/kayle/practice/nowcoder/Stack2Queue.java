package kayle.practice.nowcoder;

import java.util.Stack;

/*
 * 题目描述:
 * 用两个栈来实现一个队列，完成队列的Push和Pop操作。 队列中的元素为int类型。
 * 
 * 解题思路:
 * 进队就把数压入栈1，在要出队的时候判断栈2是否为空，
 * 如果栈2不空，就直接从栈2出队。
 * 如果栈2空，就将栈1所有的数压入栈2.
 * 当栈1栈2都为空的时候，抛出异常，说明队列已经是空。
 * */
public class Stack2Queue {
	Stack<Integer> stack1 = new Stack<Integer>();
	Stack<Integer> stack2 = new Stack<Integer>();

	public void push(int node) {
		stack1.push(node);
	}

	public int pop() {
		if (stack1.empty() && stack2.empty()) {
			throw new RuntimeException("Queue is empty!");
		}
		if (stack2.empty()) {
			while (!stack1.empty()) {
				stack2.push(stack1.pop());
			}
		}
		// if(!stack2.isEmpty()) {
		return stack2.pop();
		// }
	}

}