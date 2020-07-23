import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Q0655_PrintBinaryTree {
    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

    public List<List<String>> printTree(TreeNode root) {
        // 递归
        List<List<String>> res = new ArrayList<>();
        if (root == null) return res;
        int height = getHeight(root);
        String[][] tree = new String[height][(1 << height) - 1];
        for (String[] s : tree) {
            Arrays.fill(s, "");
        }
        fill(tree, root, 0, 0, tree[0].length - 1);
        for (String[] s : tree) {
            res.add(Arrays.asList(s));
        }

        return res;
    }

    private void fill(String[][] tree, TreeNode root,int i, int l, int r) {
        if (root == null) return;
        int mid = l + ((r - l) >> 1);
        tree[i][mid] = String.valueOf(root.val);

        fill(tree, root.left, i + 1, l, mid - 1);
        fill(tree, root.right, i + 1, mid + 1, r);
    }

    private int getHeight(TreeNode root) {
        if (root == null) return 0;

        return 1 + Math.max(getHeight(root.left), getHeight(root.right));
    }
}
