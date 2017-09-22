package kayle.practice.nowcoder;

/*
 * 题目描述:
 * 请实现一个函数，将一个字符串中的空格替换成“%20”。
 * 例如，当字符串为We Are Happy.则经过替换之后的字符串为We%20Are%20Happy。
 * 
 * 解题思路:
 * String里面的replaceAll方法可以直接替换。
 * 先将传进来的StringBuffer类型转换成String类型
 * 然后直接使用replaceAll方法即可
 * */
public class ReplaceSpace {
	public String replaceSpace(StringBuffer str) {
    	String tempString = str.toString();
    	String newString = tempString.replaceAll(" ", "%20");
        return newString;
    }
}
