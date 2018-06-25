package nowcoder2017;

import java.util.Scanner;
public class DungeonEscape {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while(sc.hasNext()){
            int x = sc.nextInt();
            int y = sc.nextInt();

            char[][] dungeon = new char[x][y];

            for (int i = 0; i < x; i++) {
                String str = sc.next();
                dungeon[i] = str.toCharArray();
            }
        }
    }
}
