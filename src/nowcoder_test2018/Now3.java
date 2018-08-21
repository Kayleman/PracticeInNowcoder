package nowcoder_test2018;

import java.util.Scanner;
public class Now3 {
    private static int M=200000;//无通路
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int M = sc.nextInt();
        int S = sc.nextInt();
        int T = sc.nextInt();
        int[][] map = new int[N][N];
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if(i == j) {
                    map[i][j] = 0;
                } else {
                    map[i][j] = 1001;
                }
            }
        }
        while(M != 0) {
            int start = sc.nextInt();
            int end = sc.nextInt();
            int value = sc.nextInt();
            map[start - 1][end - 1] = value;
            M--;
        }
        int[] shortPath = DijkstraPath(map, S - 1);
        int[] backPath = DijkstraPath(map, T - 1);
        System.out.println(shortPath[T - 1] + backPath[S - 1]);

//        int [][]weight = {
//                {0,3,M,},
//                {M,0,3,},
//                {1,M,0,},
//        };
//        int start = 0;
//        int end = 2;
//        int[] shortPath = DijkstraPath(weight, start);
//        int[] backPath = DijkstraPath(weight, end);
//        System.out.println(shortPath[2] + backPath[0]);

    }

    private static int[] DijkstraPath(int[][] weight, int start) {
        int n = weight.length;//顶点数量
        int []shortPath = new int[n];//最短路径
        String []path = new String[n];//路径
        boolean [] visited = new boolean[n];//是否求出
        //初始化
        for (int i = 0; i < n; i++) {
            visited[i] = false;
            path[i] = start + "-->" + i;
        }
        //设置初始点
        shortPath[start] = 0;
        visited[start] = true;
        //求其他点
        for(int num = 0; num < n-1; num++){
            //找出距离start最短距离的点k
            int k = -1;
            int dmin = Integer.MAX_VALUE;
            for(int i = 0; i < n; i++){
                //距离最小且没访问过
                if(visited[i]==false && weight[start][i]<dmin){
                    dmin = weight[start][i];
                    k = i;
                }
            }
            //循环结束 找出该点 并标记
            shortPath[k] = dmin;
            visited[k] = true;

            //赋值距离
            for(int i = 0; i < n; i++){
                //没有访问过且加入k点后距离小于直接
                if(visited[i]==false && weight[start][k] + weight[k][i] < weight[start][i]){
                    weight[start][i] = weight[start][k] + weight[k][i];
                    path[i] = path[k] + "-->" + i;
                }
            }
        }
        return shortPath;
    }
}
