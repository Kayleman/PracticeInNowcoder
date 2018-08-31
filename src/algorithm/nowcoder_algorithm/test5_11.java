package algorithm.nowcoder_algorithm;


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
