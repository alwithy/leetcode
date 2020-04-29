import java.util.*;

public class Q0040_CombinationSum {
    public static List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>> res = new ArrayList<>();
        if (candidates == null || candidates.length < 1 || target < 1) {
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
     * @param arr 使用的数组
     * @param residue 剩余值
     * @param begin 本次搜索的起点
     * @param path 本次搜索用到的元素集
     * @param res 解集
     */
    private static void dfs(int[] arr,
                           int residue,
                           int begin,
                           Deque<Integer> path,
                           List<List<Integer>> res) {
        if (residue == 0) {
            res.add(new ArrayList<>(path));
            return;
        }

        if (begin >= arr.length) {
            return;
        }

        for (int i = begin ; i < arr.length; i++) {
            if (residue - arr[i] < 0) {
                break;
            }

            if (i > begin && arr[i] == arr[i - 1]) {
                continue;
            }

            path.add(arr[i]);
            dfs(arr, residue - arr[i], i + 1, path, res);
            path.removeLast();
        }
    }

    public static void main(String[] args) {
        int[] arr = {10,1,2,7,6,1,5};
        List<List<Integer>> res = combinationSum2(arr,8);
    }
}
