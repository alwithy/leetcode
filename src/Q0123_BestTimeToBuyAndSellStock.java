public class Q0123_BestTimeToBuyAndSellStock {
    public static int maxProfit(int[] prices) {
        if (prices == null || prices.length < 2) {
            return 0;
        }

        // 动态规划解决
        // dp[i:天数][k:至今最多进行的交易次数][0:不持有股票 1:持有]
        // 存在[k]中的状态是从k次交易的结果、k-1次交易的结果、k-2次交易的结果直到0次交易的结果中选出来的最优解，
        // 所以最后只用return dp[n-1][maxK][0]即可
        int max_k = 2;
        int[][][] dp = new int[prices.length][max_k + 1][2];

        // 穷举所有情况
        for (int i = 0; i < prices.length; i++) {
            for (int k = max_k; k >= 1; k--) {
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

    public static void main(String[] args) {
        int[] arr = {3,3,5,0,0,3,1,4};
        System.out.println(maxProfit(arr));
    }
}
