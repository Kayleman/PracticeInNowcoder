package sword_refers_to_offer;

/*
 * 题目描述:
 * 在一个二维数组中，每一行都按照从左到右递增的顺序排序，每一列都按照从上到下递增的顺序排序。
 * 请完成一个函数，输入这样的一个二维数组和一个整数，判断数组中是否含有该整数。
 * 
 * 解题思路:
 * 因为要考虑到数组中存在重复的数字，所以不能单纯地直接查找
 * 因为题目中给出的二维数组相对有序。
 * 根据题意可知，右上角的数字是本行最大且本列最小的，左下角的数字是本行最小且本列最大的。
 * 可以任选这两个之一开始遍历。以下是取右上角为起点。如果target小于数组的数，就向左找。大于就向下找。
 * 
 * */
public class ArrayFind {
	public boolean Find(int target, int [][] array) {
        int rowLength = array.length;
        int columnLength = array[0].length;
        //取右上角的数为起点
        int i = 0;
        int j = columnLength - 1;
        
        while(i < rowLength && j >= 0) {
            if(target == array[i][j]) {
                return true;
            } else if(target > array[i][j]) {
                i++;
            } else {
                j--;
            }
        }
        return false;
    }
}
