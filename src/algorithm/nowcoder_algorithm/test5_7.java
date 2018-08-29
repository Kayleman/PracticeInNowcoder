package algorithm.nowcoder_algorithm;

public class test5_7 {
    public ListNode inverse(ListNode head, int k) {
        // write code here

        ListNode cur = head;
        int count = 0;
        while (cur != null && count != k) {
            count++;
            cur = cur.next;
        }

        if(count == k) {
            //递归直到最后面，才开始逆序，上一步递归传回来的head为当前的cur，
            //当前的head则为正序的第一个节点
            cur = inverse(cur, k);
            while (count-- > 0) {
                ListNode tmp = head.next;
                head.next = cur;
                cur = head;
                head = tmp;
            }
            head = cur;
        }
        return head;
    }
}
