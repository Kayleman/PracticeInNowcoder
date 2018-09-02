package algorithm.nowcoder_algorithm;

/**
 * 题目：
 * 输入一个复杂链表（每个节点中有节点值，以及两个指针，一个指向下一个节点，另一个特殊指针指向任意一个节点）。
 * 复制该链表并返回复制链表头结点。
 *
 * 解题思路：
 * 首先第一次遍历的时候复制每个节点，放在被复制节点后面。
 * 然后第二次遍历的时候修改random指针。
 * random指针指向被复制节点的random目标下一个节点。
 * 其中random指针指向是随机的，所以也有可能是null，如果为null需要将当前节点的random也指向null。
 * 复制完毕后需要进行链表的拆分，将链表分成两份相同链表，并返回复制的链表。
 * */
class RandomListNode {
    int label;
    RandomListNode next = null;
    RandomListNode random = null;

    RandomListNode(int label) {
        this.label = label;
    }
}


public class test5_11 {
    public RandomListNode Clone(RandomListNode pHead) {
        if (pHead == null) {
            return pHead;
        }
        RandomListNode cur = pHead;
        while (cur != null) {
            RandomListNode node = new RandomListNode(cur.label);
            node.next = cur.next;
            cur.next = node;
            cur = node.next;
        }
        RandomListNode pre = pHead;
        while (pre != null) {
            cur = pre.next;
            if(pre.random == null) {
                cur.random = null;
            } else {
                cur.random = pre.random.next;
            }
            pre = pre.next.next;
        }
        RandomListNode newHead = pHead.next;
        pre = pHead;
        cur = newHead;
        while (cur != null) {
            pre.next = pre.next.next;
            pre = pre.next;
            if(cur.next == null) {
                cur = null;
            }  else {
                cur.next = cur.next.next;
                cur = cur.next;
            }
        }
        return newHead;
    }

    public static void main(String[] args) {
        RandomListNode node1 = new RandomListNode(1);
        RandomListNode node2 = new RandomListNode(2);
        RandomListNode node3 = new RandomListNode(3);
        node1.next = node2;
        node2.next = node3;
        node1.random = node3;
        node2.random = node1;
        node3.random = node2;
        test5_11 t = new test5_11();
        RandomListNode node = t.Clone(node1);
        while (node != null) {
            System.out.print(node.label + "-->");
            node = node.next;
        }
    }
}
