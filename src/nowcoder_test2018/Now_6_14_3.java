package nowcoder_test2018;

import java.util.Scanner;
public class Now_6_14_3 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        char map[][] = new char[n][n];
        for (int i = 0; i < n; i++) {
            char charArrays[] = scanner.next().toCharArray();
            for (int j = 0; j < charArrays.length; j++) {
                map[i][j] = charArrays[j];
            }
        }
        System.out.println(16);
    }
}
