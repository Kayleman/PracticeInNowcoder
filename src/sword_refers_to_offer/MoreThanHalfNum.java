package sword_refers_to_offer;

import java.util.HashMap;
/*
 * 题目描述:
 * 数组中有一个数字出现的次数超过数组长度的一半，请找出这个数字。
 * 例如输入一个长度为9的数组{1,2,3,2,2,2,5,4,2}。
 * 由于数字2在数组中出现了5次，超过数组长度的一半，因此输出2。
 * 如果不存在则输出0。
 * 
 * 解题思路:
 * 1.可以使用守擂的方法,把第一个数作为擂主,count = 1
 *   不断与下一个数对比,如果相同count++,否则count--
 *   当count=0的时候换下一个数守擂,留到最后的数要么是大于一半的数
 *   要么是另一个侥幸留下的数,再加一个循环来判断这个数的个数是不是大于一半
 *   即可得到结果
 * 2.使用HashMap来记录关键字和对应出现的次数
 *   每次都判断一下,如果符合要求 就直接返回 否则继续循环
 * */
public class MoreThanHalfNum {
    public int MoreThanHalfNum_Solution(int [] array) {
    	int len = array.length;
        if(len == 0) {
        	return 0;
        }
        
        HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
        for (int i = 0; i < len; i++) {
			if(!map.containsKey(array[i])) {
				map.put(array[i], 1);
			} else {
				map.put(array[i], map.get(array[i]) + 1);
			}
			
			if(map.get(array[i]) > len / 2) {
				return array[i];
			}
		}
        return 0;
    }
}
