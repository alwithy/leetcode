public class Q0337_HouseRobber {
    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

    public int rob(TreeNode root) {
        int[] res = robCore(root);
        // res[0]为不打劫root,res[1]为打劫root
        return Math.max(res[0], res[1]);
    }

    private int[] robCore(TreeNode root) {
        int[] res = new int[2];
        if (root == null) return res;

        int[] left = robCore(root.left);
        int[] right = robCore(root.right);

        res[1] = root.val + left[0] + right[0];
        res[0] = Math.max(left[0], left[1]) + Math.max(right[0], right[1]);

        return res;
    }
}
