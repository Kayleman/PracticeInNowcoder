package algorithm.nowcoder_algorithm;
/**
 * 题目：
 * 有一个整数val，如何在节点值有序的环形链表中插入一个节点值为val的节点，并且保证这个环形单链表依然有序。
 * 给定链表的信息，及元素的值A及对应的nxt指向的元素编号同时给定val，请构造出这个环形链表，并插入该值。
 *
 * 测试样例：
 * [1,3,4,5,7],[1,2,3,4,0],2
 * 返回：{1,2,3,4,5,7}
 *
 * 解题思路：
 * 找到结点大于等于前一个结点值，且小于当前结点值则为插入位置。
 * 主要是插入结点在头结点之前的特例需要判断，有两种情况：
 * 1.小于头结点
 * 2.大于尾结点
 * */
public class test5_2 {
    public ListNode insert(int[] A, int[] nxt, int val) {
        if(A.length == 0) {
            ListNode head = new ListNode(val);
            head.next = head;
            return head;
        }
        ListNode head = new ListNode(A[0]);
        ListNode tail = head;
        for (int i = 1; i < A.length; i++) {
            ListNode cur = new ListNode(A[i]);
            tail.next = cur;
            tail = cur;
        }
        //不形成环是因为题目最后输出会死循环输出结点值。
        //tail.next = head;

        ListNode node = new ListNode(val);
        ListNode pre = head;
        ListNode last = head.next;
        while (last != null) {
            if(node.val >= pre.val && node.val < last.val) {
                node.next = last;
                pre.next = node;
                return head;
            } else {
                pre = last;
                last = last.next;
            }
        }

        if(node.val >= pre.val) {
            pre.next = node;
        }

        if(node.val < head.val) {
            node.next = head;
            head = node;
        }
        return head;

    }

    public static void main(String[] args) {
        int[] array = {1, 3, 4, 5, 7};
        int[] next = {1, 2, 3, 4, 0};

    }
}
