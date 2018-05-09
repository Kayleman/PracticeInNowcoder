package sword_refers_to_offer;

import java.lang.Math;

/*
 * 题目描述:
 * 给定一个double类型的浮点数base和int类型的整数exponent。
 * 求base的exponent次方。
 * 解题思路:
 * 1.直接进行循环乘积，考虑到exponent可能是负数，先求绝对值
 * 最后根据exponent是正数还是负数来进行输出。
 * 
 * 2.使用递归
 * 使用递归，时间复杂度O(logn)
	当n为偶数，a^n =（a^n/2）*（a^n/2）
	当n为奇数，a^n = a^[(n-1)/2] * a^[(n-1)/2] * a
	// 使用递归
    public static double power(double base, int exponent) {
        int n = Math.abs(exponent);
        double result = 0.0;
        if (n == 0)
            return 1.0;
        if (n == 1)
            return base;
         
        result = power(base, n >> 1);
        result *= result;
        if ((n & 1) == 1) // 如果指数n为奇数，则要再乘一次底数base
            result *= base;
        if (exponent < 0) // 如果指数为负数，则应该求result的倒数
            result = 1 / result;
         
        return result;
    }
 * */
public class Power {
    public double power(double base, int exponent) {
        double res = 1.0;
        
        
        for(int i = 0; i < Math.abs(exponent); i++) {
            res = res * base;
        }
        
        if(exponent > 0) {
            return res;
        }
        
        if(exponent < 0) {
            return 1/res;
        }
        
        return 1.0;
    }
}