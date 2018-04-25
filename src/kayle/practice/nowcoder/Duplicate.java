package practice.nowcoder;
/*
* 题目描述:
* 在一个长度为n的数组里的所有数字都在0到n-1的范围内。
* 数组中某些数字是重复的，但不知道有几个数字是重复的。
* 也不知道每个数字重复几次。请找出数组中任意一个重复的数字。
* 例如，如果输入长度为7的数组{2,3,1,0,2,5,3}，那么对应的输出是第一个重复的数字2。
*
* 解题思路:
* 直接想到的就是暴力解，双层循环，竟然没超时直接通过了。
* 还有一种是可以类似于hash的方法，给出现过的做标记flag初始化0，
* 出现后++或者直接设为某个数，一旦下次遇到同个数，flag不为0，则赋值duplication[0]，return true
* */


public class Duplicate {
    // Parameters:
    //    numbers:     an array of integers
    //    length:      the length of array numbers
    //    duplication: (Output) the duplicated number in the array number,length of duplication array is 1,so using duplication[0] = ? in implementation;
    //                  Here duplication like pointor in C/C++, duplication[0] equal *duplication in C/C++
    //    这里要特别注意~返回任意重复的一个，赋值duplication[0]
    // Return value:       true if the input is valid, and there are some duplications in the array number
    //                     otherwise false
    public boolean duplicate(int numbers[],int length,int [] duplication) {
        for (int i = 0; i < length; i++) {
            for (int j = i + 1; j < length; j++) {
                if(numbers[i] == numbers[j]) {
                    duplication[0] = numbers[i];
                    return true;
                }
            }
        }
        return false;
    }


    public boolean duplicate_2(int numbers[],int length,int [] duplication) {
        int[] flag = new int[length];
        for (int i = 0; i < length; i++) {
            if(flag[numbers[i]] == 0) {
                flag[numbers[i]]++;
            } else {
                duplication[0] = numbers[i];
                return true;
            }
        }
        return false;
    }



    public static void main(String[] args) {
        Duplicate d = new Duplicate();
        int[] numbers = {2,3,1,0,2,5,3};
        int[] duplication = {-1};
        System.out.println(d.duplicate(numbers, 7, duplication));
    }
}
