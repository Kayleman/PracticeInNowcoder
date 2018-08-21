package nowcoder_test2018;

import java.util.Scanner;
public class Now2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        while (T != 0) {
            boolean flag = true;
            int N = sc.nextInt();
            int A = sc.nextInt();
            int B = sc.nextInt();
            int C = sc.nextInt();
            int count = 6;
            flag = true;

            while (N > 0) {
                count = 6;

                while (count > 0) {
                    if (C > 0 && count >= 3) {
                        count -= 3;
                        C--;
                        continue;
                    } else if (B > 0 && count >= 2) {
                        count -= 2;
                        B--;
                        continue;
                    } else if (A > 0 && count >= 1) {
                        count -= 1;
                        A--;
                        continue;
                    } else {
                        System.out.println("No");
                        flag = false;
                        break;
                    }
                }

                if (!flag)
                    break;

                N--;
            }
            if(flag) {
                System.out.println("Yes");
            }
            T--;
        }

    }
}


