import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

public class Q0078_Subsets {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        if (nums == null || nums.length < 1) {
            return res;
        }

        dfs(nums, 0, new ArrayDeque<>(), res);
        return res;
    }

    /**
     *
     * @param nums 使用的数组
     * @param start 本次搜索开始的索引
     * @param current 本次搜索已经包含的元素
     * @param res 结果集
     */
    private static void dfs(int[] nums,
                            int start,
                            Deque<Integer> current,
                            List<List<Integer>> res) {
        if (start == nums.length) {
            res.add(new ArrayList<>(current));
            return;
        }

        current.add(nums[start]);
        dfs(nums, start + 1, current, res);
        current.removeLast();
        dfs(nums, start + 1, current, res);
    }
}
