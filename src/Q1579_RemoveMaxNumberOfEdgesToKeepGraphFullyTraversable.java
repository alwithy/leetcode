import java.util.Arrays;

public class Q1579_RemoveMaxNumberOfEdgesToKeepGraphFullyTraversable {
    public static int maxNumEdgesToRemove(int n, int[][] edges) {
        //并查集
        //Alice
        UnionFind ufA = new UnionFind(n + 1);
        //Bob
        UnionFind ufB = new UnionFind(n + 1);
        int res = 0;

        //首先添加公共边
        for (int[] edge : edges) {
            if (edge[0] == 3) {
                if (!ufA.union(edge[1], edge[2]) & !ufB.union(edge[1], edge[2])) {
                    res++;
                }
            }
        }

        for (int[] edge : edges) {
            //专属边
            if (edge[0] != 3) {
                UnionFind uf = edge[0] == 1 ? ufA : ufB;
                if (!uf.union(edge[1], edge[2])) {
                    res++;
                }
            }
        }

        return ufA.count == n && ufB.count == n ? res : -1;
    }

    static class UnionFind {
        int[] parent;
        int[] rank;
        int count;//已经union成功的次数

        public UnionFind(int n) {
            rank = new int[n];
            Arrays.fill(rank, 1);
            parent = new int[n];
            for (int i = 0; i < n; i++) {
                parent[i] = i;
            }
            count = 1;
        }

        public boolean union(int x, int y) {
            int rootX = find(x);
            int rootY = find(y);

            if (rootX == rootY) {
                return false;
            }

            if (rank[rootX] > rank[rootY]) {
                int tmp = rootX;
                rootX = rootY;
                rootY = tmp;
            }

            parent[rootX] = rootY;
            rank[rootY] += rank[rootX];
            count++;
            return true;
        }

        public int find(int x) {
            if (parent[x] != x) {
                parent[x] = find(parent[x]);
            }
            return parent[x];
        }
    }

    public static void main(String[] args) {
        int[][] edges = {{3,1,2}, {3,2,3}, {1,1,3}, {1,2,4}, {1,1,2}, {2,3,4}};
        System.out.println(maxNumEdgesToRemove(4, edges));
    }
}
