import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

public class Q0515_FindLargestValueInEachTreeRow {
    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

    public List<Integer> largestValues(TreeNode root) {
        // 层序遍历
        List<Integer> res = new ArrayList<>();
        if (root == null) return res;
        Deque<TreeNode> curLine = new LinkedList<>();
        Deque<TreeNode> nextLine;
        curLine.add(root);
        int max;
        while (!curLine.isEmpty()) {
            nextLine = new LinkedList<>();
            max = Integer.MIN_VALUE;
            while (!curLine.isEmpty()) {
                root = curLine.poll();
                max = Math.max(max, root.val);

                if (root.left != null) {
                    nextLine.add(root.left);
                }
                if (root.right != null) {
                    nextLine.add(root.right);
                }
            }

            res.add(max);
            curLine = nextLine;
        }

        return res;
    }
}
