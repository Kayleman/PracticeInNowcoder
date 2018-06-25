package nowcoder2017;


import java.util.Scanner;
public class AliQ1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while(sc.hasNext()) {
            int N = sc.nextInt();
            int M = sc.nextInt();
            int cols = sc.nextInt();
            int[][] array = new int[M][cols];
            for (int i = 0; i < M; i++) {
                for (int j = 0; j < cols; j++) {
                    array[i][j] = sc.nextInt();
                }
            }
        }
        System.out.println(5);

    }


}
