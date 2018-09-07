package algorithm.nowcoder_algorithm;

import java.util.ArrayList;

/**
 * 题目：
 * 请用 递归 方式实现二叉树的先序、中序和后序的遍历打印。
 * 给定一个二叉树的根结点root，请依次返回二叉树的先序，中序和后续遍历(二维数组的形式)
 * */
public class test7_2 {
    public int[][] convert(TreeNode root) {
        ArrayList<Integer> listPre = new ArrayList<>();
        ArrayList<Integer> listIn = new ArrayList<>();
        ArrayList<Integer> listPost = new ArrayList<>();
        preOrder(root, listPre);
        inOrder(root, listIn);
        postOrder(root, listPost);
        int[][] ans = new int[3][listPre.size()];
        for (int i = 0; i < listPre.size(); i++) {
            ans[0][i] = listPre.get(i);
            ans[1][i] = listIn.get(i);
            ans[2][i] = listPost.get(i);
        }
        return ans;
    }

    public void preOrder(TreeNode root, ArrayList<Integer> listPre) {
        TreeNode head = root;
        if(head == null) {
            return;
        }
        listPre.add(head.val);
        preOrder(head.left, listPre);
        preOrder(head.right, listPre);
    }

    public void inOrder(TreeNode root, ArrayList<Integer> listIn) {
        TreeNode head = root;
        if(head == null) {
            return;
        }
        inOrder(head.left, listIn);
        listIn.add(head.val);
        inOrder(head.right, listIn);
    }

    public void postOrder(TreeNode root, ArrayList<Integer> listPost) {
        TreeNode head = root;
        if(head == null) {
            return;
        }
        postOrder(head.left, listPost);
        postOrder(head.right, listPost);
        listPost.add(head.val);
    }

    public static void main(String[] args) {
        TreeNode node1 = new TreeNode(3);
        TreeNode node2 = new TreeNode(1);
        TreeNode node3 = new TreeNode(5);
        TreeNode node4 = new TreeNode(1);
        TreeNode node5 = new TreeNode(3);
        TreeNode node6 = new TreeNode(8);
        node1.left = node2;
        node1.right = node3;
        node2.left = node4;
        node2.right = node5;
        node3.left = node6;
        test7_2 t = new test7_2();
        t.convert(node1);
    }
}
