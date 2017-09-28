package kayle.practice.nowcoder;

/*
 * 题目描述:
 * 输入一个整数数组，实现一个函数来调整该数组中数字的顺序，使得所有的奇数位于数组的前半部分，
 * 所有的偶数位于位于数组的后半部分，并保证奇数和奇数，偶数和偶数之间的相对位置不变。
 * 解题思路:
 * 用空间换时间的方法，不使用类似冒泡的方法进行调整
 * 直接重新创建一个等长的数组，先把奇数都村进来，再把偶数存进来
 * 最后再直接都赋值给原数组
 * */
public class ReOrderArray {
    public void reOrderArray(int [] array) {
        int [] temp = new int[array.length];
        int count = 0;
        
        for(int i = 0; i < array.length; i++) {
            if(array[i] % 2 == 1) {
            	temp[count++] = array[i];
            }
        }
        
        for(int i = 0; i < array.length; i++) {
            if(array[i] % 2 == 0) {
            	temp[count++] = array[i];
            }
        }        

        for(int i = 0; i < array.length; i++) {
        	array[i] = temp[i];
        }
    }
}

