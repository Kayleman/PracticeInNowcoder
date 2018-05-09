package sword_refers_to_offer;

/*
* 题目描述：
* 请设计一个函数，用来判断在一个矩阵中是否存在一条包含某字符串所有字符的路径。
* 路径可以从矩阵中的任意一个格子开始，每一步可以在矩阵中向左，向右，向上，向下移动一个格子。
* 如果一条路径经过了矩阵中的某一个格子，则该路径不能再进入该格子。
* 例如 a b c e s f c s a d e e 矩阵中(应该是三行四列)包含一条字符串"bcced"的路径，
* 但是矩阵中不包含"abcb"路径，因为字符串的第一个字符b占据了矩阵中的第一行第二个格子之后，路径不能再次进入该格子。
*
* 解题思路：
* 利用回溯的思想，首先起点可以是每一个字符，所以直接遍历整个字符数组
* i和j都是自己设置的，为了将原来的一维数组模拟成二维数组来方便理解。
* 新建一个visited的boolean数组来区别是否访问过
* DFS中的k表示匹配字符串中的第k个字符
* 如果遇到i或者j超过边界，或者当前字符不匹配，或者已经被访问过直接返回false
* 如果k直接等于str.length - 1说明全匹配上，直接返回true
* 否则继续下一步将visited设为true
* 继续向左右上下递归。只要一个成功就返回true
* 都失败了就退回，并且将visited还原为false
* */
public class HasPath {
    public boolean hasPath(char[] matrix, int rows, int cols, char[] str) {
        boolean[] visited = new boolean[matrix.length];
        //双层for循环是为了遍历每个字符作为起点的情况
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if(DFS(matrix, rows, cols, str, i, j, 0, visited)) {
                    return true;
                }
            }
        }
        return false;
    }

    public boolean DFS(char[] matrix, int rows, int cols, char[] str, int i, int j, int k, boolean[] visited) {
        //转化索引，将一维数组模拟成矩阵
        int index = i * cols + j;
        if(i < 0 || i >= rows || j < 0 || j >= cols
                || matrix[index] != str[k] || visited[index]) {
            return false;
        }

        if(k == str.length - 1) {
            return true;
        }
        visited[index] = true;
        if(DFS(matrix, rows, cols, str, i - 1, j, k + 1, visited)
                || DFS(matrix, rows, cols, str, i + 1, j, k + 1, visited)
                || DFS(matrix, rows, cols, str, i, j - 1, k + 1, visited)
                || DFS(matrix, rows, cols, str, i, j + 1, k + 1, visited)) {
            return true;
        }
        visited[index] = false;
        return false;
    }
}
