package algorithm.nowcoder_algorithm;
/**
 * 题目：
 * 对于一个有序循环数组arr，返回arr中的最小值。有序循环数组是指，有序数组左边任意长度的部分放到右边去，右边的部分拿到左边来。比如数组[1,2,3,3,4]，是有序循环数组，[4,1,2,3,3]也是。
 * 给定数组arr及它的大小n，请返回最小值。
 *
 * 测试样例：
 * [4,1,2,3,3],5
 * 返回：1
 *
 * 解题思路：
 * 1.当arr[left] < arr[right] 说明该区间内有序，最小为left值
 * 2.否则的话arr[left] >= arr[right]，再判断如果arr[left] < arr[mid]，说明最小值在mid和right之间
 * 3.否则的话arr[left] >= arr[right]且arr[left] >= arr[mid]，判断arr[mid] < arr[right]，说明最小值在left和mid之间
 * 4.否则的话arr[left] >= arr[right]且arr[left] >= arr[mid]且arr[mid] >= arr[right],
 *   因为不可能为逆序，所以只有arr[left] = arr[mid] = arr[right]的情况
 * 5.进行遍历查找
 * */
public class test6_4 {
    public int getMin(int[] arr, int n) {
        // write code here
        if (arr == null || n == 0) {
            return -1;
        }
        int left = 0;
        int right = n - 1;
        int mid = 0;
        int res = 0;
        while (left < right) {
            mid = left + (right - left) / 2;
            if (arr[left] < arr[right]) { //说明数组在该区间有序，返回left
                return arr[left];
            } else if (arr[left] < arr[mid]){ //说明最小值在mid和right之间
                left = mid;
            } else if (arr[mid] < arr[right]) { //说明最小值在left和mid之间
                right = mid;
            } else { //否则的话出现值相等的情况，需要进行遍历
                while (left < right) {
                    if (arr[left] == arr[mid]) { //如果值相等，不断向右遍历
                        left++;
                    } else if (arr[left] < arr[mid]) { //当left小于mid，即有序，则left为最小值
                        return arr[left];
                    } else {
                        right = mid; //否则在left和mid之间
                        break;
                    }
                }
            }
        }
        return Math.min(arr[left], arr[right]);
    }

    public static void main(String[] args) {
        test6_4 t = new test6_4();
        int[] arr = {4, 1, 2, 3, 3};
        int[] arr2 = {180,212,446,476,541,156};
        System.out.println(t.getMin(arr2, arr2.length));
    }
}
