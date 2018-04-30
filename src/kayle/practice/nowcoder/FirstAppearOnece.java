package practice.nowcoder;

/*
* 题目描述:
* 请实现一个函数用来找出字符流中第一个只出现一次的字符。
* 例如，当从字符流中只读出前两个字符"go"时，第一个只出现一次的字符是"g"。
* 当从该字符流中读出前六个字符“google"时，第一个只出现一次的字符是"l"。
* 输出描述:
* 如果当前字符流没有存在出现一次的字符，返回#字符。
*
* 解题思路:
* 可以使用哈希表来记录字符出现的次数，因为ASCII码表是256个，所以开256个空间来记录字符出现的次数
* 输入完毕后转化成char数组来遍历
* 第一个出现一次的就返回，如果没有则返回#
* */
public class FirstAppearOnece {
    //Insert one char from stringstream
    int[] hashTable = new int[256];
    StringBuffer sb = new StringBuffer();
    public void Insert(char ch) {
        sb.append(ch);
        hashTable[ch]++;
    }
    //return the first appearence once char in current stringstream
    public char FirstAppearingOnce() {
        char[] str = sb.toString().toCharArray();
        for (char c : str) {
            if(hashTable[c] == 1) {
                return c;
            }
        }
        return '#';
    }
}
