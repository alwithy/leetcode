public class Q0087_ScrambleString {
    public boolean isScramble(String s1, String s2) {
        if (s1.length() != s2.length()) return false;
        char[] chs1 = s1.toCharArray();
        char[] chs2 = s2.toCharArray();
        int len = s1.length();
        boolean[][][] dp = new boolean[len][len][len + 1];
        // dp[i][j][k]代表s1[i]开始的长度为k的字符串是否能变为s2[j]开始的字符串


        for (int i = len - 1; i >= 0; i--) {
            for (int j = len - 1; j >= 0; j--) {
                // 边界条件
                dp[i][j][1] = chs1[i] == chs2[j];
                for (int k = 2; k <= Math.min(len - i, len - j); k++) {
                    for (int l = 1; l < k; l++) {
                        dp[i][j][k] = dp[i][j][k]
                                || (dp[i][j][l] && dp[i + l][j + l][k - l])
                                || (dp[i][j + k - l][l] && dp[i + l][j][k - l]);
                    }
                }
            }
        }

        return dp[0][0][len];
    }
}
