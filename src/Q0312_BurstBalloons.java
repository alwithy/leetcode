public class Q0312_BurstBalloons {
    public int maxCoins(int[] nums) {
        //动态规划
        int n = nums.length;
        int[] help = new int[n + 2];
        help[0] = 1;
        help[n + 1] = 1;
        for (int i = 0; i < n; i++) {
            help[i + 1] = nums[i];
        }
        //dp[i][j]表示打爆nums[i - 1..j - 1]的最大分数(此时其他区域气球均健在)
        int[][] dp = new int[n + 2][n + 2];
        for (int i = n; i >= 1; i--) {
            for (int j = i; j <= n; j++) {
                //最后打爆nums[i - 1]
                int finalI = help[i - 1] * help[i] * help[j + 1] + dp[i + 1][j];
                //最后打爆nums[j - 1]
                int finalJ = help[i - 1] * help[j] * help[j + 1] + dp[i][j - 1];
                dp[i][j] = Math.max(finalI, finalJ);
                //最后打爆中间的气球
                for (int k = i + 1; k < j; k++) {
                    int cur = help[i - 1] * help[k] * help[j + 1] + dp[i][k - 1] + dp[k + 1][j];
                    dp[i][j] = Math.max(cur, dp[i][j]);
                }
            }
        }

        return dp[1][n];
    }
}
