import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

public class Q0077_Combinations {
    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> res = new ArrayList<>();
        if (n < 1 || k < 1) return res;

        dfs(1, n, k, new LinkedList<>(), res);
        return res;
    }

    private void dfs(int num, int n, int k, Deque<Integer> path, List<List<Integer>> res) {
        if (path.size() == k) {
            res.add(new ArrayList<>(path));
            return;
        }

        for (int i = num; i <= n; i++) {
            path.add(i);
            dfs(i + 1, n, k, path, res);
            path.removeLast();
        }
    }
}
