package algorithm.nowcoder_algorithm;

public class test2_18 {
    public boolean findX(int[][] mat, int n, int m, int x) {
        int i = 0;
        int j = m - 1;
        while (i < n && j >= 0) {
            if(x > mat[i][j]) {
                i++;
            } else if(x < mat[i][j]) {
                j--;
            } else {
                return true;
            }
        }
        return false;
    }
}
