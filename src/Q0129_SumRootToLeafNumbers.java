public class Q0129_SumRootToLeafNumbers {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

    private int addition;

    public int sumNumbers(TreeNode root) {
        addition = 0;
        if (root == null) return addition;
        // dfs解决
        dfs(root, 0);

        return addition;
    }

    private void dfs(TreeNode cur,int curAddition) {
        curAddition = curAddition * 10 + cur.val;
        if (cur.left == null && cur.right == null) {
            addition += curAddition;
            return;
        }

        if (cur.left != null) {
            dfs(cur.left, curAddition);
        }

        if (cur.right != null) {
            dfs(cur.right, curAddition);
        }
    }
}
