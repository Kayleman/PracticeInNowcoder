package nowcoder2017;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

/**
 * 题目描述：
 * 给定一个 n 行 m 列的地牢，其中 '.' 表示可以通行的位置，'X' 表示不可通行的障碍，
 * 牛牛从 (x0 , y0) 位置出发，遍历这个地牢，和一般的游戏所不同的是，
 * 他每一步只能按照一些指定的步长遍历地牢，要求每一步都不可以超过地牢的边界，也不能到达障碍上。
 * 地牢的出口可能在任意某个可以通行的位置上。牛牛想知道最坏情况下，他需要多少步才可以离开这个地牢。
 *
 * 输入描述:
 * 每个输入包含 1 个测试用例。每个测试用例的第一行包含两个整数 n 和 m（1 <= n, m <= 50），表示地牢的长和宽。
 * 接下来的 n 行，每行 m 个字符，描述地牢，地牢将至少包含两个 '.'。
 * 接下来的一行，包含两个整数 x0, y0，表示牛牛的出发位置（0 <= x0 < n, 0 <= y0 < m，
 * 左上角的坐标为 （0, 0），出发位置一定是 '.'）。
 * 之后的一行包含一个整数 k（0 < k <= 50）表示牛牛合法的步长数，
 * 接下来的 k 行，每行两个整数 dx, dy 表示每次可选择移动的行和列步长（-50 <= dx, dy <= 50）
 *
 * 输出描述:
 * 输出一行一个数字表示最坏情况下需要多少次移动可以离开地牢，如果永远无法离开，输出 -1。
 * 以下测试用例中，牛牛可以上下左右移动，在所有可通行的位置.上，
 * 地牢出口如果被设置在右下角，牛牛想离开需要移动的次数最多，为3次。
 *
 * 示例1
 * 输入
 * 3 3
 * ...
 * ...
 * ...
 * 0 1
 * 4
 * 1 0
 * 0 1
 * -1 0
 * 0 -1
 *
 * 输出
 *
 * 3
 *
 * 解题思路：
 * 使用广度优先遍历，题目的意思是任意一个.都有可能被设置为出口
 * 需要使用最少的步数到达每个.位置，然后计算所有.位置中需要走的步数最多的那个
 *
 * 最坏的情况就是其起点开始到达离他最远的那个"."点,
 * 进行广度遍历而非深度的原因：
 * 因为我们不知道他的出口在哪里，有可能就是他旁边那个，如果有存在没有被访问的“.”说明不能遍历完全，有些出口到不了。
 *
 */
public class NetEase_DungeonEscape {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while(sc.hasNext()){
            int x = sc.nextInt();
            int y = sc.nextInt();

            //地牢地图，x行y列
            char[][] dungeon = new char[x][y];
            //地牢出口位置，值为到达该出口最小走的步数
            int[][] exit = new int[x][y];

            for (int i = 0; i < x; i++) {
                //next()直接读一行，并且将空格作为分隔符
                String str = sc.next();
                dungeon[i] = str.toCharArray();
            }

            int startX = sc.nextInt();
            int startY = sc.nextInt();

            int k = sc.nextInt(); // 合法步长数
            int[] stepX = new int[k]; //x方向上的走法
            int[] stepY = new int[k]; //y方向上的走法

            for (int i = 0; i < k; i++) {
                stepX[i] = sc.nextInt();
                stepY[i] = sc.nextInt();
            }

            // ------------输入部分结束------------

            // 使用队列来进行广度优先遍历
            Queue<Integer> queue_X = new LinkedList<Integer>();
            Queue<Integer> queue_Y = new LinkedList<Integer>();

            //将起点加入队列
            queue_X.add(startX);
            queue_Y.add(startY);

            //起点访问标记，>= 1表示已经访问, == 0表示未访问，== -1表示为X无法访问
            exit[startX][startY] = 1;
            //如果队列非空，则一直循环
            while(!queue_X.isEmpty() && !queue_Y.isEmpty()) {
                //队首出队，得到当前位置做起点，不断向四周扩散
                startX = queue_X.remove();
                startY = queue_Y.remove();
                //总共有k种行走方案
                for (int i = 0; i < k; i++) {
                    //如果没有越界
                    if(startX + stepX[i] < x && startX + stepX[i] >= 0
                            && startY + stepY[i] < y && startY + stepY[i] >= 0) {
                        //如果没有被访问过
                        if(exit[startX + stepX[i]][startY + stepY[i]] == 0) {
                            if(dungeon[startX + stepX[i]][startY + stepY[i]] == '.') {
                                //记录到达该出口的步数为到达当前位置的步数+1
                                exit[startX + stepX[i]][startY + stepY[i]] = exit[startX][startY] + 1;
                                //并且将被访问的出口位置入队
                                queue_X.add(startX + stepX[i]);
                                queue_Y.add(startY + stepY[i]);
                            } else {
                                //如果不是'.',那么就是障碍，则设置为-1表示无法通行
                                exit[startX + stepX[i]][startY + stepY[i]] = -1;
                            }
                        }
                    }
                }
            }
            //记录距离最远的出口步数
            int max = 0;
            //记录是否存在无法到达的点，若存在则输出-1
            boolean flag = false;
            for (int i = 0; i < x; i++) {
                for (int j = 0; j < y; j++) {
                    //若存在某个出口无法被访问，则标记flag为true
                    if(dungeon[i][j] == '.' && exit[i][j] == 0) {
                        flag = true;
                    }
                    max = Math.max(max, exit[i][j]);
                }
            }
            if(flag) {
                System.out.println(-1);
            } else {
                //为了方便区分是否访问，初始记录起点步数为1，所以最终步长要-1
                System.out.println(max - 1);
            }

        }

    }
}
