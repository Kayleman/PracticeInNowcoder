package exam;

import java.util.Scanner;

public class IQYI_1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            String str = scanner.next();
            char[] charArray = str.toCharArray();
            int countLeft = charArray[0] - '0' + charArray[1] - '0' + charArray[2] - '0';
            int countRight = charArray[3] - '0' + charArray[4] - '0' + charArray[5] - '0';
            int num = Math.abs(countLeft - countRight);
            int ans = num % 9 == 0 ? num / 9 : num / 9 + 1;
            System.out.println(ans);
        }
    }

}
