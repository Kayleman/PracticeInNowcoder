package kayle.practice.nowcoder;

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
