package train;

public class ListNode {

    int val;
    ListNode next = null;

    public ListNode(){

    }

    ListNode(int val) {
        this.val = val;
    }

    public ListNode head;
    public ListNode current;

    public void add(int val) {
        if(head == null) {
            head = new ListNode(val);
            current = head;
        } else {
            current.next = new ListNode(val);
            current = current.next;
        }
    }

    public void print(ListNode node) {
        if(node == null) {
            return;
        }

        current = node;
        while(current != null) {
            System.out.print(current.val + "->");
            current = current.next;
        }
    }
}
