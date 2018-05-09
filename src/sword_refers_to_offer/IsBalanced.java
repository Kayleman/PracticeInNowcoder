package sword_refers_to_offer;

/*
 * 题目描述:
 * 输入一棵二叉树，判断该二叉树是否是平衡二叉树。
 * 解题思路:
 * 可以先写一个计算树的深度的方法,
 * 可以设置一个全局变量isBalance,当两个子树深度之差大于1的时候.
 * isBalance置为false
 * 或者也可以不设置全局变量 而是返回-1,
 * 但是在计算深度的时候需要先判断左右子树的深度是不是>=0.
 * 是>=0才继续往下计算,否则继续返回-1
 * 这样最后返回的值就是<0的值,再判断最终深度是否<0.
 * 如果<0那么就返回false,说明不是平衡二叉树
 * */
public class IsBalanced {
	boolean isBalance = true;
    public boolean IsBalanced_Solution(TreeNode root) {
        treeDepth(root);
        return isBalance;
    }
    
    private int treeDepth(TreeNode root) {
        if(root == null) {
        	return 0;
        }
        
        int left = treeDepth(root.left);
        int right = treeDepth(root.right);
        int res = Math.abs(left - right);
        if(res > 1) {
        	isBalance = false;
        }
        return left > right ? left + 1 : right + 1;
    }
}

