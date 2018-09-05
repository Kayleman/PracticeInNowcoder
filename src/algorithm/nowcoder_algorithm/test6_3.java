package algorithm.nowcoder_algorithm;
/**
 * 题目：
 * 对于一个有序数组arr，再给定一个整数num，请在arr中找到num这个数出现的最左边的位置。
 * 给定一个数组arr及它的大小n，同时给定num。请返回所求位置。若该元素在数组中未出现，请返回-1。
 *
 * 测试样例：
 * [1,2,3,3,4],5,3
 * 返回：2
 *
 * 解题思路：
 * 每次都记录找到的值的下标，并且继续往左边找，如果找到新的值就更新。
 * */
public class test6_3 {
    public int findPos(int[] arr, int n, int num) {
        // write code here
        if(arr == null || n == 0) {
            return -1;
        }
        int left = 0;
        int right = n - 1;
        int mid = 0;
        int res = -1;
        while (left <= right) {
            mid = left + (right - left) / 2;
            if(arr[mid] < num) {
                left = mid + 1;
            } else if(arr[mid] > num) {
                right = mid - 1;
            } else {
                res = mid;
                right = mid - 1;
            }
        }
        return res;
    }

    public static void main(String[] args) {
        int[] arr = {36,62,146,208,210,369,616};
        test6_3 t = new test6_3();
        System.out.println(t.findPos(arr, 7, 616));
    }
}
