package sword_refers_to_offer;


/*
public class ListNode {
    int val;
    ListNode next = null;

    ListNode(int val) {
        this.val = val;
    }
}*/

/*
 * 题目描述:
 * 输入一个链表，输出该链表中倒数第k个结点。
 * 解题思路:
 * 使用两个指针left和right
 * 先让right先走k-1步
 * 然后一起走，当right走到最后的时候，left刚好在倒数第k个位置
 * */
public class FindKthToTail {
    public ListNode findKthToTail(ListNode head,int k) {
        if(head == null || k <= 0) {
            return null;
        }
        ListNode left = head;
        ListNode right = head;
        
        for(int i = 0; i < k - 1; i++) {
            if(right.next != null) {
                right = right.next;
            }else {
                return null;
            }
        }
        
        while(right.next != null) {
            left = left.next;
            right = right.next;
        }
        
        return left;
    }
}

