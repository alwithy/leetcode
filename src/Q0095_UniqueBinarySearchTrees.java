import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Q0095_UniqueBinarySearchTrees {
    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        public TreeNode(int val){
            this.val = val;
        }

        public TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

    public static List<TreeNode> generateTrees(int start, int end) {
        List<TreeNode> res = new LinkedList<>();
        if (start > end) return res;
        if (start == end) {
            res.add(new TreeNode(start));
            return res;
        }

        for (int i = start; i <= end; i++) {
            List<TreeNode> leftTree = generateTrees(start, i - 1);
            List<TreeNode> rightTree = generateTrees(i + 1, end);

            if (leftTree.isEmpty() && rightTree.isEmpty()) {
                TreeNode cur = new TreeNode(i);
                res.add(cur);
            } else if (!leftTree.isEmpty() && rightTree.isEmpty()) {
                for (TreeNode l : leftTree) {
                    TreeNode cur = new TreeNode(i, l, null);
                    res.add(cur);
                }
            } else if(leftTree.isEmpty()) {
                // 此时右子树不为空
                for (TreeNode r : rightTree) {
                    TreeNode cur = new TreeNode(i, null, r);
                    res.add(cur);
                }
            } else {
                for (TreeNode l : leftTree) {
                    for (TreeNode r : rightTree) {
                        TreeNode cur = new TreeNode(i, l, r);
                        res.add(cur);
                    }
                }
            }
        }

        return res;
    }

    public static List<TreeNode> generateTrees(int n) {
        if (n < 1) return new ArrayList<>();
        return generateTrees(1, n);
    }

    public static void main(String[] args) {
        List<TreeNode> res = generateTrees(3);
    }
}
