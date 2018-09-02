package algorithm.nowcoder_algorithm;

/**
 * 题目：
 * 对于一个链表，我们需要用一个特定阈值完成对它的分化，使得小于等于这个值的结点移到前面，大于该值的结点在后面，
 * 同时保证两类结点内部的位置关系不变。
 * 给定一个链表的头结点head，同时给定阈值val，请返回一个链表，使小于等于它的结点在前，大于等于它的在后，保证结点值不重复。
 *
 * 测试样例：
 * {1,4,2,5},3
 * {1,2,4,5}
 *
 * 解题思路：
 * 首先将链表分成两段小链表，小于等于的值放前面，大于的放后面。
 * 记录住两个链表的头尾结点，后续再进行连接。
 * */
public class test5_5 {
    public ListNode listDivide(ListNode head, int val) {
        // write code here
        ListNode smallHead = null;
        ListNode smallTail = null;
        ListNode bigHead = null;
        ListNode bigTail = null;
        ListNode next = null;
        while (head != null) {
            //将当前节点断开成为单独的节点
            next = head.next;
            head.next = null;
            if(head.val <= val) {
                if(smallHead == null) {
                    smallHead = head;
                    smallTail = head;
                } else {
                    smallTail.next = head;
                    smallTail = head;
                }
            } else if(head.val > val) {
                if(bigHead == null) {
                    bigHead = head;
                    bigTail = head;
                } else {
                    bigTail.next = head;
                    bigTail = head;
                }
            }
            //恢复head为保存着的下一个节点
            head = next;
        }
        if(smallTail != null) {
            smallTail.next = bigHead;
        }

        if(smallHead != null) {
            return smallHead;
        } else {
            return bigHead;
        }
    }
}
