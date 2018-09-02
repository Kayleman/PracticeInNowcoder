package algorithm.nowcoder_algorithm;

/**
 * 题目：
 * 如何判断两个有环单链表是否相交？相交的话返回第一个相交的节点，不想交的话返回空。
 * 如果两个链表长度分别为N和M，请做到时间复杂度O(N+M)，额外空间复杂度O(1)。
 * 给定两个链表的头结点head1和head2(注意，另外两个参数adjust0和adjust1用于调整数据,与本题求解无关)。
 * 请返回一个bool值代表它们是否相交。
 *
 * 解题思路：
 * 1.找到两个链表的入环结点，如果两个结点相同，说明是同一个入环结点，一定相交。
 * 2.如果两个结点不同，则去寻找两个链表在环中相遇的结点，为相交结点。如果没有，则不相交。
 * */
public class test5_14 {
    public boolean chkInter(ListNode head1, ListNode head2, int adjust0, int adjust1) {
        // write code here
        ListNode node1 = chkLoop(head1);
        ListNode node2 = chkLoop(head2);
        if (node1 == node2) {
            return true;
        }

        ListNode cur = node1.next;
        while (cur != node1) {
            if(cur == node2) {
                return true;
            }
            cur = cur.next;
        }
        return false;
    }

    public ListNode chkLoop(ListNode head) {
        // write code here
        ListNode slow = head;
        ListNode fast = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            if (slow == fast) {
                break;
            }
        }
        if (fast == null || fast.next == null) {
            return null;
        } else {
            fast = head;
            while (fast != slow) {
                fast = fast.next;
                slow = slow.next;
            }
            return fast;
        }
    }
}
