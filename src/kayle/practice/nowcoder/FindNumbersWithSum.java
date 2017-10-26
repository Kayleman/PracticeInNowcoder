package kayle.practice.nowcoder;

import java.util.ArrayList;

/*
 * 题目描述:
 * 输入一个递增排序的数组和一个数字S，在数组中查找两个数，
 * 是的他们的和正好是S，如果有多对数字的和等于S，输出两个数的乘积最小的。
 * 解题思路:
 * 既然是有序的,可以直接定义两个指针,small和big分别从头尾进行夹逼
 * 当大于sum的时候,big要向左移一位,减小总和
 * 当小于sum的时候,small要向右移一位,增加总和
 * 第一组满足要求的数对就是所有满足要求的数对之中的乘积最小的.
 * 所以当第一次满足的时候,就可以直接加入list然后break,返回结果
 * 
 * 注:有序数组中两个数距离越远乘积越大的证明方法:
 * 分别设两个数为x,y.不妨设x<=y, x+y=c, y-x=d>=0,两式相加得 2y=c+d --> y=(c+d)/2
 * 带入x+y=c中得x=(c-d)/2,所以 x*y=(c^2-d^2)/4,c是常数,所以这是一个关于d的一元二次方程,
 * 开口向下,y为对称轴.所以当d越大,x*y越小.得证.
 * */
public class FindNumbersWithSum {
    public ArrayList<Integer> findNumbersWithSum(int [] array,int sum) {
        ArrayList<Integer> list = new ArrayList<>();
        if(array.length == 0) {
        	return list;
        }
        int small = 0;
        int big = array.length - 1;
        while(small < big) {
        	if(array[small] + array[big] > sum) {
        		big--;
        	} else if(array[small] + array[big] < sum) {
        		small++;
        	} else {
        		list.add(array[small]);
        		list.add(array[big]);
        		break;
        	}
        }
        return list;
    }
}

