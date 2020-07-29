public class Q0053_MaximumSubarray {
    public int maxSubArray(int[] nums) {
        // 动态规划,dp[i]表示以第i个元素结尾的子序列的最大和
        int[] dp = new int[nums.length + 1];
        dp[0] = 0;
        int res = Integer.MIN_VALUE;
        for (int i = 1; i < dp.length; i++) {
            dp[i] = Math.max(nums[i - 1], nums[i - 1] + dp[i - 1]);
            res = Math.max(res, dp[i]);
        }

        return res;
    }
}
