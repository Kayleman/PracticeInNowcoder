package nowcoder_test2018;

import java.util.Scanner;
public class Now_6_14_2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int map[][] = new int[1001][1001];
        for (int i = 0; i < n; i++) {
            int x = scanner.nextInt();
            int y = scanner.nextInt();
            map[x][y] = 1;
        }
        int m = scanner.nextInt();
        for (int i = 0; i < m; i++) {
            int sum = 0;
            int x1, y1, x2, y2;

            x1 = scanner.nextInt();
            y1 = scanner.nextInt();
            x2 = scanner.nextInt();
            y2 = scanner.nextInt();


            for (int row = x1; row <= x2; row++) {
                for(int col = y1; col <= y2; col++) {
                    sum += map[row][col];
                }
            }
            System.out.println(sum);
        }
    }
}
