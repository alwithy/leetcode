import java.util.*;

public class Q0093_RestoreIPAddresses {
    public List<String> restoreIpAddresses(String s) {
        List<String> res = new ArrayList<>();
        if (s == null || s.length() < 4) return res;
        // dfs算法解决
        dfs(s, 0, new ArrayDeque<>(), res);

        return res;
    }

    /**
     *
     * @param s
     * @param index 本次搜索开始的起点
     * @param path 本次搜索已经包含的数字
     * @param res 结果集
     */
    private void dfs(String s,
                     int index,
                     Deque<Integer> path,
                     List<String> res) {
        if (path.size() == 4) {
            if (index == s.length()) {
                StringBuilder sb = new StringBuilder();
                Iterator<Integer> it = path.iterator();
                sb.append(it.next());
                while (it.hasNext()) {
                    sb.append(".");
                    sb.append(it.next());
                }
                res.add(sb.toString());
            }
            return;
        }

        int cur = 0;
        for (int i = index; i < s.length(); i++) {
            cur = cur * 10 + s.charAt(i) - '0';
            if (cur >= 0 && cur <= 255) {
                path.add(cur);
                dfs(s, i + 1, path, res);
                path.removeLast();
            }

            if (cur == 0) break;
        }
    }
}
