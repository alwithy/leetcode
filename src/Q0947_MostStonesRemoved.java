import java.util.HashMap;

public class Q0947_MostStonesRemoved {
    public int removeStones(int[][] stones) {
        UnionFind unionFind = new UnionFind();

        for (int[] stone : stones) {
            unionFind.union(stone[0], stone[1] + 10001);
        }

        return stones.length - unionFind.count;
    }

    static class UnionFind {
        HashMap<Integer, Integer> parent;
        int count;//记录不在连通图中的点的数量

        public UnionFind() {
            parent = new HashMap<>();
            count = 0;
        }

        public void union(int x, int y) {
            int rootX = find(x);
            int rootY = find(y);

            if (rootX == rootY) {
                return;
            }

            parent.put(rootX, rootY);
            count--;
        }

        public int find(int x) {
            if (!parent.containsKey(x)) {
                parent.put(x, x);
                count++;
            }

            if (parent.get(x) != x) {
                parent.put(x, find(parent.get(x)));
            }

            return parent.get(x);
        }
    }
}
