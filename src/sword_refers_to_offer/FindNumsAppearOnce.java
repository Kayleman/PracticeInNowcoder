package sword_refers_to_offer;

import java.util.ArrayList;
import java.util.Arrays;

//num1,num2分别为长度为1的数组。传出参数
//将num1[0],num2[0]设置为返回结果
/*
 * 题目描述:
 * 一个整型数组里除了两个数字之外，其他的数字都出现了两次。请写程序找出这两个只出现一次的数字。
 * 解题思路:
 * 1.我自己写的最直观的就是先讲数组进行排序
 *   然后循环一次,将前后两个数进行对比,在index没有超过数组界限的时候
 *   如果前后两个数相等,那么这不是我们要找的数,i++同时进行下一次循环,i又+1,
 *   这样一来相当于每次遇到2个相同的数就+2,也就是跳过这2个相同的数
 *   只要出现不同,那么第一个数一定是只出现一次的数,把它加入到list里,最后赋值给num1 num2
 * 2.别人的思路,利用了异或运算来计算
 *   异或运算是对这个数的二进制码进行运算,相同的为0,不同的为1
 *   0和一个数异或还是他本身,这样一来设置一个temp为0
 *   不断地与数组中的每个数进行异或,那些出现2次的数,异或两次会抵消,
 *   例如数组为2,3,4,3,2,6,5,5
 *   这个其实异或到最后的结果就是4和6异或的结果为0010,值为2
 *   这个0010表示的就是4(0100)和6(0110)中不同的位所在的位置
 *   所以只需要把这个数组中的所有数字按照第三位是不是1的标准来进行分组
 *   就可以得到第三位是1的组和第三位是0的组,我们要找的两个数必定分别属于这两个组
 *   而其他重复的元素肯定也两两都分别在这两个组中.
 *   方法2代码如下:
 *   

public class Solution {
    public void FindNumsAppearOnce(int[] array, int[] num1, int[] num2)    {
        int length = array.length;
        if(length == 2){
            num1[0] = array[0];
            num2[0] = array[1];
            return;
        }
        int bitResult = 0;
        for(int i = 0; i < length; ++i){
            bitResult ^= array[i];
        }
        int index = findFirst1(bitResult);
        for(int i = 0; i < length; ++i){
            if(isBit1(array[i], index)){
                num1[0] ^= array[i];
            }else{
                num2[0] ^= array[i];
            }
        }
    }
     
    private int findFirst1(int bitResult){
        int index = 0;
        while(((bitResult & 1) == 0) && index < 32){
            bitResult >>= 1;
            index++;
        }
        return index;
    }
     
    private boolean isBit1(int target, int index){
        return ((target >> index) & 1) == 1;
    }
}
 * */
public class FindNumsAppearOnce {
	public void findNumsAppearOnce(int[] array, int num1[], int num2[]) {
		Arrays.sort(array);
		ArrayList<Integer> list = new ArrayList<>();
		for (int i = 0; i < array.length; i++) {
			if((i + 1) < array.length && array[i] == array[i + 1]) {
				i++;
			}else {
				list.add(array[i]);
			}
		}
		num1[0] = list.get(0);
		num2[0] = list.get(1);
	}
	
}
