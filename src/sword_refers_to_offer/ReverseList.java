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
 * 输入一个链表，反转链表后，输出链表的所有元素。
 * 解题思路:
 * 定义两个空指针，pre和next pre来记录新的头结点的位置，next记录head.next的位置 防止断链
 * 1->2->3->4->5将中间断开，反向连接pre始终指向左边链表的头部 head始终指向右侧链表的头部
 * 1<-2 3->4->5
 * 当head指向null 说明到链表尾部了，结束
 * */
public class ReverseList {
    public ListNode reverseList(ListNode head) {
    	if(head == null) {
        	return null;
        }
    	
        ListNode pre = null; 
        ListNode next = null;
        
        while(head != null) {
            next = head.next;
            head.next = pre;
            pre = head;
            head = next;
        }
        
        return pre;
    }
}

