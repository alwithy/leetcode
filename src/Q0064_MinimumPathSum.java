public class Q0064_MinimumPathSum {
    public static int minPathSum(int[][] grid) {
        if (grid == null || grid.length < 1
        || grid[0] == null || grid[0].length < 1) {
            return 0;
        }
        int m = grid.length;
        int n = grid[0].length;
        int[] path = new int[n];
        path[0] = grid[0][0];
        for (int i = 1; i < n; i++) {
            path[i] = grid[0][i] + path[i - 1];
        }

        for (int i = 1; i < m; i++) {
            path[0] += grid[i][0];
            for (int j = 1; j < n; j++) {
                path[i] = grid[i][j] + Math.min(path[j - 1], path[j]);
            }
        }

        return path[n - 1];
    }

    public static void main(String[] args) {
        int[][] grid = {
                {1,2,5},
                {3,2,1},
        };
        System.out.println(minPathSum(grid));
    }
}
