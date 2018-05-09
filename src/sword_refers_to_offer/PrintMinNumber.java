package sword_refers_to_offer;

import java.util.Arrays;
import java.util.Comparator;
/*
 * 题目描述:
 * 输入一个正整数数组，把数组里所有数字拼接起来排成一个数，打印能拼接出的所有数字中最小的一个。
 * 例如输入数组{3，32，321}，则打印出这三个数字能排成的最小数字为321323。
 * 
 * 解题思路:
 * 先把int转换成String类型
 * 然后通过Arrays的sort函数来进行排序
 * 排序的规则需要自己重写,a和b都是字符串.
 * 若ab > ba 则 a > b，
 * 若ab < ba 则 a < b，
 * 若ab = ba 则 a = b；
 * 解释说明：
 * 比如 "3" < "31"但是 "331" > "313"，所以要将二者拼接起来进行比较
 * */
public class PrintMinNumber {
    public String printMinNumber(int [] numbers) {
    	
    	int len = numbers.length;
    	
    	if(numbers == null || len == 0) {
    		return "";
    	}
    	
    	String [] str = new String [len];
    	StringBuilder sb = new StringBuilder();
    	
    	for (int i = 0; i < len; i++) {
			str[i] = String.valueOf(numbers[i]);
		}
    	
    	Arrays.sort(str, new Comparator<String>() {
    		@Override
    		public int compare(String str1, String str2) {
    			String s1 = str1 + str2;
    			String s2 = str2 + str1;
    			return s1.compareTo(s2);
    		}
		});
    	
    	for(int i = 0; i < len; i++){
    		sb.append(str[i]);
    	}
    	
    	return sb.toString();
    }
}

