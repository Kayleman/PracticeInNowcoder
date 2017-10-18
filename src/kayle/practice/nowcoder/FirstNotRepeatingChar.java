package kayle.practice.nowcoder;

/*
 * 题目描述:
 * 在一个字符串(1<=字符串长度<=10000，全部由字母组成)
 * 中找到第一个只出现一次的字符,并返回它的位置
 * 解题思路:
 * 创建一个数组可以记录各个字母出现的次数
 * 以字母为数组查找的索引,统计完次数后
 * 再对原来的字符串数组进行遍历,找到第一个出现次数为1的 返回索引
 * */
public class FirstNotRepeatingChar {
    public static int firstNotRepeatingChar(String str) {
    	if(str == null) return -1;
    	char [] array = str.toCharArray();
    	int [] count = new int['z' + 1];
    	for (int i = 0; i < array.length; i++) {
			count[(int)array[i]]++;
		}
    	
    	for (int i = 0; i < array.length; i++) {
			if(count[(int)array[i]] == 1) return i;
		}
    	
    	return -1;
    	
    }
    
    public static void main(String[] args) {
		String str = "NXWtnzyoHoBhUJaPauJaAitLWNMlkKwDYbbigdMMaYfkVPhGZcrEwp";
		System.out.println(firstNotRepeatingChar(str));
	}
}

