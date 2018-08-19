package exam;

import java.util.Scanner;

public class Netease_1 {
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int k = scanner.nextInt();
        int[] score = new int[n];
        int[] isWeak = new int[n];
        for (int i = 0; i < n; i++){
            score[i] = scanner.nextInt();
        }
        for (int i = 0; i < n; i++){
            isWeak[i] = scanner.nextInt();
        }
        int []dp = new int[n];
        dp[0] = score[0];
        for (int i = 1; i < n; i++){
            if (isWeak[i] == 1){
                dp[i] = dp[i - 1] + score[i];
            }else{
                dp[i] = dp[i - 1];
            }
        }

        int max = -1;
        for (int i = 0; i < n; i++){
            if (isWeak[i] == 0){
                dp[i] = dp[i] + score[i];
            }
            for (int j = 1; j < k; j++){
                if (i + j < n) {
                    dp[i] = dp[i] + score[i + j];
                }
            }
            if (max < dp[i]){
                max = dp[i];
            }
        }

        System.out.println(max);
    }
}