package sword_refers_to_offer;

/*
* 题目描述:
* 求1+2+3+...+n，要求不能使用乘除法、for、while、if、else、switch、case等关键字及条件判断语句（A?B:C）。
*
* 解题思路：
* 使用递归来计算，n不断-1，然后利用&&的短路机制来退出递归。
*
* */
public class Sum_Special {
    public int Sum_Solution(int n) {
        int sum = n;
        boolean flag = (sum > 0) && (sum += Sum_Solution(n - 1)) > 0;
        return sum;
    }

    public static void main(String[] args) {
        Sum_Special ss = new Sum_Special();

        System.out.println(ss.Sum_Solution(10));
    }
}
