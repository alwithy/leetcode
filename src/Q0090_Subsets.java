import java.util.*;

public class Q0090_Subsets {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        res.add(new ArrayList<>());
        if (nums == null || nums.length == 0) {
            return res;
        }

        Arrays.sort(nums);
        for (int i = 1; i < nums.length + 1; i++) {
            backtrack(nums, 0, i, new ArrayDeque<>(), res);
        }

        return res;
    }

    /**
     *
     * @param nums
     * @param start 本次回溯的起点
     * @param length 本次回溯想要找到的子集的长度
     * @param cur 本次回溯已经找到的元素集合
     * @param res 结果集
     */
    private void backtrack(int[] nums,
                           int start,
                           int length,
                           Deque<Integer> cur,
                           List<List<Integer>> res) {
        if (cur.size() == length) {
            res.add(new ArrayList<>(cur));
            return;
        }

        for (int i = start; i < nums.length; i++) {
            if (i != start && nums[i] == nums[i - 1]) {
                continue;
            }

            cur.add(nums[i]);
            backtrack(nums, i + 1, length, cur, res);
            cur.removeLast();
        }
    }
}
