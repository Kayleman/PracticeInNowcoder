package sword_refers_to_offer;

/*
public class TreeLinkNode {
    int val;
    TreeLinkNode left = null;
    TreeLinkNode right = null;
    TreeLinkNode next = null;

    TreeLinkNode(int val) {
        this.val = val;
    }
}
*/

/*
* 题目描述:
* 给定一个二叉树和其中的一个结点，请找出中序遍历顺序的下一个结点并且返回。
* 注意，树中的结点不仅包含左右子结点，同时包含指向父结点的指针。
*
* 解题思路:
* 主要分为三种情况：
* 1.pNode为空结点，返回空
* 2.pNode为非叶结点，只要右子树不空，则返回右孩子的最左结点，右孩子如果没有左子树，则直接返回右孩子
* 3.pNode为叶结点，如果pNode是父结点的左孩子，则返回父结点。否则一直向上查找，直到根节点，若没有，则返回null。
* */
public class GetNextSolution {
    public TreeLinkNode GetNext(TreeLinkNode pNode) {
        //1.pNode为空结点，返回空
        if(pNode == null) {
            return null;
        }

        //2.pNode为非叶结点，只要右子树不空，则返回右孩子的最左结点，右孩子如果没有左子树，则直接返回右孩子
        if(pNode.right != null) {
            pNode = pNode.right;
            while (pNode.left != null) {
                pNode = pNode.left;
            }
            return pNode;
        }
        //3.pNode为叶结点，如果pNode是父结点的左孩子，则返回父结点。否则一直向上查找，直到根节点，若没有，则返回null。
        while (pNode.next != null) {
            TreeLinkNode fatherNode = pNode.next;
            if(fatherNode.left == pNode) {
                return fatherNode;
            } else {
                pNode = pNode.next;
            }
        }
        return null;
    }
}
