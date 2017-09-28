package kayle.practice.nowcoder;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
/**
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
 * 从上往下打印出二叉树的每个节点，同层节点从左至右打印。
 * 解题思路:
 * 这个其实就是层次遍历，用一个队列来存储父节点，注意在新建queue的时候用到了多态
 * 先把根结点出队，并且给treeNode记录，如果左节点不空，把左节点入队
 * 然后再右节点，最后把根节点的值添加到list
 * */
public class PrintFromTopToBottom {
    public ArrayList<Integer> printFromTopToBottom(TreeNode root) {
        ArrayList<Integer> list = new ArrayList<>();
        if(root == null) {
            return list;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        
        while(!queue.isEmpty()){
            TreeNode treeNode = queue.poll();
            if(treeNode.left != null) {
                queue.offer(treeNode.left);
            }
            if(treeNode.right != null) {
                queue.offer(treeNode.right);
            }
            list.add(treeNode.val);
        }
        
        return list;
    }
}
