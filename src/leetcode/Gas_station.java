package leetcode;

/**
* 题目：
* There are N gas stations along a circular route, where the amount of gas at station i isgas[i].
* You have a car with an unlimited gas tank and it costscost[i]of gas to travel from station i to its next station (i+1).
* You begin the journey with an empty tank at one of the gas stations.
* Return the starting gas station's index if you can travel around the circuit once,
* otherwise return -1.
*
* Note:
* The solution is guaranteed to be unique.
*
* 解题思路：
* 1.暴力法，直接把每一个都作为起点遍历一次，遇到加完油还走不到下一站的情况，就break进行下个循环
*   index用来判断是否走完一圈
* 2.从start出发， 如果油量足够， 可以一直向后走 end++；  油量不够的时候，
*   start向后退  最终 start == end的时候，如果有解一定是当前 start所在位置
* */
public class Gas_station {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        //从start出发， 如果油量足够， 可以一直向后走 end++；  油量不够的时候，
        //start向后退  最终 start == end的时候，如果有解一定是当前 start所在位置
        int start = gas.length - 1;
        int end = 0;
        int current_gas = gas[start] - cost[start];
        while (start > end) {
            if (current_gas >= 0) {
                current_gas += gas[end] - cost[end];
                end++;
            } else {
                start--;
                current_gas += gas[start] - cost[start];
            }
        }
        return current_gas >= 0 ? start : -1;
    }
    //暴力法，直接把每一个都作为起点遍历一次
//    public int canCompleteCircuit(int[] gas, int[] cost) {
//        int n = gas.length;
//        for (int start = 0; start < n; start++) {
//            int[] current_gas = new int[n];
//            boolean flag = false;
//            current_gas[start] = 0;
//            int index = start;
//            for (int i = 0; i < n; i++) {
//                //如果油量够到下一站，就修改下一站当前油量，index++
//                if (current_gas[index % n] + gas[index % n] >= cost[index % n]) {
//                    current_gas[(index + 1) % n] = current_gas[index % n] + gas[index % n] - cost[index % n];
//                    index++;
//                } else {
//                    break;
//                }
//                //index如果和start相等，说明循环完成一圈，找到解
//                if(index % n == start) {
//                    flag = true;
//                }
//            }
//            if(flag) {
//                return start;
//            }
//        }
//        return -1;
//    }

    public static void main(String[] args) {
        Gas_station gs = new Gas_station();
        int[] gas = {2, 4};
        int[] cost = {3, 4};
        System.out.println(gs.canCompleteCircuit(gas, cost));
    }
}
