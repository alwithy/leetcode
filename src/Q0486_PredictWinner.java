public class Q0486_PredictWinner {
    public boolean PredictTheWinner(int[] nums) {
        if (nums == null || nums.length == 0) {
            return true;
        }
        int len = nums.length;
        //前缀和数组,preSum[i]表示nums[0..i - 1]之和
        int[] preSum = new int[len + 1];
        for (int i = 1; i < len + 1; i++) {
            preSum[i] = preSum[i - 1] + nums[i - 1];
        }
        //dp[i][j]表示数组剩下nums[i..j]时，当前玩家能拿到的最大分数
        int[][] dp = new int[len][len];
        for (int i = len - 1; i >= 0; i--) {
            dp[i][i] = nums[i];
            for (int j = i + 1; j < len; j++) {
                dp[i][j] = Math.max(nums[i] + preSum[j + 1] - preSum[i + 1] - dp[i + 1][j],
                        nums[j] + preSum[j] - preSum[i] - dp[i][j - 1]);
            }
        }

        return dp[0][len - 1] * 2 >= preSum[len];
    }
}
