public class Q1143_LongestCommonSubsequence {
    public int longestCommonSubsequence(String word1, String word2) {
        // 动态规划解决
        // dp[i][j]表示从word1的前i位及word2的前j位的最长子序列
        // s1[i - 1] == s2[j - 1]: dp[i][j] = dp[i - 1][j - 1] + 1
        // s1[i - 1] != s2[j - 1]: dp[i][j] = max(dp[i - 1][j], dp[i][j - 1])
        // 优化为一维动态规划
        if (word1 == null || word1.length() == 0 || word2 == null || word2.length() == 0) {
            return 0;
        }
        int[]dp = new int[word2.length() + 1];
        int temp = 0;
        for (int i = 1; i <= word1.length(); i++) {
            int last = 0;
            for (int j = 1; j <= word2.length(); j++) {
                // temp保存dp[i - 1][j]
                temp = dp[j];
                if (word1.charAt(i - 1) == word2.charAt(j - 1)) {
                    //dp[i][j]  dp[i - 1][j - 1]
                    dp[j] = last + 1;
                } else {
                    //dp[i][j] = max(dp[i - 1][j], dp[i][j - 1])
                    dp[j] = Math.max(dp[j - 1], dp[j]);
                }
                last = temp;
            }
        }

        return dp[word2.length()];
    }
}
