package algorithm.nowcoder_algorithm;

import java.util.ArrayList;
import java.util.Stack;
/**
 * 题目：
 * 请编写一个程序，按升序对栈进行排序（即最大元素位于栈顶），
 * 要求最多只能使用一个额外的栈存放临时数据，但不得将元素复制到别的数据结构中。
 *
 * 给定一个int[] numbers(C++中为vector&ltint>)，其中第一个元素为栈顶，请返回排序后的栈。
 * 请注意这是一个栈，意味着排序过程中你只能访问到第一个元素。
 *
 * 测试样例：
 * [1,2,3,4,5]
 * 返回：[5,4,3,2,1]
 *
 * 解题思路：
 * 再新建一个辅助栈，类似于汉诺塔的方法，为了区别，将最终返回的栈称谓返回栈
 * 如果辅助栈为空，则直接将返回栈顶元素入栈。
 * 将辅助栈中的元素与返回栈元素进行对比，如果是辅助栈顶元素小于当前栈顶元素，则将辅助栈顶元素放到返回栈中
 * 否则就将辅助栈顶元素重新入辅助栈，并且结束循环，结束循环后会把当前元素入辅助栈
 * 不断循环之后在辅助栈内就会倒序排好序，然后再出栈入返回栈。
 * */
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
