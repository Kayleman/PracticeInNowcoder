package algorithm.nowcoder_algorithm;

public class test6_2 {
    public int getLessIndex(int[] arr) {
        int len = arr.length;

        if(len == 0 || arr == null) {
            return -1;
        }
        if(len == 1 || arr[0] < arr[1]) {
            return 0;
        }
        if(arr[len - 1] < arr[len - 2]) {
            return len - 1;
        }
        int left = 1;
        int right = len - 2;
        int mid = 0;
        while (left < right) {
            mid = left + (right - left) / 2;
            if(arr[mid] > arr[mid - 1]) {
                right = mid - 1;
            } else if(arr[mid] > arr[mid + 1]) {
                left = mid + 1;
            } else {
                return mid;
            }
        }
        return left;
    }

    public static void main(String[] args) {
        int[] arr = {4, 2, 5, 7, 9, 8, 1, 6, 10};
        test6_2 t = new test6_2();
        System.out.println(t.getLessIndex(arr));
    }
}
