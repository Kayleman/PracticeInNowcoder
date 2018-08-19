package exam;

import java.util.Scanner;


public class Netease_2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();

        int[] array_1 = new int[n + 1];
        array_1[0] = 0;
        for (int i = 1; i < n + 1; i++) {
            array_1[i] = scanner.nextInt() + array_1[i - 1];
        }
        int m = scanner.nextInt();

        int[] array_2 = new int[m];
        for (int i = 0; i < m; i++) {
            array_2[i] = scanner.nextInt();
        }
        for (int i = 0; i < m; i++) {
            int left = 0;
            int right = n + 1;
            int mid = (left + right) / 2;
            while (true) {
                if (array_1[mid] >= array_2[i] && array_1[mid - 1] < array_2[i]) {
                    System.out.println(mid);
                    break;
                } else if (array_1[mid] < array_2[i]) {
                    left = mid;
                    mid = (left + right) / 2;
                } else if (array_1[mid - 1] >= array_2[i]) {
                    right = mid;
                    mid = (left + right) / 2;
                }
            }
        }
    }
}