public class Q0109_SortedListToBinarySearchTree {
    static class ListNode {
        ListNode next;
        int val;

        public ListNode(int val) {
            this.val = val;
        }
    }

    static class TreeNode {
        TreeNode left;
        TreeNode right;
        int val;

        public TreeNode(int val) {
            this.val = val;
        }
    }

    public TreeNode sortedListToBST(ListNode head) {
        if (head == null) {
            return null;
        }
        if (head.next == null) {
            return new TreeNode(head.val);
        }
        ListNode p1 = head, p2 = head.next, p1Pre = null;
        while (p2 != null && p2.next != null) {
            p1Pre = p1;
            p1 = p1.next;
            p2 = p2.next.next;
        }

        //p1为中点
        TreeNode root = new TreeNode(p1.val);
        //构建右子树
        root.right = sortedListToBST(p1.next);
        //构建左子树
        if (p1Pre != null) {
            p1Pre.next = null;
            root.left = sortedListToBST(head);
        }

        return root;
    }

}
