import java.util.Arrays;

public class Q1319_NumberOfOperations {
    public int makeConnected(int n, int[][] connections) {
        //并查集
        int numOfConnection = 1;//连接次数为n则表示所有的计算机都已在一个网络中
        int redundant = 0;//可以移动的电缆数量

        UnionFind unionFind = new UnionFind(n);
        for (int[] con : connections) {
            if (unionFind.union(con[0], con[1])) {
                numOfConnection++;
                if (numOfConnection == n) {
                    break;
                }
            } else {
                redundant++;
            }
        }

        if (numOfConnection == n) {
            return 0;
        } else if (numOfConnection + redundant >= n) {
            return n - numOfConnection;
        } else {
            return -1;
        }
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

            //rank大的作为父节点
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
