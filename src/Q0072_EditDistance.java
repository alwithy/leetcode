public class Q0072_EditDistance {
    public int minDistance(String word1, String word2) {
        // 官方题解，动态规划
        int n = word1.length();
        int m = word2.length();
        if (n * m == 0) return n + m;

        // dp[i][j]保存的是从word1前i个字符到word2前j个字符的最小距离
        int[][] dp = new int[n + 1][m + 1];
        // 初始化
        for (int i = 1; i < m + 1; i++) {
            dp[0][i] = i;
        }
        for (int i = 1; i < n + 1; i++) {
            dp[i][0] = i;
        }

        for (int i = 1; i < n + 1; i++) {
            for (int j = 1; j < m + 1; j++) {
                int cur = word1.charAt(i - 1) == word2.charAt(j - 1) ? 0 : 1;
                dp[i][j] = Math.min(dp[i - 1][j - 1] + cur,
                        Math.min(dp[i][j - 1] + 1, dp[i - 1][j] + 1));
            }
        }

        return dp[n][m];
    }
}
