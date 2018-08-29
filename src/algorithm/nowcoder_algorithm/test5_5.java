package algorithm.nowcoder_algorithm;

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
