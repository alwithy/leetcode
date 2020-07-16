import java.util.Deque;
import java.util.LinkedList;

public class Q0230_KthSmallestElementInBST {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode() {}
        TreeNode(int val) { this.val = val; }
        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

    public int kthSmallest(TreeNode root, int k) {
        // 使用中序遍历
        if (root == null) return -1;
        Deque<TreeNode> stack = new LinkedList<>();
        int res = -1;
        while (root != null || !stack.isEmpty()) {
            if (root != null) {
                stack.push(root);
                root = root.left;
            } else {
                root = stack.pop();
                k--;
                if (k == 0) {
                    res = root.val;
                    break;
                }
                root = root.right;
            }
        }

        return res;
    }

}
