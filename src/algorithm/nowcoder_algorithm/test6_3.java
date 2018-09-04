package algorithm.nowcoder_algorithm;

public class test6_3 {
    public int findPos(int[] arr, int n, int num) {
        // write code here
        if(arr == null || n == 0) {
            return -1;
        }
        int left = 0;
        int right = n - 1;
        int mid = 0;
        int res = -1;
        while (left <= right) {
            mid = left + (right - left) / 2;
            if(arr[mid] < num) {
                left = mid + 1;
            } else if(arr[mid] > num) {
                right = mid - 1;
            } else {
                res = mid;
                right = mid - 1;
            }
        }
        return res;
    }

    public static void main(String[] args) {
        int[] arr = {36,62,146,208,210,369,616};
        test6_3 t = new test6_3();
        System.out.println(t.findPos(arr, 7, 616));
    }
}
