package kayle.practice.nowcoder;

/*
* 题目描述:
* 地上有一个m行和n列的方格。一个机器人从坐标0,0的格子开始移动，
* 每一次只能向左，右，上，下四个方向移动一格，但是不能进入行坐标和列坐标的数位之和大于k的格子。
* 例如，当k为18时，机器人能够进入方格（35,37），因为3+5+3+7 = 18。
* 但是，它不能进入方格（35,38），因为3+5+3+8 = 19。请问该机器人能够达到多少个格子？
*
* 解题思路:
* 写一个计算位数和的函数，然后用回溯的思想从0，0开始
* 用一个visited数组来记录是否访问过
* 越界或者行列坐标数位之和大于threshold或者已被访问过，不计数，返回0
* 否则先将visited设为true
* 然后再+1 再加上其他四个方向的递归。
* */
public class MovingCount {
    public int movingCount(int threshold, int rows, int cols) {
        boolean[][] visited = new boolean[rows][cols];
        return helper(threshold, rows, cols, 0, 0, visited);
    }

    private int helper(int threshold, int rows, int cols, int i, int j, boolean[][] visited) {
        if(i < 0 || i >= rows || j < 0 || j >= cols
            || calNum(i) + calNum(j) > threshold || visited[i][j]) {
            return 0;
        }
        visited[i][j] = true;
        return 1 + helper(threshold, rows, cols, i - 1, j, visited)
                + helper(threshold, rows, cols, i + 1, j, visited)
                + helper(threshold, rows, cols, i, j - 1, visited)
                + helper(threshold, rows, cols, i, j + 1, visited);
    }

    private int calNum(int num) {
        int ans = 0;
        while (num / 10 != 0) {
            ans += (num % 10);
            num /= 10;
        }
        ans += num;
        return ans;
    }

    public static void main(String[] args) {
        MovingCount mc = new MovingCount();
        System.out.println(mc.calNum(1266));
    }
}
