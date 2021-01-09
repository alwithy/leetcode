public class Q0174_DungeonGame {
    public static int calculateMinimumHP(int[][] dungeon) {
        if (dungeon == null || dungeon.length == 0
                || dungeon[0] == null || dungeon[0].length == 0) {
            return 1;
        }
        int m = dungeon.length;
        int n = dungeon[0].length;
        //dp[i][j]表示从d[i][j]走到终点的最低血量
        int[][] dp = new int[m + 1][n + 1];
        int max = Integer.MAX_VALUE;
        for (int i = 0; i < m; i++) {
            dp[i][n] = max;
        }
        for (int j = 0; j < n; j++) {
            dp[m][j] = max;
        }
        dp[m][n - 1] = 1;
        dp[m - 1][n] = 1;
        for (int i = m - 1; i >= 0; i--) {
            for (int j = n - 1; j >= 0; j--) {
                dp[i][j] = Math.max(1, Math.min(dp[i + 1][j], dp[i][j + 1]) - dungeon[i][j]);
            }
        }
        return dp[0][0];
    }

    public static void main(String[] args) {
        int[][] d = {
                {-2, -3, 3},
                {-5, -10, 1},
                {10, 30, -5}
        };
        System.out.println(calculateMinimumHP(d));
    }
}
