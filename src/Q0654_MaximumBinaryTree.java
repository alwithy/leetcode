public class Q0654_MaximumBinaryTree {
    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

    public TreeNode constructMaximumBinaryTree(int[] nums) {
        if (nums == null || nums.length == 0) return null;
        // 递归

        return constructCore(nums, 0, nums.length - 1);
    }

    private TreeNode constructCore(int[] nums, int l, int r) {
        if (l == r) return new TreeNode(nums[l]);
        int max = l;
        for (int i = l + 1; i <= r; i++) {
            if (nums[i] > nums[max]) {
                max = i;
            }
        }

        TreeNode root = new TreeNode(nums[max]);
        if (max > l) {
            root.left = constructCore(nums, l, max - 1);
        }
        if (max < r) {
            root.right = constructCore(nums, max + 1, r);
        }

        return root;
    }
}
