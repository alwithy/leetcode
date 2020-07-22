import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;

public class Q0508_MostFrequentSubtreeSum {
    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

    HashMap<Integer,Integer> map;
    int maxTime;

    public int[] findFrequentTreeSum(TreeNode root) {
        if (root == null) return new int[0];
        // map的key为元素和,value为出现次数
        map = new HashMap<>();
        maxTime = 0;
        findTreeSum(root);
        List<Integer> res = new LinkedList<>();
        for (Integer sum : map.keySet()) {
            if (map.get(sum) == maxTime) {
                res.add(sum);
            }
        }

        int[] arr = new int[res.size()];
        for (int i = 0; i < res.size(); i++) {
            arr[i] = res.get(i);
        }

        return arr;
    }

    private int findTreeSum(TreeNode root) {
        if (root == null) return 0;

        int treeSum = findTreeSum(root.left) + findTreeSum(root.right) + root.val;
        map.put(treeSum, map.getOrDefault(treeSum, 0) + 1);
        maxTime = Math.max(maxTime, map.get(treeSum));

        return treeSum;
    }
}
