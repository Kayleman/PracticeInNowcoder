package algorithm.nowcoder_algorithm;

import java.util.Arrays;

public class test3_8 {
    public static String findSmallest(String[] strs, int n) {
        stringBubbleSort(strs);
        StringBuilder sb = new StringBuilder();
        for(String str: strs) {
            sb.append(str);
        }
        return sb.toString();
    }

    public static void stringBubbleSort(String[] array){
        for (int i = array.length; i > 0; i--) {      //外层循环移动游标
            for(int j = 0; j < i && (j+1) < i; j++){    //内层循环遍历游标及之后(或之前)的元素
                if(stringCompare(array[j], array[j + 1]) > 0) {
                    String temp = array[j];
                    array[j] = array[j + 1];
                    array[j + 1] = temp;
                }
            }
        }
    }

    public static int stringCompare(String str1, String str2) {
        return (str1 + str2).compareTo((str2 + str1));
    }

    public static void main(String[] args) {
        String[] strs = {"abc", "de"};
        System.out.println(findSmallest(strs, 2));
    }
}
