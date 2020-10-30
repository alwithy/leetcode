public class Q0463_IslandPerimeter {
    static int[] helpR = {1, -1, 0, 0};
    static int[] helpC = {0, 0, 1, -1};

    public static int islandPerimeter(int[][] grid) {
        if (grid == null || grid.length == 0 || grid[0] == null || grid[0].length == 0) {
            return 0;
        }
        int rows = grid.length;
        int cols = grid[0].length;
        int row = 0, col = 0;
        out:
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (grid[i][j] == 1) {
                    row = i;
                    col = j;
                    break out;
                }
            }
        }

        return dfs(row, col, grid);
    }

    private static int dfs(int row, int col, int[][] grid) {
        grid[row][col] = -1;
        int res = 0;

        for (int i = 0; i < 4; i++) {
            int curRow = row + helpR[i];
            int curCol = col + helpC[i];
            if (isLegal(curRow, curCol, grid)) {
                if (grid[curRow][curCol] == 0) {
                    res++;
                } else if (grid[curRow][curCol] == 1) {
                    res += dfs(curRow, curCol, grid);
                }
            } else {
                res++;
            }
        }

        return res;
    }

    private static boolean isLegal(int row, int col, int[][] grid) {
        return row >= 0 && row < grid.length
                && col >= 0 && col < grid[0].length;
    }

    public static void main(String[] args) {
        int[][] grid = {
                {0,1,0,0},
                {1,1,1,0},
                {0,1,0,0},
                {1,1,0,0},
        };
        int[][] arr = {{0},{1}};
        System.out.println(islandPerimeter(arr));
    }
}
