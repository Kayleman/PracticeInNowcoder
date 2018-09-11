package algorithm.nowcoder_algorithm;


public class test7_8 {
    public boolean check(TreeNode root) {
        return getDepth(root) >= 0;
    }

    public int getDepth(TreeNode root) {
        if(root == null) return 0;
        int leftDepth = getDepth(root.left);
        int rightDepth = getDepth(root.right);
        if(leftDepth < 0 || rightDepth < 0) return -1;
        if(Math.abs(leftDepth - rightDepth) > 1) return -1;
        return leftDepth > rightDepth ? leftDepth + 1: rightDepth + 1;//返回最深的子树深度+1，即为父节点深度
    }
}
