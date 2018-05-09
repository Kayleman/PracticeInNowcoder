package sword_refers_to_offer;
/*
* 题目描述:
* 将一个字符串转换成一个整数，要求不能使用字符串转换整数的库函数。
* 数值为0或者字符串不是一个合法的数值则返回0
* 输入描述:
* 输入一个字符串,包括数字字母符号,可以为空
* 输出描述:
* 如果是合法的数值表达则返回该数字，否则返回0
* 示例1
*
* 输入
* +2147483647
* 1a33
*
* 输出
* 2147483647
* 0
*
* 解题思路：
* 先转化成字符数组类型，然后再遍历这个数组，
* 判断第一个字符是否为 + -号，是的话设置flag，或者直接设置一个整数1，-1最后与结果相乘
* 除了第一个符号可以为0-9以外的，其他位置出现了直接返回0
* 都是数字的话就不断将num乘以10并且加上当前位置的数字，得到新的num。
* */
public class Str2Int {
    public int StrToInt(String str) {
        char[] charArray = str.toCharArray();
        boolean flag = true;
        int num = 0;
        for (int i = 0; i < charArray.length; i++) {
            if(charArray[0] == '-' && i == 0) {
                flag = false;
            } else if(charArray[0] == '+' && i == 0) {
                flag = true;
            } else if (charArray[i] < '0' || charArray[i] > '9') {
                return 0;
            } else {
                num = 10 * num + (charArray[i] - '0');
            }
        }
        return flag ? num: -num;
    }

    public static void main(String[] args) {
        Str2Int s2i = new Str2Int();
        System.out.println(s2i.StrToInt("-12545"));
    }
}
