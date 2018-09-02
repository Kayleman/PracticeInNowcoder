package algorithm.nowcoder_algorithm;
/**
 * 题目：
 * 现在有一个单链表。链表中每个节点保存一个整数，再给定一个值val，把所有等于val的节点删掉。
 * 给定一个单链表的头结点head，同时给定一个值val，
 * 请返回清除后的链表的头结点，保证链表中有不等于该值的其它值。请保证其他元素的相对顺序。
 *
 * 测试样例：
 * {1,2,3,4,3,2,1},2
 * {1,3,4,3,1}
 *
 * 解题思路：
 * 老师建议是不使用pre的方法，使用复制结点来删除后一个结点，但是无法删除最后一个结点。
 * 于是直接使用pre的方法，比较简单，直接删除结点即可。
 * */
public class test5_8 {
    public ListNode clear(ListNode head, int val) {
        // write code here
        if(head == null) {
            return head;
        }
        ListNode pre = head;
        ListNode cur = head.next;
        while (head.val == val) {
            pre = head;
            cur = head.next;
            head = head.next;
        }
        while (cur != null) {
            if (cur.val == val) {
               pre.next = cur.next;
               cur = cur.next;
            } else {
                cur = cur.next;
                pre = pre.next;
            }
        }
        return head;
    }

    public static void main(String[] args) {
        ListNode node1 = new ListNode(1);
        ListNode node2 = new ListNode(2);
        ListNode node3 = new ListNode(3);
        ListNode node4 = new ListNode(4);
        ListNode node5 = new ListNode(3);
        ListNode node6 = new ListNode(2);
        ListNode node7 = new ListNode(1);
        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node5;
        node5.next = node6;
        node6.next = node7;
        test5_8 t =  new test5_8();
        ListNode node = t.clear(node1, 2);
        while (node != null) {
            System.out.print(node.val + "-->");
            node = node.next;
        }
    }
}
