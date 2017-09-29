package kayle.practice.nowcoder;


import java.util.ArrayList;
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
 * 输入一颗二叉树和一个整数，打印出二叉树中结点值的和为输入整数的所有路径。
 * 路径定义为从树的根结点开始往下一直到叶结点所经过的结点形成一条路径
 * 
 * 解题思路:
 * 本题利用了深度遍历的思想,因为需要返回含路径的ArrayList
 * 所以要建立一个元素为ArrayList类型的allPath来存储所有正确是路径
 * singlePath用来存储单条路径
 * 题目要求遍历到叶子节点总和为target的才算,
 * 每次递归的target不断缩小,每次都减去root.val的值
 * 所以遍历到target=0且左右节点都为空的时候,是找到了一条正确的路径
 * 注意!这里需要重新new一个singlePath的引用,不然所有的路径都是指向这个引用 会出错
 * 在左右节点都遍历后,没找到符合的路径 需要回退的时候
 * 需要remove掉singlePath中的最后一个元素 
 * */
public class FindPath {
	ArrayList<ArrayList<Integer>> allPath = new ArrayList<>();
	ArrayList<Integer> singlePath = new ArrayList<>();
    public ArrayList<ArrayList<Integer>> findPath(TreeNode root,int target) {
    	if(root == null) {
    		return allPath; 
    	}
    	
    	singlePath.add(root.val);
    	target -= root.val;
    	
    	if(target == 0 && root.left == null && root.right == null) {
    		allPath.add(new ArrayList<Integer>(singlePath));
    	}
    	findPath(root.left, target);
    	findPath(root.right, target);
    	singlePath.remove(singlePath.size() - 1);
        
        return allPath;
    }
}

