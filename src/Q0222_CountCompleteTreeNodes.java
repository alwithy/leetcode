import java.util.Deque;
import java.util.LinkedList;

public class Q0222_CountCompleteTreeNodes {
    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

    public static int countNodes1(TreeNode root) {
        // 线性时间
        int res = 0;
        if (root == null) return res;
        int maxDepth = 1;
        TreeNode cur = root;
        while (cur.left != null) {
            cur = cur.left;
            maxDepth++;
        }

        res = -1 + (1 << maxDepth);
        // 遍历，顺序为右中左
        Deque<TreeNode> stack = new LinkedList<>();
        Deque<Integer> depths = new LinkedList<>();
        int depth = 1;
        while (!stack.isEmpty() || root != null) {
            if (root != null) {
                stack.push(root);
                depths.push(depth++);
                root = root.right;
            } else {
                root = stack.pop();
                depth = depths.pop();

                if (depth == maxDepth - 1) {
                    if (root.right == null) {
                        res--;
                    } else {
                        break;
                    }

                    if (root.left == null) {
                        res--;
                    } else {
                        break;
                    }
                }

                root = root.left;
                depth++;
            }
        }

        return res;
    }

    public static int countNodes(TreeNode root) {
        // 二分查找
        int res = 0;
        if (root == null) return res;
        int d = 1;
        TreeNode cur = root;
        while (cur.left != null) {
            cur = cur.left;
            d++;
        }
        if (d == 1) return 1;
        res = -1 + (1 << (d - 1));
        // 最后一层的节点索引为从左到右，从1到2^d
        // 找到第一个不存在的节点
        int l = 1;
        int r = 1 << (d - 1);
        if (exists(root, d, r)) return res + r;
        int mid;
        while (l < r) {
            mid = l + ((r - l) >> 1);
            if (exists(root, d, mid)) {
                l = mid + 1;
            } else if (exists(root, d, mid - 1)) {
                l = mid;
                break;
            } else {
                r = mid - 1;
            }
        }

        // 此时索引为l的节点为第一个不存在的节点
        res += l - 1;

        return res;
    }

    private static boolean exists(TreeNode root, int deep, int index) {
        int cur = 0;
        for (int i = 1; i < deep; i++) {
            if (index > cur + (1 << (deep - 1 - i))) {
                cur += (1 << (deep - 1 - i));
                root = root.right;
            } else {
                root = root.left;
            }
        }

        return root != null;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);

        System.out.println(countNodes(root));
//        System.out.println(exists(root, 3, 1));
    }
}
