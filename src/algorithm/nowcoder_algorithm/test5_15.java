package algorithm.nowcoder_algorithm;

/**
 * 题目：
 * 给定两个单链表的头节点head1和head2，如何判断两个链表是否相交？相交的话返回true，不相交的话返回false。
 * 给定两个链表的头结点head1和head2(注意，另外两个参数adjust0和adjust1用于调整数据,与本题求解无关)。
 * 请返回一个bool值代表它们是否相交。
 *
 * 解题思路：
 * 首先判断链表是否有环，有环返回入环结点，无环返回null。
 * 则可分为三种情况：
 * 1.两个链表中有一个为无环，一个有环，则它们不可能相交，返回false。
 * 2.两个链表都为无环，则使用无环链表判断是否相交的方法进行判断。
 * 3.两个链表都为有环，则使用有环链表判断是否相交的方法进行判断。
 * */
public class test5_15 {
    public boolean chkInter(ListNode head1, ListNode head2, int adjust0, int adjust1) {
        // write code here
        ListNode node1 = chkLoop(head1);
        ListNode node2 = chkLoop(head2);
        if((node1 == null && node2 != null) || (node1 != null && node2 == null)) {
            return false;
        } else if(node1 == null && node2 == null) {
            return chkInterNoLoop(head1, head2);
        } else {
            return chkInterLoop(head1, head2);
        }

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

    public boolean chkInterLoop(ListNode head1, ListNode head2) {
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

    public boolean chkInterNoLoop(ListNode headA, ListNode headB) {
        // write code here
        int lenA = 0;
        int lenB = 0;
        ListNode curA = headA;
        ListNode curB = headB;
        while (curA != null) {
            lenA++;
            curA = curA.next;
        }
        while (curB != null) {
            lenB++;
            curB = curB.next;
        }
        curA = headA;
        curB = headB;
        if(lenA > lenB) {
            for (int i = 0; i < (lenA - lenB); i++) {
                curA = curA.next;
            }
        } else {
            for (int i = 0; i < (lenB - lenA); i++) {
                curB = curB.next;
            }
        }

        while (curA != null) {
            if(curA == curB) {
                return true;
            } else {
                curA = curA.next;
                curB = curB.next;
            }
        }

        return false;
    }
}
