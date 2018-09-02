package algorithm.nowcoder_algorithm;


/**
 * 题目：
 * 请编写一个函数，检查链表是否为回文。
 * 给定一个链表ListNode* pHead，请返回一个bool，代表链表是否为回文。
 *
 * 测试样例：
 * {1,2,3,2,1}
 * 返回：true
 * {1,2,3,2,3}
 * 返回：false
 *
 * 解题思路：
 * 最简单的可以用栈来做，但是空间复杂度为O(n)
 * 可以使用快慢指针，快指针一次走两步，慢指针一次走一步。
 * 当快指针走到头的时候，慢指针指向中间结点或者中间右侧结点。
 * 从该结点开始逆序后面的结点。最后从两头往中间遍历。
 * 如果遍历结束都相同，则为回文返回true，否则返回false。
 * */
public class test5_9 {
    public boolean isPalindrome(ListNode pHead) {
        // write code here
        ListNode pSlow = pHead;
        ListNode pFast = pHead;
        //长度是奇数，slow指向中间结点
        //长度是偶数，slow指向中间右侧节点
        while (pFast != null && pFast.next != null) {
            pFast = pFast.next.next;
            pSlow = pSlow.next;
        }
        //从中间或中间右侧开始反转链表
        ListNode pPre = null;
        while (pSlow != null) {
            ListNode pNext = pSlow.next;
            pSlow.next = pPre;
            pPre = pSlow;
            pSlow = pNext;
        }

        ListNode pCur = pHead;
        while (pPre != null) {
            if(pCur.val == pPre.val) {
                pCur = pCur.next;
                pPre = pPre.next;
            } else {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        ListNode node1 = new ListNode(1);
        ListNode node2 = new ListNode(2);
        ListNode node3 = new ListNode(3);
        //ListNode node4 = new ListNode(4);
        ListNode node5 = new ListNode(3);
        ListNode node6 = new ListNode(2);
        ListNode node7 = new ListNode(1);
        node1.next = node2;
        node2.next = node3;
        node3.next = node5;
        //node4.next = node5;
        node5.next = node6;
        node6.next = node7;
        test5_9 t = new test5_9();
        System.out.println(t.isPalindrome(node1));
    }
}
