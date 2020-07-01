import java.util.ArrayDeque;
import java.util.Deque;

public class Q0098_ValidateBinarySearchTree {
    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        public TreeNode(int val) {
            this.val = val;
        }
    }

    public boolean isValidBST(TreeNode root) {
        // 中序遍历为递增序列则有效
        Deque<TreeNode> stack = new ArrayDeque<>();
        boolean res = true;
        long lastVal = Long.MIN_VALUE;
        while (!stack.isEmpty() || root != null) {
            if (root != null) {
                stack.push(root);
                root = root.left;
            } else {
                root = stack.pop();
                if (root.val <= lastVal) {
                    res = false;
                    break;
                }
                lastVal = root.val;
                root = root.right;
            }
        }

        return res;
    }
}
