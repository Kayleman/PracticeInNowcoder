package exam;

import java.text.DecimalFormat;
import java.util.Scanner;

public class HuaWei_3 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()) {
            int n = sc.nextInt();
            int[] array = new int[n];
            int sum;
            int max;
            int min;
            array[0] = sc.nextInt();
            sum = max = min = array[0];
            for (int i = 1; i < n; i++) {
                array[i] = sc.nextInt();
                if(array[i] > max) {
                    max = array[i];
                }
                if(array[i] < min) {
                    min = array[i];
                }
                sum += array[i];
            }
            double ans = (sum - max - min) * 1.0 / (n - 2);
            DecimalFormat df = new DecimalFormat("0.00");
            System.out.println(df.format(ans));
        }
    }
}
