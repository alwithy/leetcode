import java.util.Deque;
import java.util.LinkedList;

public class Q0513_FindBottomLeftTreeValue {
    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

    public int findBottomLeftValue(TreeNode root) {
        if (root == null) return -1;
        // 层序遍历
        int res = root.val;
        Deque<TreeNode> curLine = new LinkedList<>();
        Deque<TreeNode> nextLine;
        curLine.add(root);
        TreeNode cur;
        while (!curLine.isEmpty()) {
            res = curLine.getFirst().val;
            nextLine = new LinkedList<>();
            while (!curLine.isEmpty()) {
                cur = curLine.poll();
                if (cur.left != null) {
                    nextLine.add(cur.left);
                }
                if (cur.right != null) {
                    nextLine.add(cur.right);
                }
            }

            curLine = nextLine;
        }

        return res;
    }
}
