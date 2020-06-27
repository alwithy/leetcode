public class Q0115_DistinctSubsequences {
    public static int numDistinct(String s, String t) {
        if (s == null || s.length() < t.length()) return 0;
        // 动态规划解决
        // dp[i][j]代表t的前i个字符在s的前j个字符中出现的次数
        // t[i] == s[j] : dp[i][j] = dp[i - 1][j - 1] + dp[i][j - 1]
        // t[i] != s[j] : dp[i][j] = dp[i][j - 1]
        // 优化为一维动态规划，使用一个变量保存dp[i - 1][j - 1]
        int[] dp = new int[s.length() + 1];

        // 初始化
        for (int i = 1; i <= s.length(); i++) {
            dp[i] = t.charAt(0) == s.charAt(i - 1) ?
                    1 + dp[i - 1] : dp[i - 1];
        }

        int last;
        for (int i = 2; i <= t.length(); i++) {
            last = 0;
            for (int j = 1; j <= s.length(); j++) {
                int temp = dp[j];
                dp[j] = t.charAt(i - 1) == s.charAt(j - 1) ?
                        dp[j - 1] + last : dp[j - 1];
                last = temp;
            }
        }

        return dp[s.length()];
    }

    public static void main(String[] args) {
        System.out.println(numDistinct("eeee", "eeee"));
    }
}
