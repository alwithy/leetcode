public class Q0279_PerfectSquares {
    public static int numSquares(int n) {
        //动态规划
        //dp[i]表示需要dp[i]个完全平方数组成数字i
        int[] dp = new int[n + 1];
        for (int i = 1; i * i <= n; i++) {
            dp[i * i] = 1;
        }

        for (int i = 2; i < n + 1; i++) {
            if (dp[i] == 1) {
                continue;
            }

            dp[i] = Integer.MAX_VALUE;
            int sqrt = (int) Math.sqrt(i);
            for (int j = i - 1; j >= sqrt; j--) {
                dp[i] = Math.min(dp[i], dp[j] + dp[i - j]);
            }
        }

        return dp[n];
    }

    public static void main(String[] args) {
        int n = 12;
        System.out.println(numSquares(n));
    }
}
