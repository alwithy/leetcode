import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

public class Q0116_PopulatingNextRightPointersInEachNode {
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

    public Node connect1(Node root) {
        if (root == null) return null;
        // 二叉树按层遍历
        Deque<Node> curLine = new LinkedList<>();
        root.next = null;
        curLine.add(root);
        while (!curLine.isEmpty()) {
            Deque<Node> nextLine = new LinkedList<>();
            Node last = curLine.pollFirst();
            if (last.left != null) {
                nextLine.add(last.left);
            }
            if (last.right != null) {
                nextLine.add(last.right);
            }
            Node cur;
            while (!curLine.isEmpty()) {
                cur = curLine.pollFirst();
                last.next = cur;

                if (cur.left != null) {
                    nextLine.add(cur.left);
                }
                if (cur.right != null) {
                    nextLine.add(cur.right);
                }
                last = cur;

                if (curLine.isEmpty()) cur.next = null;
            }
            curLine = nextLine;
        }

        return root;
    }

    public Node connect(Node root) {
        if (root == null) return null;
        // 利用已经建立的next指针
        Node nextLine;
        Node head = root;
        // root为本行的第一个节点
        while (root.left != null) {
            nextLine = root.left;
            while (root != null) {
                root.left.next = root.right;
                if (root.next != null) {
                    root.right.next = root.next.left;
                }
                root = root.next;
            }
            root = nextLine;
        }
        return head;
    }
}
