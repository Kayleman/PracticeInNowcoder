package kayle.practice.nowcoder;


/*
 * 题目描述:
 * 把一个数组最开始的若干个元素搬到数组的末尾，我们称之为数组的旋转。 
 * 输入一个非递减排序的数组的一个旋转，输出旋转数组的最小元素。 
 * 例如数组{3,4,5,1,2}为{1,2,3,4,5}的一个旋转，该数组的最小值为1。 
 * NOTE：给出的所有元素都大于0，若数组大小为0，请返回0。
 * 
 * 解题思路:
 * 直接遍历，两两比较，遇到前一个数大于后一个数的时候，后面这个数就是要找的最小值。
 * 
 * 别人的思路是可以用类似二分查找的方法，因为左右两个数分别属于两个小的非递减序列
 * 取中间一个数跟左右两边的数进行比较，就可以知道中间这个数属于哪个序列，从而不断缩小范围。
 * */
public class MinNumberInRotateArray {
	public int minNumberInRotateArray(int[] array) {

		if (array.length == 0) {
			return 0;
		}

		for (int i = 0; i < array.length; i++) {
			if (array[i] > array[i + 1]) {
				return array[i + 1];
			}
		}
		return -1;
	}
}
