public class Q0309_BestTimeToBuyAndSellStockWithCooldown {
    public int maxProfit(int[] prices) {
        if (prices == null || prices.length < 2) {
            return 0;
        }

        // 动态规划
        int dp_i_0 = 0;// 不持有
        int dp_i_1 = Integer.MIN_VALUE; // 持有
        int dp_pre_0 = 0; // 代表dp[i - 2][0]

        for (int i = 0; i < prices.length; i++) {
            int temp = dp_i_0;
            dp_i_0 = Math.max(dp_i_0, dp_i_1 + prices[i]);
            dp_i_1 = Math.max(dp_i_1, dp_pre_0 - prices[i]);
            dp_pre_0 = temp;
        }

        return dp_i_0;
    }
}
