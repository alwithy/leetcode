import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

public class Q0199_BinaryTreeRightSideView {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> res = new LinkedList<>();
        if (root == null) return res;
        Deque<TreeNode> stack = new LinkedList<>();
        Deque<Integer> depths = new LinkedList<>();
        stack.push(root);
        depths.push(1);
        int depth;
        while (!stack.isEmpty()) {
            root = stack.pop();
            depth = depths.pop();
            if (depth > res.size()) {
                res.add(root.val);
            }

            if (root.left != null) {
                stack.push(root.left);
                depths.push(depth + 1);
            }

            if (root.right != null) {
                stack.push(root.right);
                depths.push(depth + 1);
            }
        }

        return res;
    }
}
