package kayle.practice.nowcoder;

import java.util.ArrayList;
import java.util.Arrays;
/*
 * 题目描述:
 * 输入n个整数，找出其中最小的K个数。
 * 例如输入4,5,1,6,2,7,3,8这8个数字，则最小的4个数字是1,2,3,4,。
 * 
 * 解题思路:
 * 因为只需要求前k个,所以直接用冒泡排序排k次就行
 * 自己做的方法为了偷懒直接调用了sort函数了
 * */
public class GetLeastNumbers {
	public static ArrayList<Integer> GetLeastNumbers_Solution(int[] input, int k) {
		ArrayList<Integer> arrayList = new ArrayList<>();
		if(input.length < k) {
            return arrayList;
        }
		Arrays.sort(input);
		//int[] res = Arrays.copyOfRange(input, 0, k);
		for (int i = 0; i < k; i++) {
			arrayList.add(input[i]);
		}

		return arrayList;
	}

	public static void main(String[] args) {
		int [] input = {4,5,1,6,2,7,3,8};
		int k = 4;
		ArrayList<Integer> list = GetLeastNumbers_Solution(input, k);
		
		for(int i = 0; i < list.size(); i++) {
			System.out.print(list.get(i) + " ");
		}
	}
}
