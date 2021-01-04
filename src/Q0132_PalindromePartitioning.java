
public class Q0132_PalindromePartitioning {

    public int minCut(String s) {
        if (s == null || s.length() == 0) {
            return 0;
        }
        int len = s.length();
        //isPalindrome[i][j]表示s[i..j]是否是回文
        boolean[][] isPalindrome = new boolean[len][len];
        for (int i = len - 1; i >= 0; i--) {
            isPalindrome[i][i] = true;
            for (int j = i + 1; j < len; j++) {
                isPalindrome[i][j] = s.charAt(i) == s.charAt(j)
                        && (i + 1 == j || isPalindrome[i + 1][j - 1]);
            }
        }

        //dp[i]表示s[0..i]需要的最小刀数
        int[] dp = new int[len];
        for (int i = 0; i < len; i++) {
            dp[i] = Integer.MAX_VALUE;
            for (int j = 0; j <= i; j++) {
                if (isPalindrome[j][i]) {
                    dp[i] = Math.min(dp[i], j == 0 ? 0 : (1 + dp[j - 1]));
                }
            }
        }

        return dp[len - 1];
    }
}
