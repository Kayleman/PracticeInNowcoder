package kayle.practice.nowcoder;

import java.util.ArrayList;
import java.util.Stack;
/*
public class TreeNode {
    int val = 0;
    TreeNode left = null;
    TreeNode right = null;

    public TreeNode(int val) {
        this.val = val;

    }

}
*/

/*
* 题目描述:
* 请实现一个函数按照之字形打印二叉树，即第一行按照从左到右的顺序打印，第二层按照从右至左的顺序打印，
* 第三行按照从左到右的顺序打印，其他行以此类推。
*
* 解题思路:
* 明显的是需要层次遍历树，但是直接用队列遍历树然后reverse ArrayList太没有效率了，
* 所以利用栈的特性，用栈来层次遍历，按奇数偶数层不同来进行不同的push次序。
* 每次一行遍历完后把tmpList添加到resList里面。
* */
public class PrintTree {
    public ArrayList<ArrayList<Integer>> Print(TreeNode pRoot) {
        ArrayList<ArrayList<Integer>> resList = new ArrayList<ArrayList<Integer>>();
        //存放奇数层的节点
        Stack s1 = new Stack();
        s1.push(pRoot);
        //存放偶数层的节点，并且是从右往左放
        Stack s2 = new Stack();
        int layer = 1;

        while (!s1.empty() || !s2.empty()) {
            if(layer % 2 != 0) {
                ArrayList<Integer> tmpList = new ArrayList<Integer>();
                while (!s1.empty()) {
                    TreeNode tmpNode = (TreeNode) s1.pop();
                    if(tmpNode != null) {
                        tmpList.add(tmpNode.val);
                        //偶数行应该是从右往左，但是由于栈是先进后出，所以进栈应该从左往右进
                        s2.push(tmpNode.left);
                        s2.push(tmpNode.right);
                    }
                }
                if(!tmpList.isEmpty()) {
                    //每次一行遍历完后把tmpList添加到resList里面。
                    resList.add(tmpList);
                    layer++;
                }
            } else {
                ArrayList<Integer> tmpList = new ArrayList<Integer>();
                while (!s2.empty()) {
                    TreeNode tmpNode = (TreeNode) s2.pop();
                    if(tmpNode != null) {
                        tmpList.add(tmpNode.val);
                        //偶数行应该是从左往右，但是由于栈是先进后出，所以进栈应该从右往左进
                        s1.push(tmpNode.right);
                        s1.push(tmpNode.left);
                    }
                }
                if(!tmpList.isEmpty()) {
                    //每次一行遍历完后把tmpList添加到resList里面。
                    resList.add(tmpList);
                    layer++;
                }
            }
        }
        return resList;
    }

}