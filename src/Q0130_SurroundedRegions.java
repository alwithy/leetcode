import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public class Q0130_SurroundedRegions {
    static int[] moveI = {1, -1, 0, 0};
    static int[] moveJ = {0, 0, 1, -1};
    static int m, n;
    static int mod = 1000_000_000 + 7;
    static boolean[][] visited;

    public static void solve(char[][] board) {
        if (board == null || board.length == 0
                || board[0] == null || board[0].length == 0) {
            return;
        }
        m = board.length;
        n = board[0].length;
        visited = new boolean[m][n];

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (board[i][j] == 'O' && !visited[i][j]) {
                    List<int[]> path = new ArrayList<>();
                    if(dfs(i, j, board, path, new HashSet<>())) {
                        for (int[] point : path) {
                            board[point[0]][point[1]] = 'X';
                        }
                    }
                }
            }
        }
    }

    public static boolean dfs(int curI, int curJ, char[][] board, List<int[]> path, HashSet<Integer> set) {
        visited[curI][curJ] = true;
        set.add(curI * mod + curJ);
        path.add(new int[]{curI, curJ});
        boolean flag = true;
        for (int i = 0; i < 4; i++) {
            int nextI = curI + moveI[i];
            int nextJ = curJ + moveJ[i];
            if (set.contains(nextI * mod + nextJ)) {
                continue;
            }

            if (nextI >= 0 && nextI < m
                    && nextJ >= 0 && nextJ < n
                    && !visited[nextI][nextJ]) {
                flag = flag && (board[nextI][nextJ] == 'X'
                        || dfs(nextI, nextJ, board, path, set));
            } else {
                flag = false;
            }
        }

        return flag;
    }

    public static void main(String[] args) {
        char[][] board = {
                {'X', 'X', 'X', 'X'},
                {'X', 'O', 'O', 'X'},
                {'X', 'X', 'O', 'X'},
                {'X', 'O', 'X', 'X'}
        };
//        solve(board);
    }
}
