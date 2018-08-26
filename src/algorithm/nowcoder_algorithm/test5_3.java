package algorithm.nowcoder_algorithm;

public class test5_3 {
    public ListNode removeNode(ListNode pNode, int delVal) {
        if(pNode.val == delVal) {
            ListNode newHead = pNode.next;
            pNode.next = null;
            return newHead;
        }
        ListNode pre = pNode;
        ListNode cur = pNode.next;
        while (cur.val != delVal) {
            pre = pre.next;
            cur = cur.next;
        }

        pre.next = cur.next;

        return pNode;

    }
}
