package ByteDance;

import java.util.*;

public class Q01 {
    public static List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> res = new LinkedList<>();
        if (root == null) return res;
        Deque<TreeNode> curLine = new ArrayDeque<>();
        Deque<TreeNode> nextLine;
        List<Integer> cur;
        curLine.add(root);
        while (!curLine.isEmpty()) {
            nextLine = new ArrayDeque<>();
            cur = new ArrayList<>();
            while (!curLine.isEmpty()) {
                TreeNode node = curLine.pollFirst();
                cur.add(node.val);

                if (node.left != null) {
                    nextLine.add(node.left);
                }

                if (node.right != null) {
                    nextLine.add(node.right);
                }
            }

            res.add(cur);
            curLine = nextLine;
        }

        return res;
    }

    public static void main(String[] args) {
        TreeNode head = new TreeNode(3);
        head.left = new TreeNode(9);
        head.right = new TreeNode(20);
        head.right.left = new TreeNode(15);
        head.right.right = new TreeNode(7);

        List<List<Integer>> res = levelOrder(head);

        List<Integer> a = new LinkedList<>();
    }

    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }
}
