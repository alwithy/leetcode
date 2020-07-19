import java.util.Deque;
import java.util.LinkedList;

public class Q0449_SerializeAndDeserializeBST {
    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        // 用层序遍历序列化
        // 序列化后类似 1,2,3,null,4
        if (root == null) return "null";
        Deque<TreeNode> deque = new LinkedList<>();
        StringBuilder res = new StringBuilder();
        deque.add(root);
        int numOfNodes = 1;
        while (numOfNodes > 0) {
            root = deque.poll();
            if (root == null) {
                res.append("null,");
                continue;
            }
            numOfNodes--;
            deque.add(root.left);
            deque.add(root.right);
            if (root.left != null) numOfNodes++;
            if (root.right != null) numOfNodes++;

            res.append(root.val).append(",");
        }
        // 去掉最后的","
        return res.toString().substring(0, res.length() - 1);
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        if (data == null || data.length() == 0) return null;
        String[] nodes = data.split(",");
        boolean isLeft = true;
        Deque<TreeNode> parents = new LinkedList<>();
        TreeNode root = getNode(nodes[0]);
        TreeNode parent = root;
        TreeNode cur;
        for (int i = 1; i < nodes.length; i++) {
            cur = getNode(nodes[i]);
            if (cur != null) {
                if (isLeft) {
                    parent.left = cur;
                } else {
                    parent.right = cur;
                }
                parents.add(cur);
            }

            isLeft = !isLeft;
            if (isLeft) {
                parent = parents.poll();
            }
        }

        return root;
    }

    private TreeNode getNode(String s) {
        if (s.equals("null")) {
            return null;
        } else {
            return new TreeNode(Integer.valueOf(s));
        }
    }
}
