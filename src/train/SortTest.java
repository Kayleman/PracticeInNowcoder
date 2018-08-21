package train;

import java.util.Arrays;

public class SortTest {
    public static void bubbleSort(int[] array) {
        for(int i = array.length - 1; i >= 0; i--) {
            for(int j = 0; j + 1 <= i; j++) {
                if(array[j] > array[j + 1]) {
                    int temp = array[j];
                    array[j] = array[j + 1];
                    array[j + 1] = temp;
                    System.out.println(Arrays.toString(array));
                }
            }
        }
    }

    public static void insertSort(int[] array) {
        for(int i = 1; i < array.length; i++) {
            int current = array[i];
            int j = i - 1;
            for(; j >= 0 && array[j] > current; j--) {
                array[j + 1] = array[j];
            }
            array[j + 1] = current;
            System.out.println(Arrays.toString(array));
        }
    }

    public static void binaryInsertSort(int[] array) {
        for(int i = 1; i < array.length; i++) {
            int temp = array[i];
            int left = 0;
            int right = i - 1;
            int mid = 0;
            while (left <= right) {
                mid = (left + right) / 2;
                if(temp < array[mid]) {
                    right = mid - 1;
                } else {
                    left = mid + 1;
                }
            }
            if(i != left) {
                for (int j = i; j > left; j--) {
                    array[j] = array[j - 1];
                }
                array[left] = temp;
                System.out.println(Arrays.toString(array));
            }

        }
    }



    public static void main(String[] args) {
        int[] array = {3, 1, 5, 1, 3, 8, 1, 3, 0};
        int[] array2 = {2, 5, 4, 1, 3, 9, 7, 8, 6};
        binaryInsertSort(array2);
    }
}
