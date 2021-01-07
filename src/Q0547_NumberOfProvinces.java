import java.util.ArrayDeque;
import java.util.Deque;

public class Q0547_NumberOfProvinces {
    public int findCircleNum1(int[][] isConnected) {
        if ( isConnected == null || isConnected.length == 0) {
            return 0;
        }
        //BFS
        int n = isConnected.length;
        boolean[] visited = new boolean[n];
        int id = 0;
        Deque<Integer> deque = new ArrayDeque<>();
        for (int i = 0; i < n; i++) {
            if (visited[i]) {
                continue;
            }
            id++;
            deque.add(i);
            while (!deque.isEmpty()) {
                int cur = deque.pollFirst();
                for (int j = 0; j < n; j++) {
                    if (!visited[j] && isConnected[cur][j] == 1) {
                        visited[j] = true;
                        deque.addLast(j);
                    }
                }
            }
        }
        return id;
    }

    public int findCircleNum2(int[][] isConnected) {
        if ( isConnected == null || isConnected.length == 0) {
            return 0;
        }
        //并查集
        int n = isConnected.length;
        UnionFind unionFind = new UnionFind(n);
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                if (isConnected[i][j] == 1) {
                    unionFind.union(i, j);
                }
            }
        }

        int res = 0;
        for (int i = 0; i < n; i++) {
            if (unionFind.parent[i] == i) {
                res++;
            }
        }
        return res;
    }

    static class UnionFind {
        int[] parent;

        public UnionFind(int n) {
            parent = new int[n];
            for (int i = 0; i < n; i++) {
                parent[i] = i;
            }
        }

        public int find(int x) {
            if (parent[x] != x) {
                parent[x] = find(parent[x]);
            }
            return parent[x];
        }

        public void union(int x, int y) {
            parent[find(x)] = find(y);
        }
    }
}
