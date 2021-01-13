public class Q0685_RedundantConnection {
    public static int[] findRedundantDirectedConnection(int[][] edges) {
        //官方题解，并查集
        //[u,v]表示u是v的一个父节点
        UnionFind unionFind = new UnionFind(edges.length);
        for (int i = 0; i < edges.length; i++) {
            unionFind.union(i, edges);
        }

        if (unionFind.conflict == null) {
            return unionFind.loop;
        }

        if (unionFind.loop == null) {
            //没有导致环路出现的边，说明最后一条边是附加边，即conflict[1]
            return unionFind.conflict[1];
        } else {
            //有导致环路出现的边，说明loop != conflict[1]
            //因为同一条边不会同时被记为loop和conflict[1]
            //由于附加边一定在环路中，所以不可能是conflict[1]
            return unionFind.conflict[0];
        }
    }

    static class UnionFind {
        private int[] parent;//记录父节点
        private int[] giveParent;//giveParent[i] = j表示edges[j]赋予节点i父节点
        public int[] loop;//导致环路的边
        public int[][] conflict; //导致冲突的边

        public UnionFind(int n) {
            parent = new int[n + 1];
            giveParent = new int[n + 1];
            for (int i = 1; i < n + 1; i++) {
                parent[i] = i;
            }
            loop = null;
            conflict = null;
        }

        public void union(int i, int[][] edges) {
            int[] edge = edges[i];
            int rootX = find(edge[0]);
            int rootY = find(edge[1]);

            //edge[0]是edge[1]的一个父节点
            if (rootY != edge[1]) {
                //edge[1]有两个父节点
                //即当前边导致冲突
                //同时导致冲突和成环的边被记为conflict
                conflict = new int[2][];
                conflict[0] = edges[giveParent[edge[1]]];
                conflict[1] = edge;
                return;
            } else if (rootX == rootY) {//当前边edge导致出现无向环
                loop = edge;
                return;
            }

            parent[rootY] = rootX;
            giveParent[edge[1]] = i;
        }

        public int find(int x) {
            if (parent[x] != x) {
                parent[x] = find(parent[x]);
            }
            return parent[x];
        }
    }

    public static void main(String[] args) {
        int[][] arr = {{3,4}, {4,1}, {1,2}, {2,3}, {5,1}};
        int[] res = findRedundantDirectedConnection(arr);
    }
}
