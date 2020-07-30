import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

public class Q0046_Permutations {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        if (nums == null || nums.length == 0) return res;
        // dfs,每次挑选一个数字,用boolean数组记录是否被挑选过
        boolean[] choosed = new boolean[nums.length];
        dfs(new LinkedList<>(), nums, choosed, res);

        return res;
    }

    private void dfs(Deque<Integer> path, int[] nums, boolean[] choosed, List<List<Integer>> res) {
        if (path.size() == nums.length) {
            List<Integer> temp = new ArrayList<>(path);
            res.add(temp);
            return;
        }

        for (int i = 0; i < nums.length; i++) {
            if (!choosed[i]) {
                path.add(nums[i]);
                choosed[i] = true;
                dfs(path, nums, choosed, res);
                path.pollLast();
                choosed[i] = false;
            }
        }
    }
}
