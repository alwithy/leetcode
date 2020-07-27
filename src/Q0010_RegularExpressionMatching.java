public class Q0010_RegularExpressionMatching {
    public boolean isMatch(String s, String p) {
        // 官方题解，动态规划
        // dp[i][j]代表s的前i个字符和p的前j个字符是否匹配
        boolean[][] dp = new boolean[s.length() + 1][p.length() + 1];
        dp[0][0] = true;
        for (int j = 1; j < p.length() + 1; j++) {
            if (p.charAt(j - 1) == '*') {
                dp[0][j] = dp[0][j - 2];
            }
        }

        for (int i = 1; i < s.length() + 1; i++) {
            char sChar = s.charAt(i - 1);
            for (int j = 1; j < p.length() + 1; j++) {
                char pChar = p.charAt(j - 1);
                if (pChar == '*') {
                    dp[i][j] = dp[i][j - 2];
                    pChar = p.charAt(j - 2);
                    if (match(sChar, pChar)) {
                        dp[i][j] = dp[i][j] || dp[i - 1][j];
                    }
                } else {
                    if (match(sChar,pChar)) {
                        dp[i][j] = dp[i - 1][j - 1];
                    } else {
                        dp[i][j] = false;
                    }
                }
            }
        }

        return dp[s.length()][p.length()];
    }

    private boolean match(char a, char b) {
        return b == '.' || a == b;
    }
}
