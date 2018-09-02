package algorithm.nowcoder_algorithm;

/**
 * 题目：
 * 如何判断一个单链表是否有环？有环的话返回进入环的第一个节点的值，无环的话返回-1。
 * 如果链表的长度为N，请做到时间复杂度O(N)，额外空间复杂度O(1)。
 * 给定一个单链表的头结点head（注意另一个参数adjust为加密后的数据调整参数，方便数据设置，与本题求解无关)，请返回所求值。
 *
 * 解题思路：
 * 用快慢两个指针进行遍历，慢指针一次走一步，快指针一次走两步。
 * 如果快指针或快指针的next为null，则说明没有环。
 * 如果期间快慢指针相遇，则说明有环。
 * 将快指针放回头结点位置继续开始走，一次走一步。
 * 当与慢指针再次相遇，当前位置即为入环结点位置。
 * */
public class test5_12 {
    public int chkLoop(ListNode head, int adjust) {
        // write code here
        ListNode slow = head;
        ListNode fast = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            if(slow == fast) {
                break;
            }
        }
        if(fast == null || fast.next == null) {
            return -1;
        } else {
            fast = head;
            while (fast != slow) {
                fast = fast.next;
                slow = slow.next;
            }
            return fast.val;
        }

    }
}
