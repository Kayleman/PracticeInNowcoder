package exam;

import java.util.ArrayList;
import java.util.List;
import java.util.TreeMap;

public class ZhongXing_1 {
    static List<Integer> findKCommonElements(int numCustomer, int numProduct,
                                      int numK, List<List<Integer>> productList) {
        TreeMap<Integer, Integer> hashMap = new TreeMap<>();
        for(List<Integer> tempList: productList) {
            for(Integer num: tempList) {
                if(hashMap.containsKey(num)) {
                    hashMap.put(num, hashMap.get(num) + 1);
                } else {
                    hashMap.put(num, 1);
                }
            }
        }
        List<Integer> ansList = new ArrayList<>();
        for (Integer key: hashMap.keySet()) {
            if(hashMap.get(key) >= numK) {
                ansList.add(key);
            }
        }
        return ansList;
    }

    public static void main(String[] args) {
        int numCus = 4;
        int numPro = 4;
        int numK = 3;

        List<List<Integer>> product = new ArrayList<>();
        List<Integer> temp1 = new ArrayList<>();
        List<Integer> temp2 = new ArrayList<>();
        List<Integer> temp3 = new ArrayList<>();
        List<Integer> temp4 = new ArrayList<>();
        temp1.add(1);
        temp1.add(2);
        temp1.add(3);
        temp1.add(2);

        temp2.add(2);
        temp2.add(3);
        temp2.add(4);
        temp2.add(8);

        temp3.add(8);
        temp3.add(3);
        temp3.add(11);
        temp3.add(12);

        temp4.add(2);
        temp4.add(3);
        temp4.add(6);
        temp4.add(8);
        product.add(temp1);
        product.add(temp2);
        product.add(temp3);
        product.add(temp4);




        List<Integer> list = findKCommonElements(numCus, numPro, numK, product);
        for (Integer num: list) {
            System.out.println(num);
        }
    }

}
