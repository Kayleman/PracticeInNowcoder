package kayle.practice.nowcoder;

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
 * 输入两个单调递增的链表，输出两个链表合成后的链表，
 * 当然我们需要合成后的链表满足单调不减规则。
 * 解题思路:
 * 新建一个head头结点，在两个链表中递归地查找，将最小的节点存入head
 * */
public class Merge {
    public ListNode merge(ListNode list1,ListNode list2) {
        ListNode head = null;
        
        if(list1 == null) {
            return list2;
        }
        
        if(list2 == null) {
            return list1;
        }
        
        if(list1.val < list2.val) {
            head = list1;
            head.next = merge(list1.next, list2);
        }else {
            head = list2;
            head.next = merge(list1, list2.next);
        }
        
        return head;
    }
}

