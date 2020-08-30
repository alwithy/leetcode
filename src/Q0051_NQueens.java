import java.util.ArrayList;
import java.util.List;

public class Q0051_NQueens {
    boolean[] cols;
    boolean[] hills;// 左下到右上的对角线
    boolean[] dales;// 左上到右下的对角线
    boolean[][] map;
    List<List<String>> res;
    int n;

    // 回溯法
    public List<List<String>> solveNQueens(int n) {
        cols = new boolean[n];
        hills = new boolean[2 * n - 1];
        dales = new boolean[2 * n - 1];
        map = new boolean[n][n];
        res = new ArrayList<>();
        this.n = n;

        backtrace(0);

        return res;
    }

    private void backtrace(int i) {
        if (i == n) {
            addSolution();
            return;
        }

        for (int j = 0; j < n; j++) {
            if (canPlace(i, j)) {
                place(i, j);
                backtrace(i + 1);
                remove(i, j);
            }
        }
    }

    private void addSolution() {

        List<String> sol = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            StringBuilder cur = new StringBuilder();
            for (int j = 0; j < n; j++) {
                if (map[i][j]) {
                    cur.append("Q");
                } else {
                    cur.append(".");
                }
            }
            sol.add(cur.toString());
        }
        res.add(sol);
    }

    private boolean canPlace(int i, int j) {
        return !cols[j] && !hills[i + j] && !dales[i - j + n - 1];
    }

    private void place(int i, int j) {
        cols[j] = true;
        hills[i + j] = true;
        dales[i - j + n - 1] = true;
        map[i][j] = true;
    }

    private void remove(int i, int j) {
        cols[j] = false;
        hills[i + j] = false;
        dales[i - j + n - 1] = false;
        map[i][j] = false;
    }

    public static void main(String[] args) {
        Q0051_NQueens t = new Q0051_NQueens();
        t.solveNQueens(4);
    }
}
