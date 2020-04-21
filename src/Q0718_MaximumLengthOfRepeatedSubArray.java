public class Q0718_MaximumLengthOfRepeatedSubArray {
    public int findLength(int[] A, int[] B) {
        //动态规划解决
        if (A.length == 0 || B.length == 0) {
            return 0;
        }
        int[][] dp = new int[A.length][B.length];
        int res = 0;
        //dp[i][j]表示A中i元素开始，B中j元素开始的最长公共数组
        for (int i = A.length - 1; i >= 0; i--) {
            for (int j = B.length - 1; j >= 0; j--) {
                if (A[i] == B[j]) {
                    if (i < A.length - 1 && j < B.length - 1) {
                        dp[i][j] = dp[i + 1][j + 1] + 1;
                    } else {
                        dp[i][j] = 1;
                    }
                    res = Math.max(dp[i][j], res);
                } else {
                    dp[i][j] = 0;
                }

            }
        }
        return res;
    }
}
