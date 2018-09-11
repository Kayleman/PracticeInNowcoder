package algorithm.nowcoder_algorithm;
/**
 * 题目：
 * 有一个有序数组arr，其中不含有重复元素，请找到满足arr[i]==i条件的最左的位置。如果所有位置上的数都不满足条件，返回-1。
 * 给定有序数组arr及它的大小n，请返回所求值。
 *
 * 测试样例：
 * [-1,0,2,3],4
 * 返回：2
 *
 * 解题思路：
 * 首先判断左右两端位置的大小
 * 再根据arr[mid]与mid的大小来划分区间，因为当大于的时候，右侧区间不可能存在相等的数
 * */
public class test6_6 {
    public int findPos(int[] arr, int n) {
        // write code here
        if (arr == null || n == 0) {
            return -1;
        }
        int left = 0;
        int right = n - 1;
        int res = -1;
        int mid = 0;
        while (left <= right) {
            if(arr[left] > left || arr[right] < right) {
                break;
            }
            mid = left + (right - left) / 2;
            if(arr[mid] > mid) {
                right = mid - 1;
            } else if(arr[mid] < mid) {
                left = mid + 1;
            } else {
                res = mid;
                right = mid -1;
            }
        }
        return res;
    }
}
