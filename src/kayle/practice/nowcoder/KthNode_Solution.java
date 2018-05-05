package kayle.practice.nowcoder;

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
* 给定一颗二叉搜索树，请找出其中的第k大的结点。
* 例如， 5 / \ 3 7 /\ /\ 2 4 6 8 中，按结点数值大小顺序第三个结点的值为4。
*
* 解题思路:
* 题目描述有误，应该是找从小到大排序的第k个结点
* 二叉搜索树的中序是有序数列，所以找第k个，只要找到中序遍历的第k个结点就行
* */
public class KthNode_Solution {
    //定义一个索引，来记录是中序的第几个结点
    int index = 0;
    TreeNode KthNode(TreeNode pRoot, int k) {

        if(pRoot != null) {
            TreeNode tmpNode = KthNode(pRoot.left, k);
            //如果结点非空，就返回此结点，否则index++，并且对比index是否为k
            if(tmpNode != null) {
                return tmpNode;
            }
            index++;
            if(index == k) {
                return pRoot;
            }
            //不为k，再向右遍历
            tmpNode = KthNode(pRoot.right, k);
            if(tmpNode != null) {
                return tmpNode;
            }
        }
        return null;
    }
}