package algorithm.nowcoder_algorithm;

public class test5_13 {
    public boolean chkIntersect(ListNode headA, ListNode headB) {
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

    public static void main(String[] args) {
        test5_13 t = new test5_13();
        ListNode node1 = new ListNode(1);
        ListNode node2 = new ListNode(2);
        ListNode node3 = new ListNode(3);
        ListNode node4 = new ListNode(4);
        ListNode node5 = new ListNode(5);
        ListNode node6 = new ListNode(6);
        ListNode node7 = new ListNode(7);

        ListNode node2_1 = new ListNode(11);
        ListNode node2_2 = new ListNode(22);
        ListNode node2_3 = new ListNode(33);
        ListNode node2_4 = new ListNode(44);
        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node5;
        node5.next = node6;
        node6.next = node7;
        node2_1.next = node2_2;
        node2_2.next = node2_3;
        node2_3.next = node2_4;
        node2_4.next = node4;
        System.out.println(t.chkIntersect(node1, node2_1));
    }
}
