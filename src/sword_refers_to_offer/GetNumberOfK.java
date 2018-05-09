package sword_refers_to_offer;

/*
 * 题目描述:
 * 统计一个数字在排序数组中出现的次数。
 * 解题思路:
 * 看到数组有序并且要查找某个元素,直接想到的应该是用二分法
 * 二分法有递归和循环两种形式,
 * 这题由于要计算k的出现次数 所以需要找到第一个k和最后一个k
 * 以下查找第一个k的代码用的是递归的二分法
 * 查到最后一个k的代码用的是循环二分法
 * 找到这两个位置再输出差值+1就是k的总数
 * */
public class GetNumberOfK {
    public int getNumberOfK(int [] array , int k) {
       int len = array.length;
       int firstK = getFirstK(array, k, 0, len - 1);
       int lastK = getLastK(array, k, 0, len - 1);
       if(firstK != -1 && lastK != -1) {
    	   return lastK - firstK + 1;
       }
       return 0;
    }
    //递归二分法
    private int getFirstK(int [] array, int k, int start, int end) {
    	if(start > end) {
    		return -1;
    	}
    	int mid = (start + end) >> 1;
    	if(array[mid] > k) {
    		return getFirstK(array, k, start, mid - 1);
    	} else if(array[mid] < k) {
    		return getFirstK(array, k, mid + 1, end);
    	} else if(mid - 1 >= 0 && array[mid - 1] == k) {
    		//当array[mid] == k的时候,再判断左边一个是不是也等于k 如果是 继续往左边找
    		//后面的找最后一个k的方法同理
    		return getFirstK(array, k, start, mid - 1);
    	} else {
    		return mid;
    	}
    }
    //循环二分法
    private int getLastK(int [] array, int k, int start, int end) {
    	int len = array.length;
    	while(start <= end) {
    		int mid = (start + end) >> 1;
    		if(array[mid] > k) {
    			end = mid -1;
    		} else if(array[mid] < k) {
    			start = mid + 1;
    		} else if(mid + 1 < len && array[mid + 1] == k) {
    			start = mid + 1;
    		} else {
    			return mid;
    		}
    	}
    	return -1;
    }
}
