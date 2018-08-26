package algorithm.nowcoder_algorithm;

public class test3_11 {
    public static boolean chkParenthesis(String A, int n) {
        if (A == null || n <= 0) {
            return false;
        }
        int num = 0;
        for (int i = 0; i < n; i++) {
            if (A.charAt(i) == '(') {
                num++;
            } else if (A.charAt(i) == ')') {
                num--;
            }
            if (num < 0) {
                return false;
            }
        }
        if (num == 0) {
            return true;
        } else {
            return false;
        }
    }
}
