package nowcoder_test2018;

import java.util.Scanner;
public class Now1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while(sc.hasNext()) {
            int x = sc.nextInt();
            int f = sc.nextInt();
            int d = sc.nextInt();
            int p = sc.nextInt();
            int day = 0;

            if(d > f * x) {
                day = (d - f * x) / (p + x) + f;
            } else {
                day = d / x;
            }
            System.out.println(day);
        }
    }
}
