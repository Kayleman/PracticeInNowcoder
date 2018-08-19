package exam;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Scanner;

public class PDD_2 {
    public static void main(String[] args) {
        HashSet<ArrayList> res = new HashSet<>();
        Scanner scanner = new Scanner(System.in);
        int num = scanner.nextInt();
        int div = 10;
        while (num / div != 0) {
            int left = num / div;
            int right = num % div;
            ArrayList<Integer> list = new ArrayList<>();
            list.add(left);
            list.add(right);
            res.add(list);
            if(left > 10) {
                double newLeft = left * 1.0 / 10;
//                ArrayList<Double> =
            }
            div *= 10;
        }

        System.out.println(res.toString());
    }
}
