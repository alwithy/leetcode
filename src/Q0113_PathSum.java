import java.util.ArrayList;
import java.util.List;

public class Q0113_PathSum {
    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        public TreeNode(int val) {
            this.val = val;
        }
    }

    public static List<List<Integer>> pathSum(TreeNode root, int sum) {
        // dfs算法解决
        List<List<Integer>> res = new ArrayList<>();
        if (root == null) return res;
        dfs(sum, root, new ArrayList<>(), res);
        return res;
    }

    /**
     *
     * @param target 本次搜索的目标
     * @param root 本次搜索开始的节点
     * @param path 本次搜索已包含的路径
     * @param res 结果集
     */
    private static void dfs(int target,
                     TreeNode root,
                     List<Integer> path,
                     List<List<Integer>> res) {
        path.add(root.val);
        target -= root.val;

        if (target == 0 && root.left == null && root.right == null) {
            res.add(new ArrayList<>(path));
        } else {
            if (root.left != null) {
                dfs(target, root.left, path, res);
            }

            if (root.right != null) {
                dfs(target, root.right, path, res);
            }
        }

        path.remove(path.size() - 1);
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(-2);
        root.right = new TreeNode(-3);
        List<List<Integer>> res = pathSum(root, -5);

    }
}
