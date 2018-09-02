package algorithm.nowcoder_algorithm;

import java.util.Arrays;

public class test3_6 {
    public static String reverseSentence(String A, int n) {
        char[] array = A.toCharArray();
        reverseCharArray(array, 0, array.length - 1);
        int start = 0;
        int end = 0;
        for (int i = 0; i < array.length; i++) {
            if(array[i] == ' ') {
                end = i - 1;
                reverseCharArray(array, start, end);
                start = i + 1;
            }
            if(i == array.length - 1) {
                end = i;
                reverseCharArray(array, start, end);
            }
        }

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
        String str = "Hello World";
        char[] array = str.toCharArray();
        String str1 = "TUM MKIALI KVJUBEN VBSEWFT JAD AIZWEL CP LG PTB";



        System.out.println(reverseSentence(str1, str1.length()));
    }
}
