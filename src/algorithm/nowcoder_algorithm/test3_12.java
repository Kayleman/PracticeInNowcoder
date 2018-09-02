package algorithm.nowcoder_algorithm;

import java.util.HashMap;

public class test3_12 {
    public static int longestSubstring(String A, int n) {
        if(A == null || n <= 0) {
            return 0;
        }
        int pre = -1;
        int maxLen = 0;
        int[] map = new int[256];
        for (int i = 0; i < 256; i++) {
            map[i] = -1;
        }
        int tempLen = 0;
        for (int i = 0; i < n; i++) {
            pre = Math.max(pre, map[A.charAt(i)]);
            tempLen = i - pre;
            maxLen = Math.max(maxLen, tempLen);
            map[A.charAt(i)] = i;
        }
        return maxLen;
    }

    public static void main(String[] args) {
        String str ="aabcb";
        System.out.println(longestSubstring(str, str.length()));
    }
}
