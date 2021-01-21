import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class Q1489_FindCriticalAndPseudoCriticalEdgesInMinimumSpanningTree {
    public List<List<Integer>> findCriticalAndPseudoCriticalEdges(int n, int[][] edges) {
        //官方题解方法1
        int m = edges.length;
        int[][] newEdges = new int[m][4];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < 3; j++) {
                newEdges[i][j] = edges[i][j];
            }
            newEdges[i][3] = i;
        }
        Arrays.sort(newEdges, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[2] - o2[2];
            }
        });

        UnionFind uf = new UnionFind(n);
        int value = 0;//最小生成树权值和
        int count = 1;//已经连接的点数,count == n则已生成最小生成树
        for (int[] edge : newEdges) {
            if (uf.union(edge[0], edge[1])) {
                value += edge[2];
                count++;
                if (count == n) {
                    break;
                }
            }
        }

        List<List<Integer>> res = new ArrayList<>();
        for (int i = 0; i < 2; i++) {
            res.add(new ArrayList<>());
        }

        for (int i = 0; i < m; i++) {
            //首先判断是不是关键边
            int v = 0;
            count = 1;
            uf = new UnionFind(n);
            for (int j = 0; j < m; j++) {
                if (j != i && uf.union(newEdges[j][0], newEdges[j][1])) {
                    v += newEdges[j][2];
                    count++;
                    if (count == n) {
                        break;
                    }
                }
            }

            if (count != n || v > value) {
                res.get(0).add(newEdges[i][3]);
                continue;
            }

            //然后判断是不是伪关键边
            uf = new UnionFind(n);
            v = newEdges[i][2];
            count = 2;
            uf.union(newEdges[i][0], newEdges[i][1]);
            for (int j = 0; j < m; j++) {
                if (uf.union(newEdges[j][0], newEdges[j][1])) {
                    v += newEdges[j][2];
                    count++;
                    if (count == n) {
                        break;
                    }
                }
            }
            if (count == n && v == value) {
                res.get(1).add(newEdges[i][3]);
            }
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

        //x和y原本不属于同一个连通分量则返回true，否则false
        public boolean union(int x, int y) {
            int rootX = find(x);
            int rootY = find(y);

            if (rootX == rootY) {
                return false;
            }

            //rank较大的作为新节点
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
}
