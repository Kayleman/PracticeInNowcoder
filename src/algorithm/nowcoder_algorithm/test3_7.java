package algorithm.nowcoder_algorithm;

public class test3_7 {
    public static String stringTranslation(String A, int n, int len) {
        char[] array = A.toCharArray();
        reverseCharArray(array, 0, len - 1);
        reverseCharArray(array, len, n - 1);
        reverseCharArray(array, 0, n - 1);
        return new String(array);
    }

    public static void reverseCharArray(char[] array, int start, int end) {
        int len = end - start + 1;
        for (int i = 0; i < len / 2; i++) {
            char temp = array[i + start];
            array[i + start] = array[len - 1 - i + start];
            array[len - 1 - i + start] = temp;
        }
    }

    public static void main(String[] args) {
        String str = "ABCDE";
        System.out.println(stringTranslation(str, str.length(), 3));
    }
}
