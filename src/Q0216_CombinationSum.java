import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

public class Q0216_CombinationSum {
    //k个数相加之和为n
    public List<List<Integer>> combinationSum3(int k, int n) {
        List<List<Integer>> res = new ArrayList<>();
        if (k > n || k > 9 || k < 1 || n > 45 ) {
            return res;
        }

        dfs(0, n, k, 1, new ArrayDeque<>(), res);

        return res;
    }

    /**
     *
     * @param sum path中所有元素和
     * @param target 目标和
     * @param length 组合长度
     * @param start 本次搜索的起点
     * @param path 已经包含的元素集合
     * @param res 结果集
     */
    private static void dfs(int sum,
                            int target,
                            int length,
                            int start,
                            Deque<Integer> path,
                            List<List<Integer>> res) {
        if (path.size() == length) {
            if (sum == target) {
                res.add(new ArrayList<>(path));
            }
            return;
        }

        for (int i = start; i <= 9; i++) {
            if (sum + i <= target && path.size() < length) {
                path.add(i);
                dfs(sum + i, target, length, i + 1,
                        path, res);
                path.removeLast();
            } else {
                break;
            }
        }

    }

}
