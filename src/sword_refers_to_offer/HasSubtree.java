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
 * 输入两棵二叉树A，B，判断B是不是A的子结构。（ps：我们约定空树不是任意一个树的子结构）
 * 解题思路:
 * 利用递归的方法，一个一个结点地找，当找到根节点相同的时候，进入下一层递归
 * 当子树走到头的时候说明存在这个子树，返回true
 * 如果node1为null 那就返回false
 * 如果有一个结点不等 就返回false
 * 否则继续向左向右递归查找
 * */
public class HasSubtree {
    public boolean hasSubtree(TreeNode root1,TreeNode root2) {
        boolean result = false;
        if(root1 != null && root2 != null) {
            if(root1.val == root2.val) {
                result = DoesTree1HaveTree2(root1, root2);
            }
            
            if(!result) {
                result = hasSubtree(root1.left, root2);
            }
            
            if(!result) {
                result = hasSubtree(root1.right, root2);
            }
        }
        
        return result;
    }
    
    public static boolean DoesTree1HaveTree2(TreeNode node1, TreeNode node2) {
        if(node2 == null) {
            return true;
        }
        
        if(node1 == null) {
            return false;
        }
        
        if(node1.val != node2.val) {
            return false;
        }
        
        return DoesTree1HaveTree2(node1.left, node2.left) && DoesTree1HaveTree2(node1.right, node2.right);
    }
}
