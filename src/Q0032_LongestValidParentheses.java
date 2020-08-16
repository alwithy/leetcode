public class Q0032_LongestValidParentheses {
    public int longestValidParentheses(String s) {
        int res = 0;
        if (s == null || s.length() < 1) return res;
        // 官方题解1，动态规划,dp[i]为以i结尾的有效括号长度
        int[] dp = new int[s.length()];
        for (int i = 1; i < s.length(); i++) {
            if (s.charAt(i) == ')') {
                if (s.charAt(i - 1) == '(') {
                    dp[i] = 2;
                    if (i - 2 >= 0) dp[i] += dp[i - 2];
                } else if (i - 1 - dp[i - 1] >= 0
                        && s.charAt(i - 1 - dp[i - 1]) == '('
                        && dp[i - 1] > 0) {
                    dp[i] = dp[i - 1] + 2;
                    if (i - 2 - dp[i - 1] >= 0) dp[i] += dp[i - 2 - dp[i - 1]];
                }
                res = Math.max(res, dp[i]);
            }
        }

        return res;
    }
}
