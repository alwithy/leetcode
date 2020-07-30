public class Q0198_HouseRobber {
    public int rob(int[] nums) {
        if (nums == null || nums.length == 0) return 0;
        if (nums.length == 1) return nums[0];
        if (nums.length == 2) return Math.max(nums[0], nums[1]);
        // 动态规划
        // dp[i - 2]
        int dp_iM2 = nums[0];
        // dp[i - 1]
        int dp_iM1 = Math.max(nums[0], nums[1]);
        // dp[i]
        int dp_i = 0;
        for (int i = 2; i < nums.length; i++) {
            dp_i = Math.max(nums[i] + dp_iM2, dp_iM1);
            dp_iM2 = dp_iM1;
            dp_iM1 = dp_i;
        }

        return dp_i;
    }
}
