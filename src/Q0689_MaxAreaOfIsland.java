public class Q0689_MaxAreaOfIsland {
    public static int maxAreaOfIsland(int[][] grid) {
        //维护current(最近的岛的面积)和max(最大的面积)
        //对每一个岛，遍历它周围的岛，遍历过的部分标记为2
        int current = 0;
        int max = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == 1) {
                    current = areaOfIsland(grid, i, j);
                    max = Math.max(max,current);
                }
            }
        }
        return max;
    }

    public static int areaOfIsland(int[][] grid, int i, int j) {
        if (i < 0 || i >= grid.length || j < 0 || j >= grid[0].length
            || grid[i][j] != 1) {
            return 0;
        } else {
            grid[i][j] = 2;
            return 1 + areaOfIsland(grid, i + 1, j)
                    + areaOfIsland(grid, i - 1, j)
                    + areaOfIsland(grid, i, j + 1)
                    + areaOfIsland(grid, i, j - 1);
        }
    }
}
