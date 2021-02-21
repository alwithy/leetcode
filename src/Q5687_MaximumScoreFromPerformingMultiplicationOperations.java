public class Q5687_MaximumScoreFromPerformingMultiplicationOperations {
    //超内存
    public static int maximumScore1(int[] nums, int[] multipliers) {
        int n = nums.length;
        int m = multipliers.length;
        //dp[L][R][k]表示从nums[L..R]中选出k个数字，依次乘以multi[m - k..m - 1]的最大分数
        int[][][] dp = new int[n][n][m + 1];
        for (int k = 1; k <= m; k++) {
            for (int L = n - k; L >= 0; L--) {
                for (int R = L + k - 1; R < n; R++) {
                    int chooseL = nums[L] * multipliers[m - k];
                    if (L + 1 < n) {
                        chooseL += dp[L + 1][R][k - 1];
                    }

                    int chooseR = nums[R] * multipliers[m - k];
                    if (R - 1 >= 0) {
                        chooseR += dp[L][R - 1][k - 1];
                    }

                    dp[L][R][k] = Math.max(chooseL, chooseR);
                }
            }
        }

        return dp[0][n - 1][m];
    }

    //通过
    public static int maximumScore(int[] nums, int[] multipliers) {
        int n = nums.length;
        int m = multipliers.length;
        //dp[i][j]表示左边选i个，右边选j个数字的最大值
        int[][] dp = new int[m + 1][m + 1];
        //dp[i][j] = max: 1. dp[i - 1][j] + nums[i - 1] * multi[i + j - 1]
        //                2. dp[i][j - 1] + nums[n - j] * multi[i + j - 1]

        //边界条件，只选左边
        for (int i = 1; i <= m; i++) {
            dp[i][0] = dp[i - 1][0] + nums[i - 1] * multipliers[i - 1];
        }
        //只选右边
        for (int j = 1; j <= m; j++) {
            dp[0][j] = dp[0][j - 1] + nums[n - j] * multipliers[j - 1];
        }
        int res = Math.max(dp[0][m], dp[m][0]);
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j + i <= m; j++) {
                int chooseL = dp[i - 1][j] + nums[i - 1] * multipliers[i + j - 1];
                int chooseR = dp[i][j - 1] + nums[n - j] * multipliers[i + j - 1];
                dp[i][j] = Math.max(chooseL, chooseR);
                if (i + j == m) {
                    res = Math.max(res, dp[i][j]);
                }
            }
        }

        return res;
    }

    public static void main(String[] args) {
        int[] nums = {1,2,3};
        int[] multi = {3,2,1};
        System.out.println(maximumScore(nums, multi));
    }
}
