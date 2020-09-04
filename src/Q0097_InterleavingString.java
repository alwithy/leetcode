public class Q0097_InterleavingString {
    public boolean isInterleave1(String s1, String s2, String s3) {
        if (s1 == null) return s2.equals(s3);
        if (s2 == null) return s1.equals(s3);
        if (s1.length() + s2.length() != s3.length()) return false;
        int len1 = s1.length();
        int len2 = s2.length();
        // dp[i][j]表示s1的前i个字符加s2前j个字符能否组成s3前i + j个字符
        boolean[][] dp = new boolean[len1 + 1][len2 + 1];
        dp[0][0] = true;
        for (int i = 0; i <= len1; i++) {
            for (int j = 0; j <= len2; j++) {
                if (i > 0) {
                    dp[i][j] = dp[i][j] || (dp[i - 1][j] && s1.charAt(i - 1) == s3.charAt(i + j - 1));
                }
                if (j > 0) {
                    dp[i][j] = dp[i][j] || (dp[i][j - 1] && s2.charAt(j - 1) == s3.charAt(i + j - 1));
                }
            }
        }

        return dp[len1][len2];
    }

    public boolean isInterleave(String s1, String s2, String s3) {
        if (s1 == null) return s2.equals(s3);
        if (s2 == null) return s1.equals(s3);
        if (s1.length() + s2.length() != s3.length()) return false;
        int len1 = s1.length();
        int len2 = s2.length();
        // dp[i][j]表示s1的前i个字符加s2前j个字符能否组成s3前i + j个字符
        // 滚动数组优化
        boolean[] dp = new boolean[len2 + 1];
        boolean[] last;
        dp[0] = true;
        for (int j = 1; j <= len2; j++) {
            dp[j] = dp[j - 1] && s2.charAt(j - 1) == s3.charAt(j - 1);
            if (!dp[j]) break;
        }

        for (int i = 1; i <= len1; i++) {
            last = dp;
            dp = new boolean[len2 + 1];
            for (int j = 0; j <= len2; j++) {
                dp[j] = dp[j] || (last[j] && s1.charAt(i - 1) == s3.charAt(i + j - 1));

                if (j > 0) {
                    dp[j] = dp[j] || (dp[j - 1] && s2.charAt(j - 1) == s3.charAt(i + j - 1));
                }
            }
        }

        return dp[len2];
    }
}
