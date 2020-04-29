import java.util.*;

public class Q0039_CombinationSum {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> res = new ArrayList<>();
        if (candidates == null || candidates.length < 1) {
            return res;
        }
        Arrays.sort(candidates);
        if (candidates[0] > target) {
            return res;
        }

        dfs(candidates, target, 0, new ArrayDeque<>(), res);
        return res;
    }

    /**
     * @param arr 目标数组
     * @param residue 剩余值
     * @param begin 本次搜索的起点
     * @param path 本次遍历中使用到的元素
     * @param res 解集
     */
    private void dfs(int[] arr,
                     int residue,
                     int begin,
                     Deque<Integer> path,
                     List<List<Integer>> res) {
        if (residue == 0) {
            res.add(new ArrayList<>(path));
            return;
        }

        for (int i = begin; i < arr.length; i++) {
            //数组已经经过排序，所以剪枝
            //若residue减去当前candidates[i]小于0,则之后的元素不可能满足条件
            if (residue < arr[i]) {
                break;
            }

            path.addLast(arr[i]);
            dfs(arr, residue - arr[i], i, path, res);
            path.removeLast();
        }
    }
}
