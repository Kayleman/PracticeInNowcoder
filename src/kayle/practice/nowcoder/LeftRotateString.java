package kayle.practice.nowcoder;

/*
 * 题目描述:
 * 汇编语言中有一种移位指令叫做循环左移（ROL），
 * 现在有个简单的任务，就是用字符串模拟这个指令的运算结果。
 * 对于一个给定的字符序列S，请你把其循环左移K位后的序列输出。
 * 例如，字符序列S=”abcXYZdef”,要求输出循环左移3位后的结果，即“XYZdefabc”。
 * 是不是很简单？OK，搞定它！
 * 解题思路:
 * 直接把str分为头尾两部分,然后把头部移到尾部后面
 * */
public class LeftRotateString {
    public static String leftRotateString(String str,int n) {
    	if(str == null || str.length() < n) {
    		return "";
    	}
        int len = str.length();
        String head = str.substring(0, n);
        String tail = str.substring(n, len);
        return tail + head;
    }
    
    public static void main(String[] args) {
		String str = "kayleZhuang";
		int n = 5;
		System.out.println(leftRotateString(str, n));
	}
}

