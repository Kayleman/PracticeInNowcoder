package algorithm.nowcoder_algorithm;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Stack;

/**
 * 题目：
 * 请用 非递归 方式实现二叉树的先序、中序和后序的遍历打印。
 * 给定一个二叉树的根结点root，请依次返回二叉树的先序，中序和后续遍历(二维数组的形式)
 *
 * 解题思路：
 * 先序遍历的非递归方法：
 * 1.将根节点入栈，再出栈的时候记录该结点，并且将右节点入栈，再将左节点入栈
 * 2.不断循环重复上一步
 *
 * 中序遍历的非递归方法：
 * 1.将用cur表示当前节点，初始为根节点
 * 2.如果栈不为空或者cur不为null 则不断循环将cur入栈，cur再指向cur.left
 * 3.如果cur == null，出栈元素，并记录该元素，cur指向该元素的右孩子
 *
 * 后序遍历的非递归方法：
 * 1.使用2个栈来记录，用cur记录根节点，首先cur入栈1
 * 2.然后将栈1元素出栈，入栈2，并将该元素的左右孩子按顺序入栈
 * 3.不断循环上一步，最后得到的栈2的出栈顺序即为后续遍历顺序
 * */
public class test7_3 {
    public int[][] convert(TreeNode root) {
        ArrayList<Integer> listPre = new ArrayList<>();
        ArrayList<Integer> listIn = new ArrayList<>();
        ArrayList<Integer> listPost = new ArrayList<>();
        preOrder(root, listPre);
        inOrder(root, listIn);
        postOrder(root, listPost);
        int ans[][] = new int[3][listPre.size()];
        for (int i = 0; i < listPre.size(); i++) {
            ans[0][i] = listPre.get(i);
            ans[1][i] = listIn.get(i);
            ans[2][i] = listPost.get(i);
        }
        return ans;

    }

    public void preOrder(TreeNode root, ArrayList<Integer> listPre) {
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);
        while (!stack.isEmpty()) {
            TreeNode temp = stack.pop();
            listPre.add(temp.val);
            if(temp.right != null) {
                stack.push(temp.right);
            }
            if(temp.left != null) {
                stack.push(temp.left);
            }
        }
    }

    public void inOrder(TreeNode root, ArrayList<Integer> listIn) {
        Stack<TreeNode> stack = new Stack<>();
        TreeNode cur = root;
        while (!stack.isEmpty() || cur != null) {
            if (cur == null) {
                TreeNode temp = stack.pop();
                listIn.add(temp.val);
                cur = temp.right;
            } else {
                stack.push(cur);
                cur = cur.left;
            }
        }
    }

    public void postOrder(TreeNode root, ArrayList<Integer> listPost) {
        Stack<TreeNode> stack1 = new Stack<>();
        Stack<TreeNode> stack2 = new Stack<>();
        TreeNode cur = root;
        stack1.push(cur);
        while (!stack1.isEmpty()) {
            TreeNode temp = stack1.pop();
            stack2.push(temp);
            if(temp.left != null) {
                stack1.push(temp.left);
            }
            if(temp.right != null) {
                stack1.push(temp.right);
            }
        }
        while (!stack2.isEmpty()) {
            listPost.add(stack2.pop().val);
        }
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
        test7_3 t = new test7_3();
        ArrayList<Integer> list = new ArrayList<>();
        t.postOrder(node1, list);
        System.out.println(list);
    }
}
