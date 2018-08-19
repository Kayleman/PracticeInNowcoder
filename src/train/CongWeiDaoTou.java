package train;

import java.util.ArrayList;
import java.util.Collections;

public class CongWeiDaoTou {
    public static void main(String[] args) {
        CongWeiDaoTou C = new CongWeiDaoTou();
        ListNode node = new ListNode();

        for (int i = 0; i < 10; i++) {
            node.add(i);
        }
        //node.print(node.head);
        ArrayList<Integer> list = C.printListFromTailToHead(node.head);
        System.out.println(list.toString());

    }

    public ArrayList<Integer> printListFromTailToHead(ListNode listNode) {
        ArrayList<Integer> list = new ArrayList<>();
        if(listNode == null) {
            return list;
        }
        //list.add(listNode.val);
        while (listNode != null) {
            list.add(listNode.val);
            listNode = listNode.next;
        }
        Collections.reverse(list);
        return list;
    }
}
