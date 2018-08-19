package algorithm.nowcoder_algorithm;

import java.util.Arrays;

public class test2_2 {
    public static void bubbleSort(int[] array, int n) {
        for (int i = array.length - 1; i >= 0 ; i--) {
            for (int j = 0; j < i; j++) {
                if(array[j] > array[j + 1]) {
                    int temp = array[j];
                    array[j] = array[j + 1];
                    array[j + 1] = temp;
                }
            }
        }
    }

    public static void main(String[] args) {
        int[] array = {1, 2, 3, 5, 2, 3};
        bubbleSort(array, array.length);
        System.out.println(Arrays.toString(array));
    }
}
