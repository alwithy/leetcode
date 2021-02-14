import java.util.*;

public class Q0765_CouplesHoldingHands {
    public int minSwapsCouples(int[] row) {
        //并查集
        int n = row.length;
        UnionFind uf = new UnionFind(n/2);
        for (int i = 0; i < n; i += 2) {
            int l = row[i] / 2;
            int r = row[i + 1] / 2;
            uf.union(l, r);
        }

        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < n / 2; i++) {
            int root = uf.find(i);
            map.put(root, map.getOrDefault(root, 0) + 1);
        }

        int res = 0;
        for (Map.Entry<Integer, Integer> e : map.entrySet()) {
            res += e.getValue() - 1;
        }
        return res;
    }

    static class UnionFind {
        int[] parent;
        int[] rank;

        public UnionFind(int n) {
            rank = new int[n];
            Arrays.fill(rank, 1);
            parent = new int[n];
            for (int i = 0; i < n; i++) {
                parent[i] = i;
            }
        }

        public void union(int x, int y) {
            int rX = find(x);
            int rY = find(y);

            if (rX == rY) {
                return;
            }

            if (rank[rX] > rank[rY]) {
                int tmp = rX;
                rX = rY;
                rY = tmp;
            }

            parent[rX] = parent[rY];
            rank[rY] += rank[rX];
        }

        public int find(int x) {
            if (parent[x] != x) {
                parent[x] = find(parent[x]);
            }
            return parent[x];
        }
    }
}
