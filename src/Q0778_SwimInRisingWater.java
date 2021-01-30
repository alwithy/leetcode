import java.util.*;

public class Q0778_SwimInRisingWater {
    static int[] moveI = {-1, 0};
    static int[] moveJ = {0, -1};
    static int n;

    public int swimInWater(int[][] grid) {
        //并查集
        n = grid.length;
        List<int[]> edges = new ArrayList<>();
        //每条边表示为[dis, x, y]，dis为距离, x和y为点对应id
        //dis为两点中高度的最大值
        //点[i,j]的id为 i * n + j
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                int id = getId(i, j);
                for (int k = 0; k < 2; k++) {
                    int nextI = i + moveI[k];
                    int nextJ = j + moveJ[k];

                    if (!canVisit(nextI, nextJ)) {
                        continue;
                    }

                    int[] edge = {Math.max(grid[i][j], grid[nextI][nextJ]),
                            id, getId(nextI, nextJ)};
                    edges.add(edge);
                }
            }
        }

        Collections.sort(edges, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[0] - o2[0];
            }
        });

        UnionFind unionFind = new UnionFind(n * n);
        int res = 0;
        for (int[] edge : edges) {
            unionFind.union(edge[1], edge[2]);
            if (unionFind.isConnected(0, n * n - 1)) {
                res = edge[0];
                break;
            }
        }
        return res;
    }

    public int getId(int i, int j) {
        return i * n + j;
    }

    public boolean canVisit(int i, int j) {
        return i >= 0 && i < n && j >= 0 && j < n;
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
