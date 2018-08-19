package algorithm.nowcoder_algorithm;
import java.util.*;
/**
 * 对二叉树进行层次遍历打印
 * */

/*
public class TreeNode {
    int val = 0;
    TreeNode left = null;
    TreeNode right = null;
    public TreeNode(int val) {
        this.val = val;
    }
}*/

public class test1_2 {
    public static int[][] printTree(TreeNode root) {
        // write code here
        ArrayList<ArrayList<Integer>> list = new ArrayList<>();
        ArrayList<Integer> tempList = new ArrayList<>();
        TreeNode last = root;
        TreeNode nlast = null;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            TreeNode temp = queue.poll();
            tempList.add(temp.val);
            if(temp.left != null) {
                queue.offer(temp.left);
                nlast = temp.left;
            }
            if(temp.right != null) {
                queue.offer(temp.right);
                nlast = temp.right;
            }
            if(last == temp) {
                System.out.println(temp.val);
                last = nlast;
                list.add(tempList);
                tempList = new ArrayList<>();
            } else {
                System.out.print(temp.val + " ");
            }
        }

        int[][] ans = new int[list.size()][];
        for (int k = 0; k < list.size(); k++) {
            ans[k] = new int[list.get(k).size()];
            for (int l = 0; l < ans[k].length; l++) {
                ans[k][l] = list.get(k).get(l);
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        TreeNode node2 = new TreeNode(2);
        TreeNode node3 = new TreeNode(3);
        TreeNode node4 = new TreeNode(4);
        TreeNode node5 = new TreeNode(5);
        TreeNode node6 = new TreeNode(6);
        TreeNode node7 = new TreeNode(7);
        TreeNode node8 = new TreeNode(8);
        root.left = node2;
        root.right = node3;
        node2.left = node4;
        node3.left = node5;
        node3.right = node6;
        node5.left = node7;
        node5.right = node8;
        int[][] array =  printTree(root);
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array.length; j++) {
                System.out.print(array[i][j] + " ");
            }
            System.out.println();
        }
    }
}



