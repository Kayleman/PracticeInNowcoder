package exam;

import java.util.Scanner;

public class DD_1 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        while(input.hasNext()) {
            String strLine = input.nextLine();
            String[] strArray = strLine.split(" ");
            int[] step = new int[strArray.length];
            step[0] = Integer.MAX_VALUE;
//            for (int i = 0; i < strArray.length; i++) {
//                System.out.println(strArray[i]);
//            }
            for (int i = 1; i < strArray.length; i++) {
                step[i] = howMany(strArray[0], strArray[i]);
            }
//            insertionSort(step);
//            for (int i = 1; i < strArray.length; i++) {
//                if()
//            }
            for (int i = 0; i < 3; i++) {
                int min_num =  0;
                for (int j = 1; j < strArray.length; i++) {
                    if(step[min_num] > step[j]) {
                        min_num = j;
                    }
                }
                if(i != 2) {
                    System.out.print(strArray[min_num] + " ");
                } else {
                    System.out.print(strArray[min_num]);
                }
                step[min_num] = Integer.MAX_VALUE;
            }
        }

    }

    public static void insertionSort(int[] array) {
        for (int i = 0; i < array.length - 1; i++) {
            for (int j = i + 1; j > 0; j--) {
                if(array[j - 1] > array[j]) {
                    int temp = array[j - 1]; //如果不是有序就交换位置
                    array[j - 1] = array[j];
                    array[j] = temp;
//                    System.out.println("Sorting: " + Arrays.toString(array));
                }
            }
        }
    }

    public static int howMany(String s1, String s2) {
//        String s1 = "cafe";
//        String s2 = "coffee";
        int[][] dp = new int[s1.length() + 1][s2.length() + 1];
        //对dp数组初始化
        for (int i = 0; i < dp.length; i++) dp[i][0] = i;
        for (int j = 0; j < dp[0].length; j++) dp[0][j] = j;

        for (int i = 1; i < dp.length; i++) {
            for (int j = 1; j < dp[0].length; j++) {
                if (s1.charAt(i - 1) == s2.charAt(j - 1)) dp[i][j] = dp[i - 1][j - 1];
                else dp[i][j] = min(dp[i - 1][j], dp[i][j - 1], dp[i - 1][j - 1]) + 1;
            }
        }
//        System.out.println(dp[dp.length - 1][dp[0].length - 1]);
        return dp[dp.length - 1][dp[0].length - 1];
    }

    public static int min(int a, int b, int c) {
        return Math.min(a, Math.min(b, c));
    }

}
