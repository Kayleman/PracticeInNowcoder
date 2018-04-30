package kayle.practice.nowcoder;



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
* 一个链表中包含环，请找出该链表的环的入口结点。
*
* 解题思路:
* 该链表形式为前面一段链表为单链表，后面一段形成环。
* 设置快慢两个指针，快的指针一次走两步，慢的一次走一步
* 假设x为环前面的路程，a为环入口到相遇点的路程（假设顺时针走）， c为环的长度
* 当快慢指针相遇的时候：
* 此时慢指针走的路程为slow = x + m * c + a
* 快指针走的路程为fast = x + n * c + a
* 2 * slow = fast
* 2 * ( x + m * c + a ) = (x + n * c + a)
* 从而可以推导出：
* x = (n - 2 * m ) * c - a
*   = (n - 2 * m -1 ) * c + c - a
* 即环前面的路程 = 数个环的长度（可能为0） + c - a
* 什么是c - a？这是相遇点后，环后面部分的路程。
* 所以，我们可以让一个指针从起点A开始走，让一个指针从相遇点B开始继续往后走，
* 2个指针速度一样，那么，当从原点的指针走到环入口点的时候（此时刚好走了x）
* 从相遇点开始走的那个指针也一定刚好到达环入口点。
* 所以2者会相遇，且恰好相遇在环的入口点。
* */
public class EntryNodeOfLoop1 {
    public ListNode EntryNodeOfLoop(ListNode pHead) {
        if(pHead == null || pHead.next == null
                || pHead.next.next == null) {
            return null;
        }

        ListNode slow = pHead.next;
        ListNode fast = pHead.next.next;

        while (slow != fast) {
            //如果fast的下一个和下下个节点都可以走，则fast走两步，slow走一步
            if(fast.next != null && fast.next.next != null) {
                fast = fast.next.next;
                slow = slow.next;
            } else {//否则就是没有环
                return null;
            }
        }

        slow = pHead;
        while (slow != fast) {
            fast = fast.next;
            slow = slow.next;
        }
        return slow;
    }
}
