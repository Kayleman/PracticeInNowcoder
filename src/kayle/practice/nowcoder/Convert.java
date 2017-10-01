package kayle.practice.nowcoder;


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
 * 输入一棵二叉搜索树，将该二叉搜索树转换成一个排序的双向链表。
 * 要求不能创建任何新的结点，只能调整树中结点指针的指向。
 * 解题思路:
 * 因为二叉搜索树的中序遍历是一个增序的序列,所以可以直接使用中序的思想来解决
 * 因为不允许新建节点,所以直接把left指向前驱,right指向后继,通过修改指针指向来调整成双向链表
 * 1.新建pre节点来保存前驱节点,head来记录新链表的头结点
 * 2.设立递归边界,根节点为null,结束递归.
 * 3.先向左不断递归找最左的节点,因为最左节点的前驱应该指向null,
 *   初始化的pre就是null,巧妙地直接不用判断就可以直接改变指针指向pre
 * 4.然后再进行判断,当pre不是null的时候,说明pre需要指向后继了
 *   这时候把pre的后继指向当前的根节点.形成双向链表
 * 5.判断head是否是初始化的null,如果是就把head保存当前根节点
 *   这个if就执行一次,用来保存新链表的头结点
 * 6.然后指针pre指向当前根节点,相当于向后移动一位,始终记录根节点的前驱位置
 * 7.最后进行右子树的递归
 * 8.最终返回head
 * */
public class Convert {
	//1.新建pre节点来保存前驱节点,head来记录新链表的头结点
	TreeNode pre = null;
	TreeNode head = null;
    public TreeNode convert(TreeNode pRootOfTree) {
    	//2.设立递归边界,根节点为null,结束递归.
        if(pRootOfTree == null) {
        	return null;
        }
        //3.先向左不断递归找最左的节点,因为最左节点的前驱应该指向null,
        //初始化的pre就是null,巧妙地直接不用判断就可以直接改变指针指向pre
        convert(pRootOfTree.left);
        pRootOfTree.left = pre;
        //4.然后再进行判断,当pre不是null的时候,说明pre需要指向后继了
        //这时候把pre的后继指向当前的根节点.形成双向链表
        if(pre != null) {
        	pre.right = pRootOfTree;
        }
        //5.判断head是否是初始化的null,如果是就把head保存当前根节点
        //   这个if就执行一次,用来保存新链表的头结点
        if(head == null) {
        	head = pRootOfTree;
        }
        //6.然后指针pre指向当前根节点,相当于向后移动一位,始终记录根节点的前驱位置
        pre = pRootOfTree;
        //7.最后进行右子树的递归
        convert(pRootOfTree.right);
        
        return head;
    }
}

