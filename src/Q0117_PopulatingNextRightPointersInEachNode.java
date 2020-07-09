public class Q0117_PopulatingNextRightPointersInEachNode {
    class Node {
        public int val;
        public Node left;
        public Node right;
        public Node next;

        public Node() {}

        public Node(int _val) {
            val = _val;
        }

        public Node(int _val, Node _left, Node _right, Node _next) {
            val = _val;
            left = _left;
            right = _right;
            next = _next;
        }
    }
    public Node connect(Node root) {
        if (root == null) return null;
        Node cur = root;
        Node nextLine;
        while (cur != null) {
            // 寻找下一行的第一个节点
            while (cur.left == null && cur.right == null && cur.next != null) {
                cur = cur.next;
            }
            if (cur.left != null) {
                nextLine = cur.left;
            } else if (cur.right != null) {
                nextLine = cur.right;
            } else {
                break;
            }

            while (cur != null) {
                if (cur.left != null) {
                    if (cur.right != null) {
                        cur.left.next = cur.right;
                    } else {
                        Node next = cur.next;
                        if (next != null) {
                            while (next.left == null && next.right == null && next.next != null) {
                                next = next.next;
                            }
                            cur.left.next = next.left != null ? next.left : next.right;
                        }
                        cur = next;
                        continue;
                    }
                }

                if (cur.right != null) {
                    Node next = cur.next;
                    if (next != null) {
                        while (next.left == null && next.right == null && next.next != null) {
                            next = next.next;
                        }
                        cur.right.next = next.left != null ? next.left : next.right;
                    }
                    cur = next;
                    continue;
                }

                cur = cur.next;
            }

            cur = nextLine;
        }

        return root;
    }
}
