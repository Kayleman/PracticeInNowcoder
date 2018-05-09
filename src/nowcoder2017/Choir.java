package nowcoder2017;

import java.util.Scanner;

/*
* 题目描述:
* 有 n 个学生站成一排，每个学生有一个能力值，牛牛想从这 n 个学生中按照顺序选取 k 名学生，
* 要求相邻两个学生的位置编号的差不超过 d，使得这 k 个学生的能力值的乘积最大，你能返回最大的乘积吗？
*
* 输入描述:
* 每个输入包含 1 个测试用例。每个测试数据的第一行包含一个整数 n (1 <= n <= 50)，表示学生的个数，
* 接下来的一行，包含 n 个整数，按顺序表示每个学生的能力值 ai（-50 <= ai <= 50）。
* 接下来的一行包含两个整数，k 和 d (1 <= k <= 10, 1 <= d <= 50)。
*
* 输出描述:
* 输出一行表示最大的乘积。
* 示例1
*
* 输入
* 3
* 7 4 7
* 2 50
*
* 输出
* 49
*
* 解题思路:
* 因为有正有负，负负得正，所以要维护两个dp数组，一个存储最大，一个存储最小。
* 定义max[k][i]表示当选中了k个学生，并且以第i个学生为结尾，所产生的最大乘积；
*    min[k][i]表示当选中了k个学生，并且以第i个学生为结尾，所产生的最小乘积；
* 那么max[k+1][i+1]=max(max[k][i]*power[i+1],min[k][i]*power[i+1])，
* 即当选中了k个学生后，再选择第i+1编号学生，所产生的最大乘积；
* 然而，并不能保证上一次选择的就是第i个学生，所以要遍历子数组max[k]，
* 令j从i到1，并且j与i+1之间小于间隔D，遍历max[k][j]，以及min[k][j]；
* 同理max[k+1][i+1]=min(min[k][i]*power[i+1],max[k][i]*power[i+1])。
* 最后，遍历一遍max[K][i]求得最大值（i从1～N）。
* */
public class Choir {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while(sc.hasNext()) {
            int n = sc.nextInt();
            int[] power = new int[n + 1];
            for (int i = 1; i <= n; i++) {
                power[i] = sc.nextInt();
            }
            int K = sc.nextInt();
            int d = sc.nextInt();
            long max[][] = new long[K + 1][n + 1];
            long min[][] = new long[K + 1][n + 1];
            long res = Integer.MIN_VALUE; //将结果值设置为最小值

            for (int endPerson = 1; endPerson <= n; endPerson++) {
                max[1][endPerson] = power[endPerson];
                min[1][endPerson] = power[endPerson];
                for (int k = 2; k <= K; k++) {
                    for(int leftPerson = endPerson - 1; leftPerson > 0 & endPerson - leftPerson <= d; leftPerson--) {
                        max[k][endPerson] = Math.max(max[k][endPerson],
                                Math.max(max[k - 1][leftPerson] * power[endPerson], min[k - 1][leftPerson] * power[endPerson]));
                        min[k][endPerson] = Math.min(min[k][endPerson],
                                Math.min(max[k - 1][leftPerson] * power[endPerson], min[k - 1][leftPerson] * power[endPerson]));
                    }
                }
                res = Math.max(res, max[K][endPerson]);
            }
            System.out.println(res);
        }
    }
}
