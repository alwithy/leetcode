public class Q0106_ConstructBinaryTreeFromInorderAndPostorder {
    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) {
            val = x;
        }
    }

    public TreeNode buildTree(int[] inorder, int[] postorder) {
        if (postorder == null || inorder == null
                || postorder.length != inorder.length
                || postorder.length < 1) {
            return null;
        }

        int length = postorder.length;
        TreeNode head = buildTreeCore
                (postorder, 0, length - 1,
                        inorder, 0, length - 1);

        return head;
    }

    private TreeNode buildTreeCore(int[] postorder,
                                   int postLeft,
                                   int postRight,
                                   int[] inorder,
                                   int inLeft,
                                   int inRight) {
        if (postLeft == postRight) {
            return new TreeNode(postorder[postRight]);
        }

        TreeNode head = new TreeNode(postorder[postRight]);
        int i = inLeft;
        for (; i <= inRight; i++) {
            if (inorder[i] == head.val) {
                break;
            }
        }

        int lengthOfLeft = i - inLeft;
        int lengthOfRight = inRight - inLeft - lengthOfLeft;

        if (lengthOfLeft > 0) {
            head.left = buildTreeCore(postorder,
                    postLeft,
                    postLeft + lengthOfLeft - 1,
                    inorder,
                    inLeft,
                    inLeft + lengthOfLeft - 1);
        }

        if (lengthOfRight > 0) {
            head.right = buildTreeCore(postorder,
                    postLeft + lengthOfLeft,
                    postRight - 1,
                    inorder,
                    i + 1,
                    inRight);
        }

        return head;
    }
}
