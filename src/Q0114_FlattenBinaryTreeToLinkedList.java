public class Q0114_FlattenBinaryTreeToLinkedList {
    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        public TreeNode(int val) {
            this.val = val;
        }
    }

    public void flatten(TreeNode root) {
        if (root == null) return;

        flattenCore(root);
    }

    private void flattenCore(TreeNode root) {
        if (root.left != null) {
            flattenCore(root.left);
        }

        if (root.right != null) {
            flattenCore(root.right);
        }

        TreeNode temp = root.right;
        root.right = root.left;
        root.left = null;
        while (root.right != null) {
            root = root.right;
        }
        root.right = temp;
    }
}
