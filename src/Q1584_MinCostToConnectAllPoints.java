import java.util.*;

public class Q1584_MinCostToConnectAllPoints {
    public int minCostConnectPoints(int[][] points) {
        if (points.length < 2) {
            return 0;
        }
        //官方题解方法1
        int n = points.length;
        UnionFind unionFind = new UnionFind(n);
        List<Edge> edges = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                edges.add(new Edge(getLen(points[i], points[j]), i, j));
            }
        }
        Collections.sort(edges, new Comparator<Edge>() {
            @Override
            public int compare(Edge o1, Edge o2) {
                return o1.len - o2.len;
            }
        });
        int res = 0;//总消耗
        int count = 1;//记录总连接的点数，一共需要连接n - 1次，当count == n时循环终止
        for (Edge edge : edges) {
            if (unionFind.union(edge.x, edge.y)) {
                res += edge.len;
                count++;
                if (count == n) {
                    break;
                }
            }
        }
        return res;
    }

    public int getLen(int[] p1, int[] p2) {
        return Math.abs(p1[0] - p2[0]) + Math.abs(p1[1] - p2[1]);
    }

    //按秩合并的并查集
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

        //若x,y属于同一集合则返回false，否则true
        public boolean union(int x, int y) {
            int rootX = find(x);
            int rootY = find(y);

            if (rootX == rootY) {
                return false;
            }

            //rank大的作为新根节点
            if (rank[rootX] > rank[rootY]) {
                int tmp = rootX;
                rootX = rootY;
                rootY = tmp;
            }

            parent[rootX] = rootY;
            rank[rootY] += rank[rootX];

            return true;
        }

        public int find(int x) {
            if (parent[x] != x) {
                parent[x] = find(parent[x]);
            }
            return parent[x];
        }
    }

    static class Edge {
        int len, x, y;

        //points[x]和points[y]组成的一条边
        public Edge(int len, int x, int y) {
            this.len = len;
            this.x = x;
            this.y = y;
        }
    }
}
