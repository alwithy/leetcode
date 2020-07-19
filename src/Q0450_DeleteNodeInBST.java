public class Q0450_DeleteNodeInBST {
    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

    public TreeNode deleteNode(TreeNode root, int key) {
        if (root == null) return null;
        // 首先找到需要删除的节点，然后更新搜索二叉树
        // 找到左子树的最大值或者右子树的最小值来替代原节点值，再把有着对应值的节点删除
        if (key == root.val) {
            if (isLeaf(root)) return null;

            if (root.left != null) {
                root.val = getMax(root.left);
                root.left = deleteNode(root.left, root.val);
            } else {
                root.val = getMin(root.right);
                root.right = deleteNode(root.right, root.val);
            }
        } else {
            TreeNode cur = root;
            TreeNode father = root;
            // isLeft记录需要删除的是左子树还是右子树
            boolean isLeft = true;
            while (cur != null && key != cur.val) {
                father = cur;
                if (key < cur.val) {
                    isLeft = true;
                    cur = cur.left;
                } else {
                    isLeft = false;
                    cur = cur.right;
                }
            }

            if (cur != null) {
                if (isLeaf(cur)) {
                    if (isLeft) {
                        father.left = null;
                    } else {
                        father.right = null;
                    }
                } else {
                    if (cur.left != null) {
                        cur.val = getMax(cur.left);
                        cur.left = deleteNode(cur.left, cur.val);
                    } else {
                        cur.val = getMin(cur.right);
                        cur.right = deleteNode(cur.right, cur.val);
                    }
                }
            }
        }

        return root;
    }

    private boolean isLeaf(TreeNode root) {
        return root.left == null && root.right == null;
    }

    private int getMax(TreeNode root) {
        while (root.right != null) {
            root = root.right;
        }

        return root.val;
    }

    private int getMin(TreeNode root) {
        while (root.left != null) {
            root = root.left;
        }

        return root.val;
    }
}
