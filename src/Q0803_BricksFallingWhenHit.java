public class Q0803_BricksFallingWhenHit {
    static int cols, rows;
    static int[] moveI = {1, -1, 0, 0};
    static int[] moveJ = {0, 0, 1, -1};

    public static int[] hitBricks(int[][] grid, int[][] hits) {
        cols = grid.length;
        rows = grid[0].length;
        int[][] copy = new int[cols][rows];
        for (int i = 0; i < cols; i++) {
            for (int j = 0; j < rows; j++) {
                copy[i][j] = grid[i][j];
            }
        }

        //将hits中的点变为0
        for (int[] hit : hits) {
            copy[hit[0]][hit[1]] = 0;
        }

        int size = rows * cols;
        UnionFind unionFind = new UnionFind(size + 1);
        //将第一层的元素与屋顶相连
        for (int j = 0; j < rows; j++) {
            if (copy[0][j] == 1) {
                unionFind.union(j, size);
            }
        }

        //通过copy数组建图
        for (int i = 1; i < cols; i++) {
            for (int j = 0; j < rows; j++) {
                if (copy[i][j] == 0) {
                    continue;
                }

                //若上方是砖块，合并
                if (copy[i - 1][j] == 1) {
                    unionFind.union(getIndex(i - 1, j), getIndex(i, j));
                }

                //左边是砖块也合并
                if (j > 0 && copy[i][j - 1] == 1) {
                    unionFind.union(getIndex(i, j - 1), getIndex(i, j));
                }
            }
        }

        int[] res = new int[hits.length];
        for (int k = res.length - 1; k >= 0; k--) {
            int i = hits[k][0];
            int j = hits[k][1];

            if (grid[i][j] == 0) {
                continue;
            }

            //在恢复(i, j)处砖块之前与屋顶相连的砖块数量
            int origin = unionFind.getSize(size);

            //若i == 0，则该点与屋顶相连
            if (i == 0) {
                unionFind.union(j, size);
            }

            //往(i, j)上下左右四个方向看，如果是砖块就合并
            for (int l = 0; l < 4; l++) {
                int nextI = i + moveI[l];
                int nextJ = j + moveJ[l];

                if (canMove(nextI, nextJ) && copy[nextI][nextJ] == 1) {
                    unionFind.union(getIndex(i, j), getIndex(nextI, nextJ));
                }
            }

            int cur = unionFind.getSize(size);
            res[k] = Math.max(0, cur - origin - 1);
            copy[i][j] = 1;
        }

        return res;
    }

    public static int getIndex(int i, int j) {
        return i * rows + j;
    }

    public static boolean canMove(int i, int j) {
        return i >= 0 && i < cols && j >= 0 && j < rows;
    }

    static class UnionFind {
        //存放当前节点的父节点
        //parent[i] = parent.length - 1表示i节点与屋顶相连
        int[] parent;
        int[] size;

        public UnionFind(int n) {
            parent = new int[n];
            size = new int[n];
            for (int i = 0; i < n; i++) {
                parent[i] = i;
                size[i] = 1;
            }
        }

        public void union(int x, int y) {
            int rootX = find(x);
            int rootY = find(y);

            if (rootX == rootY) {
                return;
            }

            parent[rootX] = rootY;
            size[rootY] += size[rootX];
        }

        public int find(int x) {
            if (parent[x] != x) {
                parent[x] = find(parent[x]);
            }
            return parent[x];
        }

        public int getSize(int x) {
            int root = find(x);
            return size[root];
        }
    }

    public static void main(String[] args) {
        int[][] grid = {{1}, {1}, {1}, {1}, {1}};
        int[][] hits = {{3,0}, {4,0}, {1,0}, {2,0}, {0, 0}};
        int[] res = hitBricks(grid, hits);
    }
}
