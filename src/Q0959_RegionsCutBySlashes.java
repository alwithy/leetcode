import java.util.Arrays;

public class Q0959_RegionsCutBySlashes {
    public static int regionsBySlashes(String[] grid) {
        //并查集
        int m = grid.length;
        int n = grid[0].length();
        int num = m * n * 4;

        //斜线把方块分为4个格子顺时针方向 1, 2, 3, 4
        //     \ 1  /
        //    3  \/ 2
        //      / 4 \
        //

        UnionFind uf = new UnionFind(num);
        int id = 0;
        int count = 0;//合并成功的次数
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length(); j++) {
                id = getId(i, j, n);

                //若是空格，则先把4块合并
                if (grid[i].charAt(j) == ' ') {
                    uf.union(id, id + 1);
                    uf.union(id + 1, id + 2);
                    uf.union(id + 2, id + 3);
                    count += 3;
                } else if (grid[i].charAt(j) == '/') {
                    //1和3，2和4合并
                    uf.union(id, id + 2);
                    uf.union(id + 1, id + 3);
                    count += 2;
                } else {
                    //1和2,3和4合并
                    uf.union(id, id + 1);
                    uf.union(id + 2, id + 3);
                    count += 2;
                }

                //向左方合并,当前砖块的3和左侧砖块的2
                if (j > 0) {
                    int leftId = getId(i, j - 1, n);
                    if (uf.union(id + 2, leftId + 1)) {
                        count++;
                    }
                }

                // 向上方合并，当前砖块的1和上方砖块的4
                if (i > 0) {
                    int upId = getId(i - 1, j, n);
                    if (uf.union(id, upId + 3)) {
                        count++;
                    }
                }
            }
        }

        return num - count;
    }

    //grid.length = m, grid[0].length = n
    //grid[i][j] 对应4块砖块是 (i * n + j) * 4到 (i * n + j) * 4 + 3
    public static int getId(int i, int j, int n) {
        return (i * n + j) * 4;
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
        String[] grid = {" /", "/ "};
        System.out.println(regionsBySlashes(grid));
    }
}
