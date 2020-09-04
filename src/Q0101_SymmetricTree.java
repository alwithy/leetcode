import java.util.LinkedList;
import java.util.List;

public class Q0101_SymmetricTree {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

    public boolean isSymmetric1(TreeNode root) {
        if (root == null) return true;
        // 层序遍历,迭代
        List<TreeNode> curLine = new LinkedList<>();
        curLine.add(root);
        while (!curLine.isEmpty()) {
            List<TreeNode> nextLine = new LinkedList<>();
            for (int i = 0; i < curLine.size(); i++) {
                TreeNode cur = curLine.get(i);
                if (cur != null) {
                    nextLine.add(cur.left);
                    nextLine.add(cur.right);
                }
            }

            int l = 0;
            int r = nextLine.size() - 1;
            while (l < r) {
                TreeNode t1 = nextLine.get(l);
                TreeNode t2 = nextLine.get(r);
                if (((t1 == null || t2 == null) && !(t1 == null && t2 == null))
                        || (t1 != null && t2 != null && t1.val != t2.val)) {
                    return false;
                }
                l++;
                r--;
            }
            curLine = nextLine;
        }

        return true;
    }

    public boolean isSymmetric(TreeNode root) {
        if (root == null) return true;
        // 递归
        return help(root.left, root.right);
    }

    private boolean help(TreeNode t1, TreeNode t2) {
        if (t1 == null && t2 == null) return true;
        if (t1 == null || t2 == null) return false;

        return t1.val == t2.val && help(t1.left, t2.right) && help(t1.right, t2.left);
    }
}
