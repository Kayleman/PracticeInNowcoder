package algorithm.nowcoder_algorithm;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class test7_5 {
    public int[][] printTree(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<>();
        ArrayList<ArrayList<Integer>> list = new ArrayList<>();
        ArrayList<Integer> tempList = new ArrayList<>();
        TreeNode last = root;
        TreeNode nlast = null;
        queue.offer(root);
        while (!queue.isEmpty()) {
            TreeNode tempNode = queue.poll();
            tempList.add(tempNode.val);
            if(tempNode.left != null) {
                queue.offer(tempNode.left);
                nlast = tempNode.left;
            }
            if(tempNode.right != null) {
                queue.offer(tempNode.right);
                nlast = tempNode.right;
            }
            if(tempNode == last) {
                last = nlast;
                list.add(tempList);
                tempList = new ArrayList<>();
            }
        }
        int[][] ans = new int[list.size()][];
        for (int i = 0; i < list.size(); i++) {
            ans[i] = new int[list.get(i).size()];
            for (int j = 0; j < ans[i].length; j++) {
                ans[i][j] = list.get(i).get(j);
            }

        }
        return ans;
    }
}
