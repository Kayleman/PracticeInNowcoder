package algorithm.nowcoder_algorithm;

/**
 * 题目：
 * 实现一个算法，删除单向链表中间的某个结点，假定你只能访问该结点。
 * 给定带删除的头节点和要删除的数字，请执行删除操作，返回删除后的头结点。链表中没有重复数字
 *
 * 解题思路：
 * 记录pre，然后遍历链表，当值相等，直接进行删除。
 * */
public class test5_3 {
    public ListNode removeNode(ListNode pNode, int delVal) {
        if(pNode.val == delVal) {
            ListNode newHead = pNode.next;
            pNode.next = null;
            return newHead;
        }
        ListNode pre = pNode;
        ListNode cur = pNode.next;
        while (cur.val != delVal) {
            pre = pre.next;
            cur = cur.next;
        }

        pre.next = cur.next;

        return pNode;

    }
}
