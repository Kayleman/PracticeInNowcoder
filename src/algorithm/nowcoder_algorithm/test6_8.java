package algorithm.nowcoder_algorithm;
/**
 * 题目：
 * 如果更快的求一个整数k的n次方。如果两个整数相乘并得到结果的时间复杂度为O(1)，得到整数k的N次方的过程请实现时间复杂度为O(logN)的方法。
 * 给定k和n，请返回k的n次方，为了防止溢出，请返回结果Mod 1000000007的值。
 *
 * 测试样例：
 * 2,3
 * 返回：8
 *
 * 解题思路：
 * 直接相乘的话复杂度较高
 * 可以将指数转换成二进制，二进制的哪个位置上为1，就乘上相应的次方
 * 注意temp和res要为long，否则会直接溢出
 * */
public class test6_8 {
    public int getPower(int k, int N) {
        // write code here
        int MOD = 1000000007;
        long temp = k;
        long res = 1;
        if (N == 0) {
            return 1;
        }
        while (N != 0) {
            if((N & 1) != 0) {
                res = res * temp % MOD;
            }
            temp = temp * temp % MOD;
            N = N >> 1;
        }
        return (int)res;
    }

    public static void main(String[] args) {
        test6_8 t = new test6_8();
        System.out.println(t.getPower(2,14876069));
    }
}
