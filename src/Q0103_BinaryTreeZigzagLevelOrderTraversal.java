import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Q0103_BinaryTreeZigzagLevelOrderTraversal {
    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        public TreeNode(int val) {
            this.val = val;
        }
    }

    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        if (root == null) return res;
        // 奇数从左往右，偶数从右往左，行数从1开始
        boolean oddLevel = true;
        List<TreeNode> curLevel = new LinkedList<>();
        curLevel.add(root);
        List<Integer> curVal;
        List<TreeNode> temp;

        while (!curLevel.isEmpty()) {
            curVal = new LinkedList<>();
            temp = new LinkedList<>();

            if (oddLevel) {
                for (int i = 0; i < curLevel.size(); i++) {
                    TreeNode node = curLevel.get(i);
                    curVal.add(node.val);
                    if (node.left != null) {
                        temp.add(node.left);
                    }
                    if (node.right != null) {
                        temp.add(node.right);
                    }
                }
            } else {
//                for (int i = curLevel.size() - 1; i >= 0; i--) {
//                    TreeNode node = curLevel.get(i);
//                    curVal.add(node.val);
//                }

                for (int i = 0; i < curLevel.size(); i++) {
                    TreeNode node = curLevel.get(i);
                    curVal.add(0, node.val);
                    if (node.left != null) {
                        temp.add(node.left);
                    }
                    if (node.right != null) {
                        temp.add(node.right);
                    }
                }
            }

            res.add(curVal);
            curLevel = temp;
            oddLevel = !oddLevel;
        }

        return res;
    }
}
