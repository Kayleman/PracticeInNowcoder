package sword_refers_to_offer;

public class Match {
    public boolean match(char[] str, char[] pattern) {
        if(str == null || pattern == null) {
            return false;
        }
        int strIndex = 0;
        int patternIndex = 0;
        return matchCore(str, strIndex, pattern, patternIndex);
    }

    public boolean matchCore(char[] str, int strIndex, char[] pattern, int patternIndex) {
        //str和pattern都到尾，匹配成功
        if(strIndex == str.length && patternIndex == pattern.length) {
            return true;
        }
        //pattern先到尾，匹配失败
        if(strIndex != str.length && patternIndex == pattern.length) {
            return false;
        }
        //如果pattern有下一个字符，且下一个字符为*，则有3种匹配模式。如果不匹配，pattern后移2位，跳过
        if(patternIndex + 1 < pattern.length && pattern[patternIndex + 1] == '*') {
            //str没到尾，且str和pattern相等，或者pattern等于.，则进入3种匹配模式的递归
            if((strIndex != str.length && pattern[patternIndex] == str[strIndex])
                    || (strIndex != str.length && pattern[patternIndex] == '.')) {
                       //*为0，则直接+2跳过当前字符和*
                return matchCore(str, strIndex, pattern, patternIndex + 2)
                        //*为1，则匹配1位，strIndex向后移动一位，patternIndex移2位，跳过*
                        || matchCore(str, strIndex + 1, pattern, patternIndex + 2)
                        //*为n，则匹配1位，strIndex向后移动一位，patternIndex不动，后面可能还要匹配多次
                        || matchCore(str, strIndex + 1, pattern, patternIndex);
            } else {
                //否侧匹配失败，跳过字符和*
                return matchCore(str, strIndex, pattern, patternIndex + 2);
            }
        }
        //pattern下一个字符不为*，且str和pattern第一个字符匹配，则都后移一位，否则返回false
        if((strIndex != str.length && pattern[patternIndex] == str[strIndex])
                || (strIndex != str.length && pattern[patternIndex] == '.')) {
            return matchCore(str, strIndex + 1, pattern, patternIndex + 1);
        } else {
            return false;
        }
    }
}
