package exam;

import java.util.Scanner;

public class PDD_2_1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            int HP = scanner.nextInt();
            int normal = scanner.nextInt();
            int buffer = scanner.nextInt();
            boolean flag;
            if(normal * 2 >= buffer) {
                flag = true;
            } else {
                flag = false;
            }
            int count = 0;
            while (HP > 0) {
                if (flag) {
                    if(HP - normal <= 0) {
                        count++;
                        break;
                    } else {
                        HP = HP - normal * 2;
                        count += 2;
                    }
                } else {
                    if(HP - normal <= 0) {
                        count++;
                        break;
                    } else {
                        HP = HP - buffer;
                        count += 2;
                    }
                }
            }
            System.out.println(count);
        }
    }
}
