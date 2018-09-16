package algorithm.thread_learn;

public class LCS {
    /**
     * 由于最长公共子串只可能是最短字符串全部
     * 所以以较短的那个字符串为准从长到短开始匹配
     * 匹配到的就是找到最长公共子串
     * 如果要求最长子串的长度，就将返回值修改为int
     */

    public static String getLongestSubString(String s1, String s2) {
        String sub;
        String longer = s1, shorter = s2;
        // 比较长度
        if (longer.length() < shorter.length()) {
            longer = s2;
            shorter = s1;
        }
        // 用更短的字符串匹配
        for (int i = shorter.length(); i > 0; i--) {
            for (int j = 0; j < shorter.length()-i+1; j++) {
                sub = shorter.substring(j, j + i);
                if (longer.contains(sub)){
                    return sub;
                }
            }
        }
        //没有匹配的子串，返回空字符串
        return "";
    }

    public static void main(String[] args) {
        String str1 = "GCCCTAGCCAGDE";
        String str2 = "GCGCCAGTGDE";
        System.out.println(getLongestSubString(str1, str2));
    }
}
