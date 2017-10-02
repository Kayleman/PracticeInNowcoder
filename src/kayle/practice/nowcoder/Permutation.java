package kayle.practice.nowcoder;


import java.util.ArrayList;
import java.util.Collections;

/*
 * 题目描述:
 * 输入一个字符串,按字典序打印出该字符串中字符的所有排列。
 * 例如输入字符串abc,则打印出由字符a,b,c所能排列出来的所有字符串abc,acb,bac,bca,cab和cba。
 * 输入描述:
 * 输入一个字符串,长度不超过9(可能有字符重复),字符只包括大小写字母。
 * 
 * 解题思路:
 * 1.使用字典序排列算法
		【例】 如何得到346987521的下一个
     * 1，从尾部往前找第一个P(i-1) < P(i)的位置
     * 3 4 6 <- 9 <- 8 <- 7 <- 5 <- 2 <- 1
     * 最终找到6是第一个变小的数字，记录下6的位置i-1
     *
     * 2，从i位置往后找到最后一个大于6的数
     * 3 4 6 -> 9 -> 8 -> 7 5 2 1
     * 最终找到7的位置，记录位置为m
     *
     * 3，交换位置i-1和m的值
     * 3 4 7 9 8 6 5 2 1
     * 4，倒序i位置后的所有数据
     * 3 4 7 1 2 5 6 8 9
     * 则347125689为346987521的下一个排列
 * 2.使用递归的方法从头到尾先不考虑顺序,一个一个换
 *   由于可能有重复的字符,所以在添加进list之前要先使用contains方法来进行判断list里面是否已经有这个
 *   字符串,如果没有的话 就添加
 *   循环地交换index和j位置的值,继续不断向底层递归,递归结束回退的时候
 *   再使用一次swap对之前交换过的进行复位
 * */
public class Permutation {
    public ArrayList<String> permutation(String str) {
       ArrayList<String> res = new ArrayList<>();
       if(str == null || str.length() == 0) {
    	   return res;
       }
       
       permutationHelper(str.toCharArray(), 0, res);
       Collections.sort(res);
       
       return res;
    }
    
    public void permutationHelper(char[] array, int index, ArrayList<String> list) {
    	if(index == array.length - 1) {
    		String ans = String.valueOf(array);
    		if(!list.contains(ans)) {
    			list.add(ans);
    		}
    	} else {
    		for (int j = index; j < array.length; j++) {
    			swap(array, index, j);
    			permutationHelper(array, index + 1, list);
    			swap(array, index, j);
    		}
    	}
    	
    }
    
    public void swap(char[] array, int i, int j) {
    	char temp = array[i];
    	array[i] = array[j];
    	array[j] = temp;
    }
}

