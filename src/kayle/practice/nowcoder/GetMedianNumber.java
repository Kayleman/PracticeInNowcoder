package kayle.practice.nowcoder;
import java.util.ArrayList;
import java.util.Collections;

/*
* 题目描述:
* 如何得到一个数据流中的中位数？如果从数据流中读出奇数个数值，那么中位数就是所有数值排序之后位于中间的数值。
* 如果从数据流中读出偶数个数值，那么中位数就是所有数值排序之后中间两个数的平均值。
*
* 解题思路:
* 1.使用ArrayList来记录数字，并且排序后，
* 总数为奇数，则取中间的数，否则取中间的数和前一个数的均值
*
* 2.利用堆排序的方法，建立两个堆，大顶堆和小顶堆
* Java的PriorityQueue 是从JDK1.5开始提供的新的数据结构接口，默认内部是自然排序，结果为小顶堆，也可以自定义排序器，比如下面反转比较，完成大顶堆。
* 思路：
* 为了保证插入新数据和取中位数的时间效率都高效，这里使用大顶堆+小顶堆的容器，并且满足：
* 1、两个堆中的数据数目差不能超过1，这样可以使中位数只会出现在两个堆的交接处；
* 2、大顶堆的所有数据都小于小顶堆，这样就满足了排序要求。

* */
public class GetMedianNumber {
    ArrayList<Integer> intList = new ArrayList<Integer>();
    public void Insert(Integer num) {
        intList.add(num);
    }

    public Double GetMedian() {
        int length = intList.size();
        int mid = length / 2;
        Collections.sort(intList);
        if((length & 1) == 0) {
            return (intList.get(mid) + intList.get(mid - 1)) / 2.0;
        } else {
            return Double.valueOf(intList.get(mid));
        }
    }

}



//import java.util.Comparator;
//import java.util.PriorityQueue;
//         
//public class Solution {
//    int count;
//    PriorityQueue<Integer> minHeap = new PriorityQueue<Integer>();
//    PriorityQueue<Integer> maxHeap = new PriorityQueue<Integer>(11, new Comparator<Integer>() {
//        @Override
//        public int compare(Integer o1, Integer o2) {
//            //PriorityQueue默认是小顶堆，实现大顶堆，需要反转默认排序器
//            return o2.compareTo(o1);
//        }
//    });
// 
//    public void Insert(Integer num) {
//    count++;
//    if (count & 1) == 0) { // 判断偶数的高效写法
//            if (!maxHeap.isEmpty() && num < maxHeap.peek()) {
//                maxHeap.offer(num);
//                num = maxHeap.poll();
//            }
//            minHeap.offer(num);
//        } else {
//            if (!minHeap.isEmpty() && num > minHeap.peek()) {
//                minHeap.offer(num);
//                num = minHeap.poll();
//            }
//            maxHeap.offer(num);
//        }
//    }
// 
//    public Double GetMedian() {   
//        if(count==0)
//            throw new RuntimeException("no available number!");
//        double result;
//       //总数为奇数时，大顶堆堆顶就是中位数
//       if((count&1)==1)
//            result=maxHeap.peek();
//        else
//            result=(minHeap.peek()+maxHeap.peek())/2.0;
//        return result;
//    }
//}




////大佬手写实现的堆类，可直接设置最大堆最小堆
//class Heap {
//    public List<Integer> list = null;
//    public static final boolean isMaxHeap = true;
//    public static final boolean isMinHeap = false;
//    private boolean flag = true;  //true表示最大堆，false表示最小堆
//                public Heap(){
//        this.list = new ArrayList<Integer>();
//    }
//    public Heap(boolean flag){
//        this.list = new ArrayList<Integer>();
//        this.flag = flag;
//    }
//    //获取堆大小
//            public int size(){
//        return this.list.size();
//    }
//    //获取堆顶元素
//            public int peek(){
//        if(list.size() == 0) return 0;
//        return list.get(0);
//    }
//    //插入元素，从插入点开始向上调整堆
//            public void add(int val){
//        this.list.add(val);
//        int i = list.size() - 1, index, parent, cur;
//        while(i > 0){
//            index = (i - 1) / 2;
//            parent = list.get(index);
//            cur = list.get(i);
//            if(flag == true && parent < cur){
//                swap(index, i);
//            }else if(flag == false && parent > cur){
//                swap(index, i);
//            }
//            i = index;
//        }
//    }
//    /**
//      * 将堆顶元素取出,并重新调整堆。
//      * 1>取出堆顶元素
//      * 2>将最后一个元素放到堆顶
//      * 3>向下调整堆
//      */
//            public int pop(){
//        if(list.size() == 0) return -1;
//        int res = list.get(0);
//        list.set(0,list.get(list.size() - 1));
//        list.remove(list.size()-1);
//        int len = list.size() - 1 , i = 0;
//        int left , right;
//        while(i < len){
//            left = (i << 1) + 1;
//            right= (i << 1) + 2;
//            int maxIndex = i;
//            if(flag == true){
//                if(left < len && list.get(left) > list.get(maxIndex)) maxIndex = left;
//                if(right< len && list.get(right)> list.get(maxIndex)) maxIndex = right;
//            }else{
//                if(left < len && list.get(left) < list.get(maxIndex)) maxIndex = left;
//                if(right< len && list.get(right)< list.get(maxIndex)) maxIndex = right;
//            }
//            if(maxIndex != i){
//                swap(maxIndex,i);
//                i = maxIndex;
//            }else break;
//        }
//        return res;
//    }
//    //交换list中两个位置的元素
//            public void swap(int i, int j){
//        int temp = list.get(i);
//        list.set(i, list.get(j));
//        list.set(j,temp);
//    }
//}