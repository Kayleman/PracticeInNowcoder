package sword_refers_to_offer;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

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
* 从上到下按层打印二叉树，同一层结点从左至右输出。每一层输出一行。
*
* 解题思路:
* 1.层次遍历按行输出，问题主要在于记录队列出队的个数，每一层出完就add到resList
* 用start和end来记录位置。
*
* 2.也可以用前面输入Z字型二叉树一样，用两个栈或者两个队列来遍历，分别记录奇数偶数层。
* */
public class PrintTree_Queue {
    ArrayList<ArrayList<Integer>> Print(TreeNode pRoot) {
        ArrayList<ArrayList<Integer>> resList = new ArrayList<ArrayList<Integer>>();
        if(pRoot == null) {
            return resList;
        }
        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        queue.add(pRoot);
        int start = 0;
        int end = queue.size();
        ArrayList<Integer> tmpList = new ArrayList<Integer>();
        while (!queue.isEmpty()) {
            TreeNode tmpNode = queue.poll();
            tmpList.add(tmpNode.val);
            start++;
            if(tmpNode.left != null) {
                queue.add(tmpNode.left);
            }
            if(tmpNode.right != null) {
                queue.add(tmpNode.right);
            }
            if(start == end) {
                end = queue.size();
                start = 0;
                resList.add(tmpList);
                tmpList = new ArrayList<Integer>();
            }
        }
        return resList;
    }

}
