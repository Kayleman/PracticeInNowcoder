package sword_refers_to_offer;

import java.util.ArrayList;

/*
 * 题目描述:
 * 小明很喜欢数学,有一天他在做数学作业时,要求计算出9~16的和,他马上就写出了正确答案是100。
 * 但是他并不满足于此,他在想究竟有多少种连续的正数序列的和为100(至少包括两个数)。
 * 没多久,他就得到另一组连续正数和为100的序列:18,19,20,21,22。
 * 现在把问题交给你,你能不能也很快的找出所有和为S的连续正数序列? Good Luck!
 * 解题思路:
 * 设置两个指针,一个small指向1,一个big指向2,分别表示数列的首项和尾项
 * 当当前总和curSum大于目标和sum的时候,将small向后移,并且减去small的值
 * 当当前总和小于目标和的时候,将big向后移,并加上big的值
 * 在相等的时候,把从small到big的数字都存到list里,再把list添加到res
 * 同时把small和big都向后移,并且curSum减去small再加上新的big值也就是big+1
 * 
 * */
public class FindContinuousSequence {
    public static ArrayList<ArrayList<Integer>> findContinuousSequence(int sum) {
       ArrayList<ArrayList<Integer>> res = new ArrayList<ArrayList<Integer>>();
       if(sum < 3) return res;
       int small = 1;
       int big = 2;
       int curSum = 3;
       while(small < (sum + 1) / 2) {
    	   if(curSum > sum) {
    		   curSum -= small;
			   small++;
    	   } else if(curSum < sum) {
    		   big++;
    		   curSum += big;
    	   } else if(curSum == sum){
    		   ArrayList<Integer> list = new ArrayList<>();
    		   for(int i = small; i <= big; i++) {
    			   list.add(i);
    		   }
    		   res.add(list);
    		   curSum = curSum -small + big + 1;
    		   small++;
    		   big++;
    	   }
       }
       return res;
    }
    
    public static void main(String[] args) {
		ArrayList<ArrayList<Integer>> list = findContinuousSequence(100);
		for(int i = 0; i < list.size(); i++) {
			System.out.println(list.get(i));
		}
	}
}

