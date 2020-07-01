import java.util.ArrayList;
import java.util.List;

public class Q0102_BinaryTreeLevelOrderTraversal {
    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        public TreeNode(int val) {
            this.val = val;
        }
    }

    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        if (root == null) {
            return res;
        }
        List<TreeNode> curLevel = new ArrayList<>();
        List<Integer> curVal;
        List<TreeNode> temp;
        curLevel.add(root);

        while (!curLevel.isEmpty()) {
            curVal = new ArrayList<>();
            temp = new ArrayList<>();

            for (TreeNode node : curLevel) {
                curVal.add(node.val);
                if (node.left != null) {
                    temp.add(node.left);
                }
                if (node.right != null) {
                    temp.add(node.right);
                }
            }

            res.add(curVal);
            curLevel = temp;
        }

        return res;
    }
}
