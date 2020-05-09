public class Q0105_ConstructBinaryTreeFromPreorderAndInorder {
    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) {
            val = x;
        }
    }

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        if (preorder == null || inorder == null
                || preorder.length != inorder.length
                || preorder.length < 1) {
            return null;
        }

        int length = preorder.length;
        TreeNode head = buildTreeCore
                (preorder, 0, length - 1,
                inorder, 0, length - 1);

        return head;
    }

    private TreeNode buildTreeCore(int[] preorder,
                                   int preLeft,
                                   int preRight,
                                   int[] inorder,
                                   int inLeft,
                                   int inRight) {
        if (preLeft == preRight) {
            return new TreeNode(preorder[preLeft]);
        }

        TreeNode head = new TreeNode(preorder[preLeft]);
        int i = inLeft;
        for (; i <= inRight; i++) {
            if (inorder[i] == head.val) {
                break;
            }
        }

        // head左子树长度
        int lengthOfLeft = i - inLeft;
        // head右子树长度
        int lengthOfRight = preRight - preLeft - lengthOfLeft;
        if (lengthOfLeft > 0) {
            head.left = buildTreeCore(preorder,
                    preLeft + 1,
                    preLeft + lengthOfLeft,
                    inorder,
                    inLeft,
                    i - 1);
        }

        if (lengthOfRight > 0) {
            head.right = buildTreeCore(preorder,
                    preLeft + lengthOfLeft + 1,
                    preRight,
                    inorder,
                    i + 1,
                    inRight);
        }

        return head;
    }
}
