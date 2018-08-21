package algorithm.nowcoder_algorithm;

import java.util.ArrayList;
import java.util.Arrays;

public class test2_11 {
    public static int[] radixSort(int[] A, int n) {
        int maxBit = 0;
        for(int a:A) {
            int Bit = (int)Math.log10(a);
            maxBit = maxBit < Bit ? Bit : maxBit;
        }

        ArrayList<ArrayList<Integer>> list = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            ArrayList<Integer> temp = new ArrayList<>();
            list.add(temp);
        }

        for (int i = 0; i <= maxBit; i++) {
            int div = (int)Math.pow(10, i);
            for(int a:A) {
                int index = a / div % 10;
                list.get(index).add(a);
            }
            int count = 0;
            for (ArrayList<Integer> tempList : list) {
                for (Integer num : tempList) {
                    A[count++] = num;
                }
                tempList.clear();
            }
            System.out.println(Arrays.toString(A));
        }
        return A;

    }
    public static void main(String[] args) {
        int[] array = {1, 2, 3, 5, 2, 3};
        int[] array2 = {54,35,48,36,27,12,44,44,8,14,26,17,28};
        int[] ans = radixSort(array2, array2.length);
        System.out.println(Arrays.toString(ans));
    }
}
