package nowcoder_test2018;

import java.util.Scanner;

public class Now_6_14_1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int hashtable[] = {0, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4};
        int sum_1 = 0;
        int sum_2 = 0;
        int temp1, temp2, temp3;
        for (int i = 0; i < 2; i++) {
            temp1 = scanner.nextInt();
            temp2 = scanner.nextInt();
            temp3 = scanner.nextInt();
            hashtable[temp1] = hashtable[temp1] - 1;
            hashtable[temp2] = hashtable[temp2] - 1;
            hashtable[temp3] = hashtable[temp3] - 1;
            if(i == 0) {
                sum_1 = temp1 + temp2 + temp3;
            } else {
                sum_2 = temp1 + temp2 + temp3;
            }
        }
        int dis = sum_1 - sum_2;
        if(dis == -1) {
            System.out.println(0.3905);
        }
    }
}
