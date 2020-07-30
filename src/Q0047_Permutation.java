import java.util.*;

public class Q0047_Permutation {
    public List<List<Integer>> permuteUnique(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        if (nums == null || nums.length == 0) return res;
        // 在46题的基础上，使用HashMap来记录数字的数量
        HashMap<Integer,Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            map.put(nums[i], map.getOrDefault(nums[i], 0) + 1);
        }

        dfs(new LinkedList<>(), map, res, nums.length);
        return res;
    }

    private void dfs(Deque<Integer> path,
                     HashMap<Integer,Integer> map,
                     List<List<Integer>> res,
                     int length) {
        if (path.size() == length) {
            List<Integer> temp = new ArrayList<>(path);
            res.add(temp);
            return;
        }

        for (int i : map.keySet()) {
            int num = map.get(i);
            if (num > 0) {
                path.add(i);
                map.put(i, num - 1);
                dfs(path, map, res, length);
                path.pollLast();
                map.put(i, num);
            }
        }
    }
}
