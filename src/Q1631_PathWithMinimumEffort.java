import java.util.*;

public class Q1631_PathWithMinimumEffort {
    int[] moveI = {0, -1};
    int[] moveJ = {-1, 0};
    int m, n;

    public int minimumEffortPath(int[][] heights) {
        m = heights.length;
        n = heights[0].length;
        //并查集
        List<int[]> edges = new ArrayList<>();
        //每条边格式为[v, x, y], v 为距离, x和y为两点对应的id
        //点[i,j]对应id为 i * n + j
        //对于[i, j]，判断[i - 1, j]和[i, j - 1]能否与其组成边
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                int id = getId(i, j);
                for (int k = 0; k < 2; k++) {
                    int nextI = i + moveI[k];
                    int nextJ = j + moveJ[k];

                    if (canVisit(nextI, nextJ)) {
                        int nextId = getId(nextI, nextJ);
                        int dis = Math.abs(heights[i][j] - heights[nextI][nextJ]);
                        int[] edge = {dis, id, nextId};
                        edges.add(edge);
                    }
                }
            }
        }

        Collections.sort(edges, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[0] - o2[0];
            }
        });

        int res = 0;
        UnionFind uf = new UnionFind(m * n);
        for (int[] edge : edges) {
            uf.union(edge[1], edge[2]);
            if (uf.isConnected(0, m * n - 1)) {
                res = edge[0];
                break;
            }
        }

        return res;
    }

    public boolean canVisit(int i, int j) {
        return i >= 0 && i < m && j >= 0 && j < n;
    }

    public int getId(int i, int j) {
        return i * n + j;
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
            int rootX = find(x);
            int rootY = find(y);

            if (rootX == rootY) {
                return;
            }

            if (rank[rootX] > rank[rootY]) {
                int tmp = rootX;
                rootX = rootY;
                rootY = tmp;
            }

            parent[rootX] = rootY;
            rank[rootY] += rank[rootX];
        }

        public int find(int x) {
            if (parent[x] != x) {
                parent[x] = find(parent[x]);
            }
            return parent[x];
        }

        public boolean isConnected(int x, int y) {
            int rootX = find(x);
            int rootY = find(y);

            return rootX == rootY;
        }
    }
}
