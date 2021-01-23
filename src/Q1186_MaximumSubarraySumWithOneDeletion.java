public class Q1186_MaximumSubarraySumWithOneDeletion {
    public int maximumSum(int[] arr) {
        //动态规划
        int n = arr.length;
        //dp[i][0]表示以arr[i - 1]为结尾并且未删除元素的子数组最大和
        //dp[i][1]表示以arr[i - 1]为结尾并且已删除元素的子数组最大和
        int[][] dp = new int[n + 1][2];
        int res = arr[0];
        //base case
        dp[1][0] = arr[0];
        for (int i = 2; i < n + 1; i++) {
            dp[i][0] = Math.max(dp[i - 1][0], 0) + arr[i - 1];
            dp[i][1] = Math.max(dp[i - 1][1] + arr[i - 1], dp[i - 1][0]);
            res = Math.max(res, dp[i][0]);
            res = Math.max(res, dp[i][1]);
        }

        return res;
    }
}
