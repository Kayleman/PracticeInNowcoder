package algorithm.nowcoder_algorithm;
/**
 * 题目：
 * 给定一棵完全二叉树的根节点root，返回这棵树的节点个数。如果完全二叉树的节点数为N，请实现时间复杂度低于O(N)的解法。
 * 给定树的根结点root，请返回树的大小。
 *
 * 解题思路：
 * 因为给定的是完全二叉树，所以可以根据左右子树的深度来计算
 * 首先计算左右子树分别的深度
 * 1.如果深度相等，说明左边是完全二叉树，根据公式可以直接计算结点个数，再遍历计算右子树
 * 2.如果左边深度比右边大，说明右边为完全二叉树，根据公式计算，再遍历计算左子树
 * 因为是完全二叉树 不存在左边深度比右边小的情况
 * */
public class test6_7 {
    public int count(TreeNode root) {
        // write code here
        int res = 0;
        if(root == null) {
            return 0;
        }
        int leftDepth = getDepth(root.left);
        int rightDepth = getDepth(root.right);
        if(leftDepth == rightDepth) { //如果左右深度相等，说明左边是完全二叉树，根据公式可以直接计算结点个数，再遍历计算右子树
            res += (int) (Math.pow(2, leftDepth) - 1 + 1); //前面的为公式2^n -1 后面的+1是加上根节点
            res += count(root.right); //计算完根节点左边结点后继续计算右边结点
        } else if(leftDepth > rightDepth) { //如果左边深度更深，说明右边为完全二叉树，根据公式计算，再遍历计算左子树
            res += (int) (Math.pow(2, rightDepth) - 1 + 1); //同理
            res += count(root.left);
        }
        return res;
    }

    public int getDepth(TreeNode root) {
        int depth = 0;
        while (root != null) {
            depth++;
            root = root.left;
        }
        return depth;
    }
}
