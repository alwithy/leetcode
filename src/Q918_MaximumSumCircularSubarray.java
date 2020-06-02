public class Q918_MaximumSumCircularSubarray {
    public static int maxSubarraySumCircular(int[] A) {
        int res = 0;
        if (A == null || A.length == 0) {
            return res;
        }

        // 官方题解1
        res = A[0];
        int cur = A[0];
        for (int i = 1; i < A.length; i++) {
            cur = A[i] + Math.max(cur, 0);
            res = Math.max(cur, res);
        }

        int[] rightSum = new int[A.length];
        rightSum[A.length - 1] = A[A.length - 1];
        for (int i = A.length - 2; i >= 0; i--) {
            rightSum[i] = A[i] + rightSum[i + 1];
        }

        int[] rightMax = new int[A.length];
        rightMax[A.length - 1] = A[A.length - 1];
        for (int i = A.length - 2; i >= 0; i--) {
            rightMax[i] = Math.max(rightMax[i + 1], rightSum[i]);
        }

        int leftSum = 0;
        for (int i = 0; i < A.length - 2; i++) {
            leftSum += A[i];
            res = Math.max(res, leftSum + rightMax[i + 2]);
        }

        return res;
    }

    public static void main(String[] args) {
        int[] arr = {5,-3,5};
        System.out.println(maxSubarraySumCircular(arr));
    }
}
