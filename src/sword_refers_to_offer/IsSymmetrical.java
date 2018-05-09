package sword_refers_to_offer;


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
* 请实现一个函数，用来判断一颗二叉树是不是对称的。
* 注意，如果一个二叉树同此二叉树的镜像是同样的，定义其为对称的。
*
* 解题思路:
* 使用递归来判断左右子树是否相等。
* 首先判断根节点的左右子树是否相等。
* 再判断对称方向的是否相等
* 即判断左子树的左子树和右子树的右子树是否相等，且左子树的右子树和右子树的左子树是否相等
* */
public class IsSymmetrical {
    boolean isSymmetrical(TreeNode pRoot) {
        if(pRoot == null) {
            return true;
        }
        //首先判断根节点的左右子树是否相等。
        return isSameRoot(pRoot.left, pRoot.right);
    }
    private boolean isSameRoot(TreeNode left, TreeNode right) {
        //都为空则走到尽头，返回true
        if(left == null && right == null) {
            return true;
        }
        //左右子树双方都不为空，再判断对称方向的是否相等
        if(left != null && right != null) {
            //首先要判断值相等
            //再判断左子树的左子树和右子树的右子树是否相等，且左子树的右子树和右子树的左子树是否相等
            //全部同时成立才返回true
            return left.val == right.val && isSameRoot(left.left, right.right)
                    && isSameRoot(left.right, right.left);
        }
        //一方不为空，一方为空则放回false
        return false;
    }
}