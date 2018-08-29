package algorithm.nowcoder_algorithm;

import java.util.ArrayList;

public class test5_6 {
    public int[] findCommonParts(ListNode headA, ListNode headB) {
        // write code here
        ArrayList<Integer> list = new ArrayList<>();
        while (headA != null && headB != null) {
            if(headA.val == headB.val) {
                list.add(headA.val);
                headA = headA.next;
                headB = headB.next;
            } else if(headA.val > headB.val) {
                headB = headB.next;
            } else {
                headA = headA.next;
            }
        }
        int[] ans = new int[list.size()];
        int index = 0;
        for(Integer num:list) {
            ans[index++] = num;
        }
        list.clear();
        return ans;
    }
}
