package sword_refers_to_offer;

/*
 * 题目描述:
 * 大家都知道斐波那契数列，现在要求输入一个整数n，请你输出斐波那契数列的第n项。
 * n<=39
 * 
 * 解题思路:
 * 就是简单地输出Fibonacci数，递归就能得到。
 * */

public class GetFibonacci {

	public int Fibonacci(int n) {
		return getFibonacci(n);
	}

	public static int getFibonacci(int n) {
		if (n == 0) {
			return 0;
		} else if (n == 1 || n == 2) {
			return 1;
		} else {
			return getFibonacci(n - 1) + getFibonacci(n - 2);
		}
	}
}
