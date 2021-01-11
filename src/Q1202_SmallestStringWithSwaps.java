import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.PriorityQueue;

public class Q1202_SmallestStringWithSwaps {
    public String smallestStringWithSwaps(String s, List<List<Integer>> pairs) {
        if (s == null || s.length() == 0 || pairs == null || pairs.size() == 0) {
            return s;
        }
        int n = s.length();
        UnionFind unionFind = new UnionFind(n);
        for (List<Integer> list : pairs) {
            int x = list.get(0);
            int y = list.get(1);

            unionFind.union(x, y);
        }
        char[] res = new char[n];
        //key为父节点，value为index从小到大排序的子节点
        HashMap<Integer, List<Integer>> map = new HashMap<>();
        for (int i = 0; i < n; i++) {
            int father = unionFind.find(i);
            if (!map.containsKey(father)) {
                map.put(father, new ArrayList<>());
            }
            map.get(father).add(i);
        }

        for (int father : map.keySet()) {
            PriorityQueue<Character> chs = new PriorityQueue<>();
            List<Integer> indexes = map.get(father);

            //同一个父节点下的子节点对应的所有char加入优先级队列
            for (int index : indexes) {
                chs.add(s.charAt(index));
            }

            //从小到大将char填入res数组
            for (int index : indexes) {
                res[index] = chs.poll();
            }
        }

        return String.valueOf(res);
    }

    static class UnionFind {
        private int[] parent;

        public UnionFind(int n) {
            parent = new int[n];
            for (int i = 0; i < n; i++) {
                parent[i] = i;
            }
        }

        public int find(int x) {
            if (parent[x] != x) {
                parent[x] = find(parent[x]);
            }
            return parent[x];
        }

        public void union(int x, int y) {
            int rootX = find(x);
            int rootY = find(y);

            parent[rootX] = rootY;
        }
    }
}
