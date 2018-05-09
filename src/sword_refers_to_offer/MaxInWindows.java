package sword_refers_to_offer;

import java.util.ArrayList;
import java.util.ArrayDeque;

/*
* 题目描述:
* 给定一个数组和滑动窗口的大小，找出所有滑动窗口里数值的最大值。
* 例如，如果输入数组{2,3,4,2,6,2,5,1}及滑动窗口的大小3，那么一共存在6个滑动窗口，
* 他们的最大值分别为{4,4,6,6,6,5}；
* 针对数组{2,3,4,2,6,2,5,1}的滑动窗口有以下6个：
* {[2,3,4],2,6,2,5,1}， {2,[3,4,2],6,2,5,1}，
* {2,3,[4,2,6],2,5,1}， {2,3,4,[2,6,2],5,1}，
* {2,3,4,2,[6,2,5],1}， {2,3,4,2,6,[2,5,1]}。
*
* 解题思路:
* 用一个双端队列，队列第一个位置保存当前窗口的最大值，当窗口滑动一次
* 1.判断当前最大值是否过期
* 2.新增加的值从队尾开始比较，把所有比他小的值丢掉
*
* 或者除暴一点可以写一个找最大值的函数，
* 然后每次判断当前最大值是否过期，过期了再调用函数，找新的最大值
* 比直接暴力每次都求最大值略微好一点
* */
public class MaxInWindows {
    public ArrayList<Integer> maxInWindows(int[] num, int size) {
        ArrayList<Integer> resList = new ArrayList<Integer>();
        int length = num.length;
        if(num == null || size == 0 || size > length) {
            return resList;
        }
        //begin表示窗口开始的下标，队列内存储的是值的下标
        int begin;
        ArrayDeque<Integer> deque = new ArrayDeque<Integer>();
        for (int i = 0; i < length; i++) {
            begin = i - size + 1;
            //如果队列是空，入队，队首存储当前窗口最大值
            if(deque.isEmpty()) {
                deque.addLast(i);
            } else if(begin > deque.peekFirst()) {
                //如果最大值已经过期，则出队
                deque.pollFirst();
            }
            //如果队列不空，把队列内小于入队的数的都出队。
            while (!deque.isEmpty() && num[deque.peekLast()] <= num[i]) {
                deque.pollLast();
            }
            deque.addLast(i);
            //因为最开始begin初值是-2，小于0的部分不添加进结果
            if(begin >= 0) {
                resList.add(num[deque.peekFirst()]);
            }
        }
        return resList;
    }
}
