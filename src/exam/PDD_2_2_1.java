package exam;

import java.util.HashMap;
import java.util.Scanner;


public class PDD_2_2_1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            int a = scanner.nextInt();
            int b = scanner.nextInt();
            int[] outputArray = new int[2];

            int numCountLength = 0;
            a = a % b;
            if (a == 0) {
                return;
            }
            HashMap<Integer, Integer> isRepeatingMap = new HashMap<>();
            isRepeatingMap.put(a, numCountLength);

            while (true) {
                a = a * 10 % b;
                numCountLength++;
                if (a == 0 || isRepeatingMap.get(a) != null) {
                    break;
                }
                isRepeatingMap.put(a, numCountLength);
            }

            outputArray[0] = a == 0 ? numCountLength : isRepeatingMap.get(a);
            outputArray[1] = numCountLength - isRepeatingMap.get(a);

            System.out.println(outputArray[0] + " " + outputArray[1]);
        }


    }
}


