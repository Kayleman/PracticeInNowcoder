package algorithm.nowcoder_algorithm;
import java.util.*;

public class test1_4 {
    public static boolean chkRotation(String A, int lena, String B, int lenb) {
        // write code here
        if(lena != lenb) {
            return false;
        }

        String str = A + A;
        for (int i = 0; i < str.length() - lenb; i++) {
            String temp = str.substring(i, i + lena);
            if(temp.equals(B)) {
                return true;
            }
        }

        return false;
    }

    public static void main(String[] args) {
        System.out.println(chkRotation("cdab",4,"abcd",4));
    }
}



