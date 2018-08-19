package exam;

public class PDD_1 {
    public static void main(String[] args) {
        String str = "abcdefghijklmnop";
        char[] array = str.toCharArray();
        int len = str.length() / 4 + 1;
        char[][] map = new char[len][len];
        int count = 0;
        for (int i = 0; i < len; i++) {
            for (int j = 0; j < len; j++) {
                map[i][j] = ' ';
            }
        }
        for (int j = 0; j < len; j++) {
            map[0][j] = array[count++];
        }
        for (int i = 1; i < len; i++) {
            map[i][len - 1] = array[count++];
        }
        for (int j = len - 2; j >= 0; j--) {
            map[len - 1][j] = array[count++];
        }
        for (int i = len - 2; i >= 1; i--) {
            map[i][0] = array[count++];
        }
        for (int i = 0; i < len; i++) {
            for (int j = 0; j < len; j++) {
                System.out.print(map[i][j]);
            }
            System.out.println();
        }
    }
}
