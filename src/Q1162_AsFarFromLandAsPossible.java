import java.util.*;

public class Q1162_AsFarFromLandAsPossible {
    static boolean[][] visited;
    static boolean[] help;
    static int[] nx = {-1, 1, 0, 0};
    static int[] ny = {0, 0, 1, -1};

    static class Coordinate {
        int x;
        int y;
        int step;
        public Coordinate(int x, int y, int step) {
            this.x = x;
            this.y = y;
            this.step = step;
        }
    }

    public int maxDistance(int[][] grid) {
        // 官方题解1，BFS
        visited = new boolean[grid.length][grid.length];
        help = new boolean[grid.length];
        int res = -1;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid.length; j++) {
                if (grid[i][j] == 0) {
                    res = Math.max(getNearestLand(grid, i, j), res);
                }
            }
        }

        return res;
    }

    private int getNearestLand(int[][] grid, int x, int y) {
        for (boolean[] a : visited) {
            Arrays.fill(a, false);
        }
        visited[x][y] = true;
        Deque<Coordinate> deque = new ArrayDeque<>();
        deque.add(new Coordinate(x, y, 0));
        Coordinate cur;
        int curX, curY;
        while (!deque.isEmpty()) {
            cur = deque.pollFirst();
            for (int i = 0; i < 4; i++) {
                curX = cur.x + nx[i];
                curY = cur.y + ny[i];
                if (!(curX >= 0 && curX < grid.length && curY >= 0 && curY < grid.length) || visited[curX][curY]) continue;
                if (grid[curX][curY] == 1) return cur.step + 1;
                deque.add(new Coordinate(curX, curY, cur.step + 1));
                visited[curX][curY] = true;
            }
        }

        return -1;
    }
}
