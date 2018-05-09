package sword_refers_to_offer;

/*
 public class ListNode {
    int val;
    ListNode next = null;

    ListNode(int val) {
        this.val = val;
    }
}
*/

/*
* 题目描述:
* 在一个排序的链表中，存在重复的结点，请删除该链表中重复的结点，重复的结点不保留，返回链表头指针。
* 例如，链表1->2->3->3->4->4->5 处理后为 1->2->5
*
* 解题思路:
* 还有特殊情况是表头就是重复的，比如1->1->3->3->4->4->5
* 要建立一个新的头结点newHead来指向原来的节点pHead，
* 再用一个前驱节点pre为第一个重复节点前驱
* 如果有两个值相等，记录下值，然后进入while循环比较，
* pHead一直向后走，直到不相等为止，把pre指向当前不重复的pHead
* 否则的话，pre指向pHead,pHead继续向后走一步
* 最后返回的是新的头结点的next
* */
public class DeleteDuplication {
    public ListNode deleteDuplication(ListNode pHead) {
        if(pHead == null || pHead.next == null) {
            return pHead;
        }
        ListNode newHead = new ListNode(-999);
        newHead.next = pHead; //建立新的头结点
        ListNode pre = newHead; //指向第一个重复节点前驱
        while (pHead != null && pHead.next != null) {
            if(pHead.val == pHead.next.val) {
                int value = pHead.val;
                while (pHead != null && pHead.val == value) {
                    pHead = pHead.next;
                }
                pre.next = pHead;
            } else {
                pre = pHead;
                pHead = pHead.next;
            }
        }
        return newHead.next;
    }
}
