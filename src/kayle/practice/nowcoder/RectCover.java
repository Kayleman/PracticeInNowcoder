package kayle.practice.nowcoder;

/*
 * 题目描述:
 * 我们可以用2*1的小矩形横着或者竖着去覆盖更大的矩形。
 * 请问用n个2*1的小矩形无重叠地覆盖一个2*n的大矩形，总共有多少种方法？
 * 
 * 解题思路:
 * 这题其实也是Fibonacci数列的题
 * 当长度为n的时候有f(n)种方法，
 * 而f(n)是从 n-1 和 n-2这两种覆盖过来的
 * 所以 f(n) = f(n-1) + f(n-2)
 * */
public class RectCover {
	public int rectCover(int target) {
		if (target == 0) {
			return 0;
		}

		if (target == 1) {
			return 1;
		}

		if (target == 2) {
			return 2;
		}

		return rectCover(target - 1) + rectCover(target - 2);
	}
}
