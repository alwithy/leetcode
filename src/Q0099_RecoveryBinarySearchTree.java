public class Q0099_RecoveryBinarySearchTree {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode() {}
        TreeNode(int x) { val = x; }
        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

    public void recoverTree(TreeNode root) {
        if (root == null) return;
        // 莫里斯中序遍历，记录两个失序的节点x,y,然后交换它们的值
        TreeNode x = null;
        TreeNode y = null;
        TreeNode temp = null;
        TreeNode prv = null;
        while (root != null) {
            if (root.left != null) {
                temp = root.left;
                while (temp.right != null && temp.right != root) {
                    temp = temp.right;
                }

                if (temp.right == null) {
                    temp.right = root;
                    root = root.left;
                } else { // temp.right == root,说明我们已经设置过连接
                    // 目前该遍历的是root
                    if (prv != null && root.val < prv.val) {
                        y = root;
                        if (x == null) x = prv;
                    }

                    // 断开连接并走向右子树
                    temp.right = null;
                    prv = root;
                    root = root.right;
                }
            } else {
                // 没有左子树，遍历root后走向右子树
                if (prv != null && root.val < prv.val) {
                    y = root;
                    if (x == null) x = prv;
                }

                prv = root;
                root = root.right;
            }
        }

        if (x != null && y != null) {
            int num = x.val;
            x.val = y.val;
            y.val = num;
        }
    }
}
