public class Q0121_BestTimeToBuyAndSellStock {
    public int maxProfit(int[] prices) {
        if (prices == null || prices.length < 2) {
            return 0;
        }

        // 动态规划解决,dp[i:天数][k:交易次数][0:不持有股票 1:持有]
        // 此处k = 1，所以可以忽略。 dp[i][0或1]
        // dp_i_0代表不持有股票
        int dp_i_0 = 0;
        // dp_i_1代表持有股票
        int dp_i_1 = - prices[0];
        for (int i = 1; i < prices.length; i++) {
            // dp[i][0] = max(dp[i - 1][0], dp[i - 1][1] + prices[i])
            dp_i_0 = Math.max(dp_i_0, dp_i_1 + prices[i]);
            // dp[i][1] = max(dp[i - 1][1], - prices[i])
            dp_i_1 = Math.max(dp_i_1, - prices[i]);
        }

        return dp_i_0;
    }
}
