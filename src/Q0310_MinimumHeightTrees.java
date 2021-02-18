import java.util.*;

public class Q0310_MinimumHeightTrees {
    public List<Integer> findMinHeightTrees(int n, int[][] edges) {
        //BFS
        List<Integer> res = new ArrayList<>();
        if (n == 1) {
            res.add(0);
            return res;
        }

        int[] degree = new int[n];
        HashMap<Integer, HashSet<Integer>> map = new HashMap<>();
        for (int i = 0; i < n; i++) {
            map.put(i, new HashSet<>());
        }
        //建图
        for (int[] edge : edges) {
            degree[edge[0]]++;
            degree[edge[1]]++;
            map.get(edge[0]).add(edge[1]);
            map.get(edge[1]).add(edge[0]);
        }
        Deque<Integer> deque = new LinkedList<>();
        //将度为1的节点加入队列
        for (int i = 0; i < n; i++) {
            if (degree[i] == 1) {
                deque.addLast(i);
            }
        }

        while (!deque.isEmpty()) {
            Deque<Integer> next = new LinkedList<>();
            res = new ArrayList<>();

            for (int cur : deque) {
                res.add(cur);
                HashSet<Integer> set = map.get(cur);

                for (int neighbor : set) {
                    degree[neighbor]--;
                    if (degree[neighbor] == 1) {
                        next.addLast(neighbor);
                    }
                    map.get(neighbor).remove(cur);
                }
            }

            deque = next;
        }

        return res;
    }
}
