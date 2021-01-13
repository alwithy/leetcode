public class Q0684_RedundantConnection {
    public int[] findRedundantConnection(int[][] edges) {
        //并查集解决
        //边为[u,v],方便起见，这里把v当做父节点
        UnionFind unionFind = new UnionFind(edges.length);
        for (int[] arr : edges) {
            unionFind.union(arr);
        }

        return unionFind.res;
    }

    static class UnionFind {
        private int[] parent;
        public int[] res;

        public UnionFind(int n) {
            parent = new int[n + 1];
            for (int i = 1; i < n + 1; i++) {
                parent[i] = i;
            }
        }

        public void union(int[] arr) {
            int rootX = find(arr[0]);
            int rootY = find(arr[1]);

            if (rootX == rootY) {
                res = arr;
                return;
            }

            parent[rootX] = rootY;
        }

        public int find(int x) {
            if (parent[x] != x) {
                parent[x] = find(parent[x]);
            }
            return parent[x];
        }
    }
}
