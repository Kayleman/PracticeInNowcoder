package algorithm.nowcoder_algorithm;

public class test3_3 {
    public static boolean chkTransform(String A, int lena, String B, int lenb) {
        if (A == null || B == null || lena != lenb) {
            return false;
        }
        char[] arrayA = A.toCharArray();
        char[] arrayB = B.toCharArray();

        int max = 65536;
        int[] countA = new int[max];
        int[] countB = new int[max];
        for (int i = 0; i < lena; i++) {
            countA[arrayA[i]]++;
        }

        for (int i = 0; i < lenb; i++) {
            countB[arrayB[i]]++;
        }

        for (int i = 0; i < max; i++) {
            if (countA[i] != countB[i]) {
                return false;
            }
        }
        return true;
    }
}
