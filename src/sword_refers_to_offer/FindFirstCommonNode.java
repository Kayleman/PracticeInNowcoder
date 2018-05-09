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
 * 输入两个链表，找出它们的第一个公共结点。
 * 解题思路:
 * 因为公共结点之后的所有结点都是完全相同的
 * 所以可以先把两个链表的长度求出来
 * 把长的减去短的,这个长度就是长链表需要先走的步数
 * 之后两个链表一起向后走 直到找到一个相同结点为止 就是第一个公共结点
 * */
public class FindFirstCommonNode {
    public ListNode findFirstCommonNode(ListNode pHead1, ListNode pHead2) {
    	if(pHead1 == null || pHead2 == null) return null;
    	int len1 = linkLen(pHead1);
    	int len2 = linkLen(pHead2);
    	
    	if(len1 > len2) {
    		pHead1 = walk(pHead1, len1 - len2);
    	} else {
    		pHead2 = walk(pHead2, len2 - len1);
    	}
    	
    	while(pHead1 != null) {
    		if(pHead1 == pHead2) return pHead1;
    		
    		pHead1 = pHead1.next;
    		pHead2 = pHead2.next;
    	}
    	return null;
    }
    
    private static int linkLen(ListNode head) {
    	if(head == null) return 0;
    	int len = 0;
    	while(head != null) {
    		len++;
    		head = head.next;
    	}
    	return len;
    }
    
    private static ListNode walk(ListNode head, int step) {
    	while(step != 0) {
    		head = head.next;
    		step--;
    	}
    	return head;
    }
}