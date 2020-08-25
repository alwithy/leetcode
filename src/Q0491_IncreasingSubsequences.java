import java.util.ArrayList;
import java.util.List;

public class Q0491_IncreasingSubsequences {
    public List<List<Integer>> findSubsequences(int[] nums) {
        // dfs加剪枝
        List<List<Integer>> res = new ArrayList<>();
        if (nums == null || nums.length == 0) return res;

        dfs(0, nums, new ArrayList<>(), res);
        return res;
    }

    private void dfs(int i, int[] nums, List<Integer> path, List<List<Integer>> res) {
        if (i == nums.length) {
            if (path.size() >= 2) {
                res.add(new ArrayList(path));
            }
            return;
        }

        if (path.size() > 0) {
            if (nums[i] == path.get(path.size() - 1)) {
                path.add(nums[i]);
                dfs(i + 1, nums, path, res);
                path.remove(path.size() - 1);
            } else {
                if (nums[i] > path.get(path.size() - 1)) {
                    path.add(nums[i]);
                    dfs(i + 1, nums, path, res);
                    path.remove(path.size() - 1);
                }
                dfs(i + 1, nums, path, res);
            }
        } else {
            path.add(nums[i]);
            dfs(i + 1, nums, path, res);
            path.remove(0);
            dfs(i + 1, nums, path, res);
        }
    }
}
