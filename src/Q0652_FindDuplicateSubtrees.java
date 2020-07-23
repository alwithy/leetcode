import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Q0652_FindDuplicateSubtrees {
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

    public List<TreeNode> findDuplicateSubtrees(TreeNode root) {
        List<TreeNode> res = new ArrayList<>();
        if (root == null) return res;
        // 将二叉树的所有子树序列化并放在HashMap中
        // 重复的节点放在另一个HashMap中
        HashMap<String,TreeNode> subtree = new HashMap<>();
        HashMap<String,TreeNode> duplicate = new HashMap<>();
        serialize(root, subtree, duplicate);
        for (String s : duplicate.keySet()) {
            res.add(duplicate.get(s));
        }

        return res;
    }

    private String serialize(TreeNode root, HashMap<String,TreeNode> subtree, HashMap<String,TreeNode> duplicate) {
        if (root == null) return "#,";
        // 前序遍历序列化，类似：1,2,#,
        String left = serialize(root.left, subtree, duplicate);
        String right = serialize(root.right, subtree, duplicate);
        StringBuilder temp = new StringBuilder();
        temp.append(root.val).append(",").append(left).append(right);
        String res = temp.toString();

        if (subtree.containsKey(res)) {
            duplicate.put(res, root);
        } else {
            subtree.put(res, root);
        }

        return res;
    }
}
