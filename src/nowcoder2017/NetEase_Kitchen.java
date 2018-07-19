package nowcoder2017;

import java.util.HashSet;
import java.util.Scanner;

/**
 * 题目描述:
 * 牛牛想尝试一些新的料理，每个料理需要一些不同的材料，问完成所有的料理需要准备多少种不同的材料。
 *
 * 输入描述:
 * 每个输入包含 1 个测试用例。每个测试用例的第 i 行，表示完成第 i 件料理需要哪些材料，各个材料用空格隔开，
 * 输入只包含大写英文字母和空格，输入文件不超过 50 行，每一行不超过 50 个字符。
 *
 * 输出描述:
 * 输出一行一个数字表示完成所有料理需要多少种不同的材料。
 *
 * 示例1
 *
 * 输入:
 * BUTTER FLOUR
 * HONEY FLOUR EGG
 *
 * 输出：
 * 4
 *
 * 解题思路：
 * 本题难点在于不知道会输入多少行，所以直接使用hasNext()来进行不断循环读入
 * 1.在读字符串的时候可以用nextLine()来进行整行读入，再进行split函数分割，
 *   然后放入HashSet中自动去重，得到的size就是材料数量
 * 2.可以直接使用next()进行读取，因为next()遇到空格就结束读入，可以自动分割
 * */
public class NetEase_Kitchen {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        HashSet<String> set = new HashSet<String>();
        while (sc.hasNext()) {
              // 因为每个材料是用空格隔开，所以可以直接用next()来读取，遇到空格会自动认为一个字符串结束
//            String line = sc.nextLine();
//            String[] array = line.split(" ");
//            for (int i = 0; i < array.length; i++) {
//                set.add(array[i]);
//            }

            String str = sc.next();
            set.add(str);
        }
        System.out.println(set.size());
    }
}
