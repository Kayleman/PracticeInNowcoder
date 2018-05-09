package sword_refers_to_offer;

/*
 * 题目描述:
 * 输入两个整数序列，第一个序列表示栈的压入顺序，请判断第二个序列是否为该栈的弹出顺序。
 * 假设压入栈的所有数字均不相等。例如序列1,2,3,4,5是某栈的压入顺序，
 * 序列4，5,3,2,1是该压栈序列对应的一个弹出序列，但4,3,5,1,2就不可能是该压栈序列的弹出序列。
 * （注意：这两个序列的长度是相等的）
 * 
 * 解题思路:
 * 将pushA的元素依次进栈，在进栈的时候判断一下栈是否非空，且栈顶元素是否等于popA的Index指向的元素
 * 如果是，就出栈，Index向后移动，循环到最后 如果栈为空，就返回true 否则就不是弹出序列返回false
 * */
import java.util.Stack;

public class IsPopOrder {
    public boolean isPopOrder(int [] pushA,int [] popA) {
        int len = pushA.length;
        Stack<Integer> stack = new Stack<>();
        int popIndex = 0;
        
        for(int i = 0; i < len; i++) {
            stack.push(pushA[i]);
            while(!stack.empty() && stack.peek() == popA[popIndex]) {
                stack.pop();
                popIndex++;
            }
        }
        
        return stack.empty();
    }
}

