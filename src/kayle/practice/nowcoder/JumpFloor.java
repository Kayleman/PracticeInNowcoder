package kayle.practice.nowcoder;

/*
 * 题目描述:
 * 一只青蛙一次可以跳上1级台阶，也可以跳上2级。
 * 求该青蛙跳上一个n级的台阶总共有多少种跳法。
 * 
 * 解题思路:
 * 这就是简单的求Fibonacci数列，
 * 设跳到n个台阶有f(n)个方法，那么他肯定是从f(n-1)或者f(n-2)跳上来的
 * 所以f(n) = f(n-1) + f(n-2)
 * 
 * 这题稍微特殊一点的是当n=0时，值为1
 * */
public class JumpFloor {
    public int jumpFloor(int target) {
        return getFibonacci(target);
    }
    
    public static int getFibonacci(int n) {
        if(n == 0 || n == 1) {
            return 1;
        }else {
            return getFibonacci(n - 1) + getFibonacci(n - 2);
        }
    }
}

