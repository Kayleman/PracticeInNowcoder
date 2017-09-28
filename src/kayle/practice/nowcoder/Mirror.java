package kayle.practice.nowcoder;

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
 * 操作给定的二叉树，将其变换为源二叉树的镜像。
 * 解题思路:
 * 借用一个tmp结点，直接对结点进行对调，
 * 然后继续递归地对调
 * */
public class Mirror {
    public void mirror(TreeNode root) {
        if(root == null) {
            return;
        }
        TreeNode tmp = root.left;
        root.left = root.right;
        root.right = tmp;
        mirror(root.left);
        mirror(root.right);
    }
    
}
