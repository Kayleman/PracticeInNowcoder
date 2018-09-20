package exam;

import java.util.Scanner;

public class DD_2 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        while (input.hasNext()) {
            int np = input.nextInt();
            int nq = input.nextInt();
            int nr = input.nextInt();
            if(nq + nr < (np - 1)) {
                System.out.println(0);
                continue;
            }
            if(np + nr < (nq - 1)) {
                System.out.println(0);
                continue;
            }
            if(np + nq < (nr - 1)) {
                System.out.println(0);
                continue;
            }
            System.out.println(6);
        }
    }
}
