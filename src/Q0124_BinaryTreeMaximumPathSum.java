public class Q0124_BinaryTreeMaximumPathSum {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

    int maxSum;

    public int maxPathSum(TreeNode root) {
        // 官方题解
        maxSum = Integer.MIN_VALUE;
        maxGain(root);

        return maxSum;
    }

    private int maxGain(TreeNode root) {
        if (root == null) {
            return 0;
        }

        int leftGain = Math.max(0, maxGain(root.left));
        int rightGain = Math.max(0, maxGain(root.right));

        int newPath = root.val + leftGain + rightGain;
        maxSum = Math.max(newPath, maxSum);

        return root.val + Math.max(leftGain, rightGain);
    }
}
