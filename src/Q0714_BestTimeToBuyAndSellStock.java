public class Q0714_BestTimeToBuyAndSellStock {
    public int maxProfit(int[] prices, int fee) {
        //动态规划解决问题，参见官方题解
        int cash = 0;
        int hold = -prices[0];
        for (int i = 1; i < prices.length; i++) {
            cash = Math.max(cash, hold + prices[i] - fee);
            hold = Math.max(hold, cash - prices[i]);
        }
        return cash;
    }
}
