package algorithm.nowcoder_algorithm;

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
