import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

public class Q0429_NaryTreeLevelOrderTraversal {
    class Node {
        public int val;
        public List<Node> children;

        public Node() {}

        public Node(int _val) {
            val = _val;
        }

        public Node(int _val, List<Node> _children) {
            val = _val;
            children = _children;
        }
    }

    public List<List<Integer>> levelOrder(Node root) {
        List<List<Integer>> res = new LinkedList<>();
        if (root == null) return res;
        Deque<Node> curLine = new LinkedList<>();
        Deque<Node> nextLine;
        List<Integer> vals;
        curLine.add(root);
        while (!curLine.isEmpty()) {
            vals = new LinkedList<>();
            nextLine = new LinkedList<>();
            while (!curLine.isEmpty()) {
                root = curLine.poll();
                vals.add(root.val);
                if (root.children != null && root.children.size() > 0) {
                    nextLine.addAll(root.children);
                }
                // for (Node node : root.children) {
                //     nextLine.add(node);
                // }
            }

            res.add(vals);
            curLine = nextLine;
        }

        return res;
    }

}
