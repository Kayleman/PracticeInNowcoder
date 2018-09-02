package algorithm.nowcoder_algorithm;

public class test3_10 {
    public static String replaceSpace(String iniString, int length) {
        int count = 0;
        for (int i = 0; i < length; i++) {
            if (iniString.charAt(i) == ' ') {
                count++;
            }
        }
        int newLen = length + 2 * count;
        char[] array = new char[newLen];
        int index = newLen - 1;
        for (int i = length - 1; i >= 0; i--) {
            if (iniString.charAt(i) == ' ') {
                array[index--] = '0';
                array[index--] = '2';
                array[index--] = '%';
            } else {
                array[index--] = iniString.charAt(i);
            }
        }
        return new String(array);
    }

    public static void main(String[] args) {
        String str = "Hello World Ni Hao";
        System.out.println(replaceSpace(str, str.length()));
    }
}
