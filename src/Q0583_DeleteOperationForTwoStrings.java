public class Q0583_DeleteOperationForTwoStrings {
    public static int minDistance(String word1, String word2) {
        // 问题转化为求两字符串最长的相同子序列
        // 子序列可以删除原字符串的部分字母
        // 动态规划解决
        // dp[i][j]表示从word1的前i位及word2的前j位的最长子序列
        // s1[i - 1] == s2[j - 1]: dp[i][j] = dp[i - 1][j - 1] + 1
        // s1[i - 1] != s2[j - 1]: dp[i][j] = max(dp[i - 1][j], dp[i][j - 1])
        // 优化为一维动态规划
        if (word1 == null || word1.length() == 0) {
            return word2 == null ? 0 : word2.length();
        }
        if (word2 == null || word2.length() == 0) {
            return word1.length();
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

        return word1.length() + word2.length() - 2 * dp[word2.length()];
    }

    public static int minDistance1(String word1, String word2) {
        int l1 = word1.length(), l2 = word2.length();
        int[][] dp = new int[l1 + 1][l2 + 1];
        for (int i = 1; i <= l1; i++) {
            for (int j = 1; j <= l2; j++) {
                if(word1.charAt(i - 1) == word2.charAt(j - 1))
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                else dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
            }
        }
        return l1 + l2 - 2 * dp[l1][l2];
    }



    public static void main(String[] args) {
        String s1 = "intention";
        String s2 = "execution";
        //           012345678
        System.out.println(minDistance(s1,s2));
    }
}
