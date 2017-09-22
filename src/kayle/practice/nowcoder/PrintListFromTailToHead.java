package kayle.practice.nowcoder;

/**
*    public class ListNode {
*        int val;
*        ListNode next = null;
*
*        ListNode(int val) {
*            this.val = val;
*        }
*    }
*
*/

/*
 * 题目描述:
 * 输入一个链表，从尾到头打印链表每个节点的值。
 * 
 * 解题思路:
 * 使用一个栈，把链表的所有节点都压入栈
 * 再取出添加到arrayList里返回
 * */
import java.util.ArrayList;
import java.util.Stack;
public class PrintListFromTailToHead {
    public ArrayList<Integer> printListFromTailToHead(ListNode listNode) {
        ArrayList<Integer> arrayList = new ArrayList<>();
        Stack<Integer> stack = new Stack<>();
        
        while(listNode != null) {
            stack.push(listNode.val);
            listNode = listNode.next;
        }
        
        while(!stack.isEmpty()) {
            arrayList.add(stack.pop());
        }
        
        return arrayList;
    }
}

