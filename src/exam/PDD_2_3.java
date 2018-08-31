package exam;

import java.util.Scanner;

public class PDD_2_3 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int m = scanner.nextInt();
        char[][] map = new char[n][m];
        for (int i = 0; i < n; i++) {
            String line = scanner.next();
            map[i] = line.toCharArray();
        }
        for (int i = 0; i < m; i++) {
            helper(map, i, 0, -1);
        }
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                System.out.print(map[i][j]);
            }
            System.out.println();
        }
    }

    public static void helper(char[][] map, int find_1, int find_2, int final_x) {
        if (find_2 == map.length) {

            int i = final_x + 1;
            while (i < find_2) {
                map[i][find_1] = '.';
                i++;
            }
            return;
        }
        if (map[find_2][find_1] != 'x') {
            helper(map, find_1, ++find_2, final_x);
        } else {
            int count = 0;
            int i = final_x + 1;
            while (i < find_2) {
                if (map[i][find_1] == 'o') {
                    count++;
                }
                i++;
            }

            int tempCount = count;
            for (; count > 0; count--) {
                map[find_2 - count][find_1] = 'o';
            }
            int j = final_x + 1;
            while (j < find_2 - tempCount) {
                map[j][find_1] = '.';
                j++;
            }
            final_x = find_2;
            helper(map, find_1, ++find_2, final_x);
        }
    }
}