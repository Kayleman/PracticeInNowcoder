package algorithm.nowcoder_algorithm;

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
