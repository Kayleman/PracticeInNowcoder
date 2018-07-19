package exam;

import java.util.Scanner;

public class HuaWei_5_2 {
    private final static int N = 100020;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()) {
            int L = Integer.parseInt(sc.nextLine());
            String[] strings = sc.nextLine().split(" ");
            int shortStep = Integer.parseInt(strings[0]);
            int longStep = Integer.parseInt(strings[1]);
            int stoneNum = Integer.parseInt(strings[2]);
            String[] stoneListStr = sc.nextLine().split(" ");
            int len = stoneNum;
            int[] stoneList = new int[len];
            int[] flag = new int[N];
            int[] dp = new int[N];
            for (int i = 0; i < N; i++) {
                dp[i] = -1;
            }
            for (int i = 0; i < len; i++) {
                stoneList[i] = Integer.parseInt(stoneListStr[i]);
                flag[stoneList[i]] = 1;
            }
            dp[0] = 0;
            for (int i = shortStep; i <= L + longStep - 1; i++) {
                for (int j = i - longStep; j <= i - shortStep; j++) {
                    if (j >= 0 && dp[j] != -1) {
                        if (dp[i] == -1)
                            dp[i] = dp[j] + flag[i];
                        else if (dp[i] > dp[j] + flag[i])
                            dp[i] = dp[j] + flag[i];
                    }
                }
            }
            int res = 10000;
            for (int i = L; i <= L + longStep - 1; i++) {
                if (dp[i] != -1 && dp[i] < res)
                    res = dp[i];
            }
            System.out.println(res);

        }
    }
}