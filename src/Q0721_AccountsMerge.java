import java.util.*;

public class Q0721_AccountsMerge {
    public static List<List<String>> accountsMerge(List<List<String>> accounts) {
        //并查集
        int id = 0;
        HashMap<Integer, String> idMail = new HashMap<>();
        HashMap<String, Integer> mailId = new HashMap<>();
        HashMap<Integer, String> idUser = new HashMap<>();
        //为每个mail分配一个id
        for (List<String> user : accounts) {
            for (int i = 1; i < user.size(); i++) {
                if (!mailId.containsKey(user.get(i))) {
                    idMail.put(id, user.get(i));
                    mailId.put(user.get(i), id);
                    idUser.put(id, user.get(0));
                    id++;
                }
            }
        }

        UnionFind unionFind = new UnionFind(id);
        for (List<String> user : accounts) {
            int firstMailId = mailId.get(user.get(1));
            for (int i = 2; i < user.size(); i++) {
                int curMailId = mailId.get(user.get(i));
                unionFind.union(firstMailId, curMailId);
            }
        }

        //id对应的email地址在res中的index
        HashMap<Integer, Integer> idIndex = new HashMap<>();
        List<List<String>> res = new ArrayList<>();//未排序的
        for (int curId = 0; curId < id; curId++) {
            int parentId = unionFind.find(curId);
            if (!idIndex.containsKey(parentId)) {
                List<String> user = new ArrayList<>();
                user.add(idUser.get(parentId));
                idIndex.put(parentId, res.size());
                res.add(user);
            }
            int index = idIndex.get(parentId);
            res.get(index).add(idMail.get(curId));
        }

        //对email进行排序
        for (List<String> user : res) {
            String name = user.get(0);
            user.remove(0);
            Collections.sort(user);
            user.add(0, name);
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

        public void union(int x, int y) {
            int rootX = find(x);
            int rootY = find(y);

            if (rootX == rootY) {
                return;
            }
            parent[rootX] = rootY;
        }

        public int find(int x) {
            if (parent[x] != x) {
                parent[x] = find(parent[x]);
            }
            return parent[x];
        }
    }

    public static void main(String[] args) {
        List<List<String>> accounts = new ArrayList<>();
        String[] s1 = {"John", "johnsmith@mail.com", "john00@mail.com"};
        accounts.add(Arrays.asList(s1));
        String[] s2 = {"John", "johnnybravo@mail.com"};
        accounts.add(Arrays.asList(s2));
        String[] s3 = {"John", "johnsmith@mail.com", "john_newyork@mail.com"};
        accounts.add(Arrays.asList(s3));
        String[] s4 = {"Mary", "mary@mail.com"};
        accounts.add(Arrays.asList(s4));
        accounts = accountsMerge(accounts);
    }
}
