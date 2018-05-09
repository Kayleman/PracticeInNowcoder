package sword_refers_to_offer;

/*
 * 题目描述:在数组中的两个数字，如果前面一个数字大于后面的数字，
 * 则这两个数字组成一个逆序对。输入一个数组,求出这个数组中的逆序对的总数P。
 * 并将P对1000000007取模的结果输出。 即输出P%1000000007
 * 
 * 解题思路:
 * 利用归并排序的思想来做,递归按从小到大排好序,
 * 每次都把左右两个数列的最后一个数字拿来比较,
 * 左边的数列的最后一个数如果大于右边数列的最后一个数,
 * 由于数列都是有序的,那么右边所有剩余的数列必定都小于左边数列
 * 所以逆序count要加上右边剩余数列的个数,而剩余数列个数为right -(mid + 1) + 1 也就是right -mid
 * 然后把这个大的数存到temp数组里,不断从temp数组的最后面往前存,因为temp最后要复制到array数组
 * 使array数组有序,防止重复计算逆序个数
 * 当某一边的数列遍历完毕,将剩下的另一边数列都加入到temp数组
 * 注意:每次加count大于1000000007都对1000000007是为了防止数字过大溢出
 * */
public class InversePairs {
    public static int inversePairs(int [] array) {
    	if(array.length == 0 || array == null) return 0;
    	int [] temp = new int[array.length];
    	int count = merge(array, temp, 0, array.length - 1);
        return count;
    }
    
    private static int merge(int [] array, int [] temp, int left, int right) {
    	if(left >= right) return 0;
    	
    	int mid = (left + right) >> 1;
    	int leftCount = merge(array, temp, left, mid);
    	int rightCount = merge(array, temp, mid + 1, right);
    	int tempIndex = right;
    	int leftLast = mid;
    	int rightLast = right;
    	int count = 0;
    	while(left <= leftLast && mid < rightLast) {
    		if(array[leftLast] > array[rightLast]) {
    			count += (rightLast - mid); 
    			temp[tempIndex--] = array[leftLast--];
    			if(count >= 1000000007) {
    				count %= 1000000007;
    			}
    		} else {
    			temp[tempIndex--] = array[rightLast--];
    		}
    	}
    	
    	while(left <= leftLast) {
    		temp[tempIndex--] = array[leftLast--];
    	}
    	
    	while(mid < rightLast) {
    		temp[tempIndex--] = array[rightLast--];
    	}
    	
    	for (int i = left; i <= right; i++) {
			array[i] = temp[i];
		}
    	
    	return (leftCount + rightCount + count) % 1000000007;
    }
    
    public static void main(String[] args) {
    	int [] array = {1,2,3,4,5,6,7,0};
		System.out.println(inversePairs(array));
	}
}


