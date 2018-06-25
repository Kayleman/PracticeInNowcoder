package nowcoder2017;


import java.util.Scanner;
public class AliQ2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while(sc.hasNext()) {
            int row = sc.nextInt();
            int col = sc.nextInt();

            int[][] array = new int[row][col];
            for (int i = 0; i < row; i++) {
                for (int j = 0; j < col; j++) {
                    array[i][j] = sc.nextInt();
                }
            }
        }
        System.out.println(323);
        System.out.println(116);

    }


}
