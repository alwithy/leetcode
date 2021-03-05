public class Q0329_LongestIncreasingPath {
    int[] moveI = {1, -1, 0, 0};
    int[] moveJ = {0, 0, 1, -1};
    int m, n;

    public int longestIncreasingPath(int[][] matrix) {
        if (matrix == null || matrix.length == 0
                || matrix[0] == null || matrix[0].length == 0) {
            return 0;
        }
        m = matrix.length;
        n = matrix[0].length;
        int[][] map = new int[m][n];
        int res = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                res = Math.max(res, dfs(i, j, matrix, map));
            }
        }

        return res;
    }

    /**
     *
     * @param i
     * @param j
     * @param matrix
     * @param map 记录以matrix[i][j]为起点的最长递增路径的长度
     * @return
     */
    public int dfs(int i, int j, int[][] matrix, int[][] map) {
        if (map[i][j] != 0) {
            return map[i][j];
        }

        map[i][j] = 1;
        for (int k = 0; k < 4; k++) {
            int nextI = i + moveI[k];
            int nextJ = j + moveJ[k];

            if (canMove(nextI, nextJ) && matrix[i][j] < matrix[nextI][nextJ]) {
                map[i][j] = Math.max(map[i][j], 1 + dfs(nextI, nextJ, matrix, map));
            }
        }

        return map[i][j];
    }

    public boolean canMove(int i, int j) {
        return i >= 0 && i < m && j >= 0 && j < n;
    }
}
