import java.util.Deque;
import java.util.LinkedList;

public class Q0662MaximumWidthOfBinaryTree {
    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

    public int widthOfBinaryTree(TreeNode root) {
        if (root == null) return 0;
        // 官方题解1,层序遍历
        Deque<MyNode> que = new LinkedList<>();
        que.add(new MyNode(root, 0, 0));
        int res = 0;
        int depth = -1;
        int left = 0;
        MyNode cur;
        while (!que.isEmpty()) {
            cur = que.poll();
            if (cur.node != null) {
                que.add(new MyNode(cur.node.left, cur.depth + 1, 2 * cur.pos));
                que.add(new MyNode(cur.node.right, cur.depth + 1, 2 * cur.pos + 1));
                if (depth != cur.depth) {
                    depth = cur.depth;
                    left = cur.pos;
                }
                res = Math.max(res, cur.pos - left + 1);
            }
        }

        return res;
    }

    class MyNode {
        TreeNode node;
        int pos,depth;
        public MyNode(TreeNode node, int depth, int pos) {
            this.node = node;
            this.depth = depth;
            this.pos = pos;
        }
    }
}
