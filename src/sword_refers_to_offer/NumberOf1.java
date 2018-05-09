package sword_refers_to_offer;

/*
 * 题目描述:
 * 输入一个整数，输出该数二进制表示中1的个数。
 * 其中负数用补码表示。
 * 解题思路:
 * 1.使用位运算来进行计算，n和1相与，如果==1说明n的二进制表示的最后一位是1
 * count++ n向右移动一位，直接使用>>不行，因为如果是负数的话，第一位是由1表示的 会死循环
 * 需要使用>>>无视符号位进行右移
 * 2.还有一种比较巧妙的是可以让n和(n-1)相与，因为和n-1每相与一次 都会把最右边的一个1变成0
 * 总共有多少个1就循环几次。
 * public static int NumberOf1(int n) {
        int count = 0;
        while (n != 0) {
            ++count;
            n = (n - 1) & n;
        }
        return count;
    }
 * 3.java自带的函数
	public class Solution {
	public int  NumberOf1(int n) {
	         return Integer.bitCount(n);
	     }
	}
	
 * 4.转换成String,然后把0都去掉 直接计算长度
	public class Solution {
	    public int NumberOf1(int n) {
	        return Integer.toBinaryString(n).replaceAll("0","").length(); }
	}
 * */
public class NumberOf1 {
    public int numberOf1(int n) {
		int count = 0;
        while(n != 0) {
            if((n & 1) == 1) {
                count++;
            }
            n = n >>> 1; // >>>是无视符号位的右移,不然是负数的话右移补1 会死循环
        }
        return count;
    }
}

