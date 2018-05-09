package sword_refers_to_offer;


/*
 * 题目描述:
 * 一只青蛙一次可以跳上1级台阶，也可以跳上2级……它也可以跳上n级。
 * 求该青蛙跳上一个n级的台阶总共有多少种跳法。
 * 
 * 解题思路:
 * 这题有两种思路
 * 1.跳每一个台阶都有2种选择，跳或者不跳，除了最后一个台阶是必须跳的
 *   总共有2^(n-1)个方法
 *   这种方法可以用位运算来计算，减少开销
 * 2.可以用递推公式来算，类似于普通的跳台阶 
 *   f(n) = f(n-1) + f(n-2) + ... + f(1) + f(0)
 *   f(n-1)=         f(n-2) + ... + f(1) + f(0)
 *   两式相减 f(n) - f(n-1) = f(n-1)
 * 	  得到最后公式 f(n) =  2 * f(n-1)
 *   利用递归就能算出f(n)的值
 * */
public class JumpFloor2 {
    public int JumpFloorII(int target) {
        if(target == 0) {
			return 1;
		}else {
			return 1 << (target - 1);
		}
    }
}


