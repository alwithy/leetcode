import java.util.Deque;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;

public class Q0236_LowestCommonAncestorOfBinaryTree {
    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        // 使用一个哈希表记录所有节点的父节点，依次往上走
        // 前序遍历
        HashMap<TreeNode,TreeNode> map = new HashMap<>();
        Deque<TreeNode> stack = new LinkedList<>();
        stack.push(root);
        boolean findP = false;
        boolean findQ = false;
        while (!stack.isEmpty()) {
            root = stack.pop();
            if (root.val == p.val) findP = true;
            if (root.val == q.val) findQ = true;


            if (root.right != null) {
                map.put(root.right, root);
                stack.push(root.right);
            }
            if (root.left != null) {
                map.put(root.left, root);
                stack.push(root.left);
            }

            if (findP && findQ) break;
        }

        HashSet<TreeNode> ancestorOfP = new HashSet<>();
        ancestorOfP.add(p);
        while (map.containsKey(p)) {
            ancestorOfP.add(map.get(p));
            p = map.get(p);
        }

        while (!ancestorOfP.contains(q)) {
            q = map.get(q);
        }

        return q;
    }
}
