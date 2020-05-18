public class Q0188_BestTimeToBuyAndSellStock {
    public int maxProfit(int k, int[] prices) {
        if (prices == null || prices.length < 2 || k < 1) {
            return 0;
        }
        // 123题和122题结合
        if (k > prices.length / 2) {
            return maxProfitWithInfinityK(prices);
        }

        int max_k = k;
        int[][][] dp = new int[prices.length][max_k + 1][2];
        // 穷举所有情况
        for (int i = 0; i < prices.length; i++) {
            for (k = max_k; k >= 1; k--) {
                if (i == 0) {
                    // 处理base case
                    dp[i][k][0] = 0; // 此句可省略
                    dp[i][k][1] = - prices[0];
                    continue;
                }

                // k表示还能进行交易的次数，在买入股票时扣除
                // dp[i][k][0] =
                // max(dp[i - 1][k][0], dp[i - 1][k][1] + prices[i])
                dp[i][k][0] = Math.max
                        (dp[i - 1][k][0], dp[i - 1][k][1] + prices[i]);

                // dp[i][k][1] =
                // max(dp[i - 1][k][1], dp[i - 1][k - 1][0] - prices[i])
                dp[i][k][1] = Math.max
                        (dp[i - 1][k][1], dp[i - 1][k - 1][0] - prices[i]);

            }
        }

        return dp[prices.length - 1][max_k][0];
    }

    private int maxProfitWithInfinityK(int[] prices) {
        if (prices == null || prices.length < 2) {
            return 0;
        }

        // 动态规划解决,dp[i:天数][k:交易次数][0:不持有股票 1:持有]
        // 此处k = infinity，所以可以忽略。 dp[i][0或1]
        // dp_i_0代表不持有股票
        int dp_i_0 = 0;
        // dp_i_1代表持有股票
        int dp_i_1 = - prices[0];
        for (int i = 1; i < prices.length; i++) {
            // dp[i][0] = max(dp[i - 1][0], dp[i - 1][1] + prices[i])
            dp_i_0 = Math.max(dp_i_0, dp_i_1 + prices[i]);
            // dp[i][1] = max(dp[i - 1][1], dp[i - 1][0] - prices[i])
            dp_i_1 = Math.max(dp_i_1, dp_i_0 - prices[i]);
        }

        return dp_i_0;
    }
}
