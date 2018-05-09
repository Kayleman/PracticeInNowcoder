package sword_refers_to_offer;


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
 * 输入一棵二叉树，求该树的深度。
 * 从根结点到叶结点依次经过的结点（含根、叶结点）形成树的一条路径，最长路径的长度为树的深度。
 * 解题思路:
 * 就是深度遍历的方法,每次加上左右子树中深度最大的那一个
 * 
 * */
public class TreeDepth {
    public int treeDepth(TreeNode root) {
        if(root == null) {
        	return 0;
        }
        return 1 + Math.max(treeDepth(root.left), treeDepth(root.right));
    }
    
}
