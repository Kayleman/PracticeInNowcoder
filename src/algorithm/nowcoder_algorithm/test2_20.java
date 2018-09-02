package algorithm.nowcoder_algorithm;

public class test2_20 {
    public static int maxGap(int[] A, int n) {
        int max = A[0];
        int min = A[0];
        for(int a:A) {
            max = Math.max(a, max);
            min = Math.min(a, min);
        }

        boolean[] hasNum = new boolean[n + 1];
        int[] bucketMax = new int[n + 1];
        int[] bucketMin = new int[n + 1];
        for (int i = 0; i < n; i++) {
            int bucket = bucketNum(A[i], max, min, n);
            bucketMax[bucket] = hasNum[bucket] ? Math.max(bucketMax[bucket], A[i]) : A[i];
            bucketMin[bucket] = hasNum[bucket] ? Math.min(bucketMin[bucket], A[i]) : A[i];
            hasNum[bucket] = true;
        }
        int i = 0;
        int ans = 0;
        int lastMax = 0;
        while (i <= n) {
            if(hasNum[i]) {
                lastMax = bucketMax[i];
                break;
            }
        }

        for(; i <= n; i++) {
            if(hasNum[i]) {
                ans = Math.max(bucketMin[i] - lastMax, ans);
                lastMax = bucketMax[i];
            }
        }

        return ans;
    }

    public static int bucketNum(long num, long max, long min, long len) {
        return (int)((num - min) * len / (max - min));
    }

    public static void main(String[] args) {
        int[] array = {1, 2, 3, 4, 7, 8, 9};
        System.out.println(maxGap(array, array.length));
    }
}
