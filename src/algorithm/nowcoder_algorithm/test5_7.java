package algorithm.nowcoder_algorithm;
/**
 * 题目：
 * 有一个单链表，请设计一个算法，使得每K个节点之间逆序，如果最后不够K个节点一组，则不调整最后几个节点。
 * 例如链表1->2->3->4->5->6->7->8->null，K=3这个例子。
 * 调整后为，3->2->1->6->5->4->7->8->null。
 * 因为K==3，所以每三个节点之间逆序，但其中的7，8不调整，因为只有两个节点不够一组。
 *
 * 给定一个单链表的头指针head,同时给定K值，返回逆序后的链表的头指针。
 *
 * 解题思路：
 * 使用count来记录遍历了多少个结点，如果等于k，即当前指针指向一组逆序结点的下一组头结点
 * 递归调用函数，从后开始逆序。
 * */
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
