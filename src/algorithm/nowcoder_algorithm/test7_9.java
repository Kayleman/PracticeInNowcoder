package algorithm.nowcoder_algorithm;

import java.util.LinkedList;
import java.util.Queue;

public class test7_9 {
    public boolean chk(TreeNode root) {
        TreeNode last = root;
        TreeNode nlast = null;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        boolean flag = false;//设置flag来记录是否已经有过存在左子树而没有右子树的情况
        while (!queue.isEmpty()) {
            TreeNode tempNode = queue.poll();
            //如果已经出现这种情况，队列里面的结点必须为叶子节点
            if(flag) {
                if(tempNode.left != null || tempNode.right != null) {
                    return false;
                }
            }
            //如果两个子结点都存在，就入队
            if(tempNode.left != null && tempNode.right != null) {
                queue.offer(tempNode.left);
                queue.offer(tempNode.right);
            } else if(tempNode.right != null && tempNode.left == null) {//如果右节点存在而左节点不存在，直接返回false
                return false;
            } else if (tempNode.left != null && tempNode.right == null) {//如果左节点存在而右节点不存在，则将flag设置为true，该左节点进不进队列都无所谓。
                flag = true;
            }
        }
        return true;
    }
}
