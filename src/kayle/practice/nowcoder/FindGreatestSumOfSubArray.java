package kayle.practice.nowcoder;

/*
 * 题目描述:
 * HZ偶尔会拿些专业问题来忽悠那些非计算机专业的同学。
 * 今天测试组开完会后,他又发话了:在古老的一维模式识别中,
 * 常常需要计算连续子向量的最大和,当向量全为正数的时候,问题很好解决。
 * 但是,如果向量中包含负数,是否应该包含某个负数,
 * 并期望旁边的正数会弥补它呢？
 * 例如:{6,-3,-2,7,-15,1,2,2},连续子向量的最大和为8(从第0个开始,到第3个为止)。
 * 你会不会被他忽悠住？(子向量的长度至少是1)
 * 
 * 解题思路:
 * 设置两个变量 一个为当前总和sum,一个为最大总和maxSum
 * 值都设为数组的第0个元素,不设置为0是因为可能maxSum是负值
 * 从第1个开始遍历,如果sum加上下一个数之和小于0,
 * 先判断sum是不是比maxSum大,是的话就替换值,然后再把sum变为0,重新计数
 * 否则的话一直加,因为只要不是和<0 就说明总的值是一直在增加的
 * */
public class FindGreatestSumOfSubArray {
    public static int findGreatestSumOfSubArray(int[] array) {
    	if(array.length == 0) {
    		return 0;
    	}
    	
        int sum = array[0];
        int maxSum = array[0];
        
        for (int i = 1; i < array.length; i++) {
			if(sum + array[i] < 0) {
                sum += array[i];
				if(sum > maxSum) {
					maxSum = sum;
				}
				sum = 0;
			} else {
				sum += array[i];
                if(sum > maxSum) {
                    maxSum = sum;
                }
			}
		}
        
        return maxSum;
    }
    
    public static void main(String[] args) {
		int [] array = {6,-3,-2,7,-15,1,2,2};
		System.out.println(findGreatestSumOfSubArray(array));
	}
}

