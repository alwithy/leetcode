import java.util.HashMap;
import java.util.List;

public class Q0399_EvaluateDivision {
    public double[] calcEquation(List<List<String>> equations, double[] values, List<List<String>> queries) {
        int size = equations.size();
        UnionFind unionFind = new UnionFind(2 * size);
        //为每个字符分配一个id
        HashMap<String, Integer> map = new HashMap<>(2 * size);
        int id = 0;
        for (int i = 0; i < size; i++) {
            List<String> list = equations.get(i);
            String x = list.get(0);
            String y = list.get(1);

            if (!map.containsKey(x)) {
                map.put(x, id++);
            }

            if (!map.containsKey(y)) {
                map.put(y, id++);
            }

            unionFind.union(map.get(x), map.get(y), values[i]);
        }

        //查询
        int len = queries.size();
        double[] res = new double[len];
        for (int i = 0; i < len; i++) {
            String x = queries.get(i).get(0);
            String y = queries.get(i).get(1);

            Integer idX = map.get(x);
            Integer idY = map.get(y);

            if (idX == null || idY == null) {
                res[i] = -1.0d;
            } else {
                res[i] = unionFind.isConnected(idX, idY);
            }
        }

        return res;
    }

    static class UnionFind {
        private int[] parent;

        private double[] weight;

        public UnionFind(int n) {
            parent = new int[n];
            weight = new double[n];
            for (int i = 0; i < n; i++) {
                parent[i] = i;
                weight[i] = 1.0d;
            }
        }

        //合并两个节点
        //x / y = value
        //x / rootX = weight[x]
        //y / rootY = weight[y]
        public void union(int x, int y, double value) {
            int rootX = find(x);
            int rootY = find(y);

            if (rootX == rootY) {
                return;
            }

            parent[rootX] = rootY;
            //修改权值
            weight[rootX] = weight[y] * value / weight[x];
        }

        //路径压缩，返回根节点id
        public int find(int x) {
            if (parent[x] != x) {
                int origin = parent[x];
                parent[x] = find(parent[x]);
                weight[x] *= weight[origin];
            }
            return parent[x];
        }

        public double isConnected(int x, int y) {
            int rootX = find(x);
            int rootY = find(y);
            //x / rootX = weight[x]
            //y / rootY = weight[y]
            if (rootX == rootY) {
                return weight[x] / weight[y];
            } else {
                return -1.0d;
            }
        }
    }
}
