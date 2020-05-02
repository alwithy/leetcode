import java.util.Arrays;

public class Q0063_UniquePaths {
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        if (obstacleGrid == null || obstacleGrid.length < 1
                || obstacleGrid[0].length < 1
                || obstacleGrid[0][0] == 1) {
            return 0;
        }
        int m = obstacleGrid.length;
        int n = obstacleGrid[0].length;
        int[] path = new int[n];
        for (int i = 0; i < n; i++) {
            if (obstacleGrid[0][i] == 0) {
                path[i] = 1;
            } else {
                break;
            }
        }
        for (int i = 1; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (obstacleGrid[i][j] == 1) {
                    path[j] = 0;
                } else {
                    if (j - 1 >= 0) {
                        path[j] += path[j - 1];
                    }
                }
            }
        }

        return path[n - 1];
    }
}
