package exam;

import java.util.Arrays;
import java.util.Scanner;

public class IQYI_2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            int foodNum = scanner.nextInt();
            int days = scanner.nextInt();
            int foodP = scanner.nextInt();
            int[] foodCur = new int[foodNum];
            for (int i = 0; i < foodNum; i++) {
                foodCur[i] = scanner.nextInt();
            }
            for (int i = 0; i < days; i++) {
                String flag = scanner.next();
                int num = scanner.nextInt();
                if(flag.equals("B")) {
                    foodCur[num - 1]--;
                }
                if(flag.equals("A")) {
                    foodCur[num - 1]++;
                }
            }

            int ansP = foodCur[foodP - 1];
            Arrays.sort(foodCur);
            int count = 0;
            for (int i = foodNum - 1; i >= 0; i--) {
                if(foodCur[i] > ansP) {
                    count++;
                }
                if(foodCur[i] == ansP) {
                    count++;
                    break;
                }
            }
            System.out.println(count);
        }
    }
}
