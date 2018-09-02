package algorithm.nowcoder_algorithm;

public class test2_19 {
    public static int shortestSubsequence(int[] A, int n) {
        int leftIndex = 0;
        int max = A[0];
        int rightIndex = n - 1;
        int min = A[n - 1];
        for (int i = 1; i < n; i++) {
            if(max <= A[i]) {
                max = A[i];
            } else {
                leftIndex = i;
            }
        }

        for (int j = n - 2; j >= 0; j--) {
            if(min >= A[j]) {
                min = A[j];
            } else {
                rightIndex = j;
            }
        }

        int ans = Math.abs(leftIndex - rightIndex) + 1;
        return ans == n ? 0 : ans;

    }

    public static void main(String[] args) {
        int[] array = {1, 5, 4, 3, 2, 6, 7};
        int[] array2 = {1, 2, 3, 3, 8, 9};
        System.out.println(shortestSubsequence(array2, array2.length));
    }
}
