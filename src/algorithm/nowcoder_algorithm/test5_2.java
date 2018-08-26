package algorithm.nowcoder_algorithm;

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
