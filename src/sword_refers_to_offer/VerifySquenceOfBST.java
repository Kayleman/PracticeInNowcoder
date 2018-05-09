package sword_refers_to_offer;
/*
 * 题目描述:
 * 输入一个整数数组，判断该数组是不是某二叉搜索树的后序遍历的结果。
 * 如果是则输出true,否则输出false。
 * 假设输入的数组的任意两个数字都互不相同。
 * 解题思路:
 * 因为是二叉搜索树,所以所有左子树小于根节点,右子树大于根节点
 * 而后序遍历的最右一个节点是树的根,根据这两个特性,可以将根找出
 * 然后从前往后遍历,找到一个不小于根的数就停止,记录下标 继续遍历后面的
 * 后面的序列只要有一个小于根,就返回false
 * 之后就是左右序列递归.
 * */

public class VerifySquenceOfBST {
    public boolean verifySquenceOfBST(int [] sequence) {
    	//思路:左边的序列小于root 右边的大于root
        int len = sequence.length;
        if(len == 0) {
        	return false;
        }
        
        if(len == 1) {
        	return true;
        }
        
        return isBST(sequence, 0, len - 1);
    }
    
    public boolean isBST(int [] array, int start, int end) {
    	if(start >= end) {
    		return true;
    	}
    	int i = start;
    	int root = array[end];
    	while(array[i] < root) {
    		++i; 
    	}
    	
    	for(int j = i; j < end; j++) {
    		if(array[j] < root) {
    			return false;
    		}
    	}
    	
    	return isBST(array, start, i - 1) && isBST(array, i, end - 1);
    }
    
    public static void main(String [] args) {
    	int [] array = {5, 4, 3, 2, 1};
    	VerifySquenceOfBST v = new VerifySquenceOfBST();
    	System.out.println(v.verifySquenceOfBST(array));
    }
}

