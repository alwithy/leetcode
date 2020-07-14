import java.util.Deque;
import java.util.LinkedList;

public class Q0173_BinaryTreeIterator {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

    class BSTIterator {
        TreeNode cur;
        Deque<TreeNode> stack;

        public BSTIterator(TreeNode root) {
            this.cur = root;
            this.stack = new LinkedList<>();
        }

        /** @return the next smallest number */
        public int next() {
            int res = 0;
            while (cur != null || !stack.isEmpty()) {
                if (cur != null) {
                    stack.push(cur);
                    cur = cur.left;
                } else {
                    cur = stack.pop();
                    res = cur.val;
                    cur = cur.right;
                    break;
                }
            }

            return res;
        }

        /** @return whether we have a next smallest number */
        public boolean hasNext() {
            return cur != null || !stack.isEmpty();
        }
    }
}
