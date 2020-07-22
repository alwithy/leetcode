import java.util.Deque;
import java.util.LinkedList;

public class Q0623_AddOneRowToTree {
    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

    public TreeNode addOneRow(TreeNode root, int v, int d) {
        if (d == 1) {
            TreeNode res = new TreeNode(v);
            res.left = root;
            return res;
        }
        if (root == null) return null;
        // 层序遍历
        Deque<TreeNode> curLine = new LinkedList<>();
        Deque<TreeNode> nextLine;
        curLine.add(root);
        TreeNode cur;
        for (int depth = 1; depth < d - 1; depth++) {
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

        while (!curLine.isEmpty()) {
            cur = curLine.poll();
            if (cur.left != null) {
                TreeNode temp = new TreeNode(v);
                temp.left = cur.left;
                cur.left = temp;
            } else {
                cur.left = new TreeNode(v);
            }

            if (cur.right != null) {
                TreeNode temp = new TreeNode(v);
                temp.right = cur.right;
                cur.right = temp;
            } else {
                cur.right = new TreeNode(v);
            }
        }

        return root;
    }
}
