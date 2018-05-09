package sword_refers_to_offer;

/**
 * Definition for binary tree
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
import java.util.Arrays;

/*
 * 题目描述:
 * 输入某二叉树的前序遍历和中序遍历的结果，请重建出该二叉树。
 * 假设输入的前序遍历和中序遍历的结果中都不含重复的数字。
 * 例如输入前序遍历序列{1,2,4,7,3,5,6,8}
 * 中序遍历序列{4,7,2,1,5,3,8,6}，则重建二叉树并返回。
 * 
 * 解题思路:
 * 因为前序遍历的第一个节点是根节点，所以先创建根节点
 * 然后再中序遍历数组中查找根节点的位置。
 * 找到根节点的位置后使用Arrays的copyOfRange方法将数组划分开，剔除根节点
 * 根节点左边的递归赋值给root.left
 * 根节点右边的递归赋值给root.right
 * */
public class ReConstructBinaryTree {
	public TreeNode reConstructBinaryTree(int[] pre, int[] in) {
		if (pre.length == 0 || in.length == 0) {
			return null;
		}

		TreeNode root = new TreeNode(pre[0]);

		for (int i = 0; i < in.length; i++) {
			if (pre[0] == in[i]) {
				root.left = reConstructBinaryTree(Arrays.copyOfRange(pre, 1, i + 1), Arrays.copyOfRange(in, 0, i));
				root.right = reConstructBinaryTree(Arrays.copyOfRange(pre, i + 1, pre.length),
						Arrays.copyOfRange(in, i + 1, in.length));
				break;
			}
		}
		return root;
	}
}
