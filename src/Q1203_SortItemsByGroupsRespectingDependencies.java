import java.util.*;

public class Q1203_SortItemsByGroupsRespectingDependencies {
    public static int[] sortItems(int n, int m, int[] group, List<List<Integer>> beforeItems) {

        //给没有分组的item分配一个不属于[0..m-1]的组
        for (int i = 0; i < group.length; i++) {
            if (group[i] == -1) {
                group[i] = m++;
            }
        }

        //建立item和group的邻接矩阵
        ArrayList<Integer>[] groupAdj = new ArrayList[m];
        int[] groupIndegree = new int[m];
        for (int i = 0; i < m; i++) {
            groupAdj[i] = new ArrayList<>();
        }
        ArrayList<Integer>[] itemAdj = new ArrayList[n];
        int[] itemIndegree = new int[n];
        for (int i = 0; i < n; i++) {
            itemAdj[i] = new ArrayList<>();
        }

        //根据group[]，完善邻接矩阵
        for (int currentItem = 0; currentItem < group.length; currentItem++) {
            int currentGroup = group[currentItem];
            for (int beforeItem : beforeItems.get(currentItem)) {
                int beforeGroup = group[beforeItem];
                if (beforeGroup != currentGroup) {
                    groupAdj[beforeGroup].add(currentGroup);
                    groupIndegree[currentGroup]++;
                }
                itemAdj[beforeItem].add(currentItem);
                itemIndegree[currentItem]++;
            }
        }

        //对group和item进行拓扑排序
        List<Integer> groupTopo = topoSort(groupAdj, groupIndegree, m);
        if (groupTopo.isEmpty()) {
            return new int[0];
        }
        List<Integer> itemTopo = topoSort(itemAdj, itemIndegree, n);
        if (itemTopo.isEmpty()) {
            return new int[0];
        }

        //得到group和item的对应关系
        HashMap<Integer, List<Integer>> groupItems = new HashMap<>();
        for (int currentItem : itemTopo) {
            if (!groupItems.containsKey(group[currentItem])) {
                groupItems.put(group[currentItem], new ArrayList<>());
            }
            groupItems.get(group[currentItem]).add(currentItem);
        }

        int[] res = new int[n];
        int index = 0;
        for (int currentGroup : groupTopo) {
            for (int currentItem : groupItems.getOrDefault(currentGroup, new ArrayList<>())) {
                res[index++] = currentItem;
            }
        }

        return res;
    }

    public static List<Integer> topoSort(ArrayList<Integer>[] adj, int[] indegree, int n) {
        List<Integer> res = new ArrayList<>();
        Deque<Integer> deque = new ArrayDeque<>();

        //入度为0的点加入队列
        for (int i = 0; i < n; i++) {
            if (indegree[i] == 0) {
                deque.addLast(i);
            }
        }

        while (!deque.isEmpty()) {
            int cur = deque.pollFirst();
            res.add(cur);
            for (int after : adj[cur]) {
                indegree[after]--;
                if (indegree[after] == 0) {
                    deque.addLast(after);
                }
            }
        }

        return res.size() == n ? res : new ArrayList<>();
    }

    public static void main(String[] args) {
        int n = 8, m = 2;
        int[] group = {-1,-1,1,0,0,1,0,-1};
        List<List<Integer>> beforeItems = new ArrayList<>();
        List<Integer> cur = new ArrayList<>();
        beforeItems.add(cur);
        cur = new ArrayList<>();
        cur.add(6);
        beforeItems.add(cur);
        cur = new ArrayList<>();
        cur.add(5);
        beforeItems.add(cur);
        cur = new ArrayList<>();
        cur.add(6);
        beforeItems.add(cur);
        cur = new ArrayList<>();
        cur.add(3);
        cur.add(6);
        beforeItems.add(cur);
        cur = new ArrayList<>();
        beforeItems.add(cur);
        cur = new ArrayList<>();
        beforeItems.add(cur);
        cur = new ArrayList<>();
        beforeItems.add(cur);
        int[] res = sortItems(n, m, group, beforeItems);
    }
}
