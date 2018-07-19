package exam;

import java.util.Arrays;
import java.util.Scanner;

public class HuaWei_5 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            int L = scanner.nextInt();
            int shortStep, longStep, stoneNum, ans, now, total;
//            stoneNum = 5;
            shortStep = longStep = stoneNum = ans = 0;

            int s = scanner.nextInt();
            int t = scanner.nextInt();
            int n = scanner.nextInt();
            shortStep = s;
            longStep = t;
            stoneNum = n;


            int[] array = new int[105];
            int[] visited = new int[10001];
            int[] fun = new int[10001];
            for (int i = 1; i <= stoneNum; i++) {
                array[i] = scanner.nextInt();
            }

            if(shortStep == longStep) {
                for (int i = 0; i < stoneNum; i++) {
                    if(array[i] % longStep == 0) {
                        ans++;
                    }
                }
                System.out.println(ans);
            }


            Arrays.sort(array, 1, stoneNum + 1);
            visited[total = array[1] % 90] = 1;
            for (int i = 2; i <= stoneNum; i++) {
                visited[total += (array[i] - array[i - 1]) % 90] = 1;
            }

            for (int i = total; i >= 0; i--) {
                fun[i] = 100;
                for (int j = shortStep; j <= longStep; j++) {
                    fun[i] = Math.min(fun[i], fun[i + j] + visited[i]);
                }
            }
            System.out.println(fun[0]);

        }
    }
}

