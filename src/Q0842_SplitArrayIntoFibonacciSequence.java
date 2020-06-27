import java.util.ArrayList;
import java.util.List;

public class Q0842_SplitArrayIntoFibonacciSequence {
    public static List<Integer> splitIntoFibonacci(String S) {
        List<List<Integer>> res = new ArrayList<>();
        // dfs解决
        List<Integer> path = new ArrayList<>();
        // 挑选前两个数字
        // 第一个数字S[0, i],第二个数字S[i, j]
        if (S.charAt(0) != '0') {
            for (int i = 1; i <= (S.length() - 1)/2 + 1; i++) {
                long first = Long.parseLong(S.substring(0, i));
                if (first > Integer.MAX_VALUE) break;
                path.add((int) first);
                if (S.charAt(i) != '0') {
                    for (int j = i + 1; j <= (S.length() + 1)/2 + 1; j++) {
                        long second = Long.parseLong(S.substring(i, j));
                        if (second > Integer.MAX_VALUE) break;
                        path.add((int) second);
                        dfs(S, j, path, res);
                        if (res.size() > 0) break;
                        path.remove(1);
                    }
                    if (res.size() > 0) break;
                } else {
                    path.add(0);
                    dfs(S, i + 1, path, res);
                    if (res.size() > 0) break;
                    path.remove(1);
                }

                path.remove(0);
            }
        } else {
            path = new ArrayList<>();
            path.add(0);
            if (S.charAt(1) != '0') {
                for (int i = 2; i <= (S.length() + 1)/2 + 1; i++) {
                    long second = Long.parseLong(S.substring(1, i));
                    if (second > Integer.MAX_VALUE) break;
                    path.add((int) second);
                    dfs(S, i, path, res);
                    if (res.size() > 0) break;
                    path.remove(1);
                }
            } else {
                path.add(0);
                dfs(S, 2, path, res);
            }
            path.remove(0);
        }

        return res.size() > 0 ? res.get(0) : new ArrayList<>();
    }

    /**
     *
     * @param s 本次搜索用到的字符串
     * @param begin 本次搜索的起点
     * @param path 本次搜索已包含的数字
     * @param res 符合条件的解
     */
    private static void dfs(String s,
                     int begin,
                     List<Integer> path,
                     List<List<Integer>> res) {
        if (res.size() > 0) return;
        if (begin == s.length()) {
            res.add(new ArrayList<>(path));
            return;
        }


        int target = path.get(path.size() - 1) + path.get(path.size() - 2);
        if (s.charAt(begin) == '0' && target > 0) return;
        long cur = -1;
        for (int i = begin + 1; i <= s.length() && cur < target; i++) {
            cur = Long.parseLong(s.substring(begin, i));
            if (cur > Integer.MAX_VALUE) break;
            if (cur == target) {
                path.add((int) cur);
                dfs(s, i, path, res);
                path.remove(path.size() - 1);
            }
        }
    }

    public static void main(String[] args) {
        String s = "214748364721474836422147483641";
        List<Integer> res = splitIntoFibonacci(s);
    }
}
