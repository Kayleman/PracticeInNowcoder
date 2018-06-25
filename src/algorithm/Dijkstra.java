package algorithm;

public class Dijkstra {
    private static int M=200000;//无通路
    public static void main(String[] args) {
        //初始距离
        int [][]weight = {
                {0,767,M,698,M},
                {343,0,M,263,512},
                {342,348,0,M,123},
                {456,234,M,0,890},
                {534,567,546,M,0},
        };
        int start = 0;
        int[]shortPath = DijkstraPath(weight, start);
        for(int i = 0; i < shortPath.length; i++){
            System.out.println(start + "到" + i + "点的最短距离为：" + shortPath[i]);
        }
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

        for(int i = 0; i < n; i++){
            System.out.println(start + "到" + i + "的路径为：" + path[i]);
        }
        return shortPath;
    }
}

