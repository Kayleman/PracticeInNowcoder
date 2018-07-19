package leetcode;

import java.util.Set;

/**
* 题目描述:
* Given a string s and a dictionary of words dict,
* determine if s can be segmented into a space-separated sequence of one or more dictionary words.
*
* For example, given
* s ="leetcode",
* dict =["leet", "code"].
*
* Return true because"leetcode"can be segmented as"leet code".
*
* 解题思路:
*
* 状态转移方程：
* f(i) 表示s[0,i)是否可以分词,为了代码不用写end-1，所以设置成左闭右开
* f(i) = f(j) && f(j+1,i); 0 <= j < i;
* 代码中dp[start]指的是从0到start-1这个位置是否可以分词
* */
public class Word_break {
    public boolean wordBreak(String s, Set<String> dict) {
        int len = s.length();
        boolean[] dp = new boolean[len + 1];
        dp[0] = true;
        for (int end = 1; end <= len; end++) {
            for(int start = 0; start < end; start++) {
                //只有当dp[start]和start到end-1都能分词的情况下，dp[end]才能表示为true
                if(dp[start] && dict.contains(s.substring(start, end))) {
                    dp[end] = true;
                }
            }
        }
        return dp[len];
    }
}
