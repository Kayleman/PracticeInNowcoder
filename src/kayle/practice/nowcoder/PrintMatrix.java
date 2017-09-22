package kayle.practice.nowcoder;

import java.util.ArrayList;

/*
 * 题目描述:
 * 输入一个矩阵，按照从外向里以顺时针的顺序依次打印出每一个数字，例如，如果输入如下矩阵： 
 * 1  2  3  4
 * 5  6  7  8
 * 9  10 11 12
 * 13 14 15 16 
 * 则依次打印出数字1,2,3,4,8,12,16,15,14,13,9,5,6,7,11,10.
 * */

public class PrintMatrix {
	public ArrayList<Integer> printMatrix(int [][] matrix) {
        int row = matrix.length;
        int column = matrix[0].length;
		ArrayList<Integer> array = new ArrayList<>();
		//记录4个游标的位置，分别为左右上下，一圈输出结束，游标就都向中心移动一格。
        int left = 0;
        int right = column - 1;
        int up = 0;
        int down = row - 1;
        //当游标没有越界的时候，持续执行
        while(left <= right && up <= down) {
        	//从左到右
        	for(int j = left; j <= right; j++) {
        		array.add(matrix[up][j]);
//        		System.out.print(matrix[up][j] + " ");
        	}
        	//从上第二个到下
        	for(int i = up + 1; i <= down; i++) {
        		array.add(matrix[i][right]);
//        		System.out.print(matrix[i][right] + " ");
        	}
        	//当上下游标不重合，说明还有行可以输出
        	if(up != down) {
        		//从右边第二个到左边
        		for(int j = right - 1; j >= left; j--) {
        			array.add(matrix[down][j]);
//        			System.out.print(matrix[down][j] + " ");
        		}
        	}
        	//当左右游标不重合，说明还有列可以输出
        	if(left != right) {
        		//从下面第二个到上面第二个（因为最上面一行已经输出了）
        		for(int i = down - 1; i >= up + 1; i--) {
        			array.add(matrix[i][left]);
//        			System.out.print(matrix[i][left] + " ");
        		}
        	}
        	//游标向中心移动
        	left++;
        	right--;
        	up++;
        	down--;
        }
		
        return array;
    }
	
//	public static void main(String[] args) {
//		PrintMatrix pm = new PrintMatrix();
//		int [][] matrix = {{1,2,3,4}, {5,6,7,8}, {9,10,11,12}};
//		ArrayList<Integer> array = pm.printMatrix(matrix);
//	}

}
