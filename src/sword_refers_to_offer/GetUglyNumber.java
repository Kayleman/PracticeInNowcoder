package sword_refers_to_offer;

/*
 * 题目描述:
 * 把只包含因子2、3和5的数称作丑数（Ugly Number）。
 * 例如6、8都是丑数，但14不是，因为它包含因子7。 
 * 习惯上我们把1当做是第一个丑数。
 * 求按从小到大的顺序的第N个丑数。
 * 
 * 解题思路:
 * 首先可以知道丑数的特性是在一个丑数的基础上,乘以2,3,5中的一个数得到
 * 因为要从小到大的顺序排列,所以需要计算乘以2,3,5的时候哪个数更小.
 * 当基数是同一个的时候,肯定是乘以2小,但是基数需要轮流取,这就需要用三个cur来定位当前基数
 * 最开始都是0,也就是基数都为1,经过第一轮比较,发现min是2,于是cur2+1变成了1,这时候指向了2
 * 下一次循环的时候就是2*2和1*3和1*5来进行比较,只要某一个乘数得到的丑数被添加进数组
 * 那么就把cur+1,一直到总数达到index的个数
 * */
public class GetUglyNumber {
    static int GetUglyNumber_Solution(int index) {
    	if(index <= 0) return 0;
    	int [] res = new int[index];
    	res[0] = 1;
    	int cur2 = 0;
    	int cur3 = 0; 
    	int cur5 = 0;
    	int count = 1;
    	while(count < index) {
    		int m2 = res[cur2] * 2;
    		int m3 = res[cur3] * 3;
    		int m5 = res[cur5] * 5;
    		int min = Math.min(m2, Math.min(m3, m5));
    		res[count++] = min;
    		if(min == m2) cur2++;
    		if(min == m3) cur3++;
    		if(min == m5) cur5++;
    	}
        return res[index - 1];
    }
    
    public static void main(String[] args) {
		System.out.println(GetUglyNumber_Solution(11));
	}
}

