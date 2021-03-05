import java.util.Arrays;

public class Q0322_CoinChange {
    public int coinChange(int[] coins, int amount) {
        //动态规划
        int[] dp = new int[amount + 1];
        Arrays.fill(dp, -1);
        dp[0] = 0;
        for (int i = 1; i <= amount; i++) {
            boolean flag = false;
            int cur = Integer.MAX_VALUE;
            for (int j = 0; j < coins.length; j++) {
                if (i - coins[j] >= 0 && dp[i - coins[j]] >= 0) {
                    flag = true;
                    cur = Math.min(cur, dp[i - coins[j]] + 1);
                }
            }

            if (flag) {
                dp[i] = cur;
            }
        }

        return dp[amount];
    }
}
