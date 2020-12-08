import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Q0842_SplitArrayIntoFibonacciSequence {
    public static List<Integer> splitIntoFibonacci(String S) {
        //dfs,首先挑选前两个数字
        List<Integer> path = new LinkedList<>();
        List<List<Integer>> res = new LinkedList<>();
        int len = S.length();
        //第一个数字为S[0,i],第二个数字为S[i + 1,j]
        long first = 0, second = 0;
        if (S.charAt(0) != '0') {
            out:
            for (int i = 0; i < len/2 + 1; i++) {
                first = first * 10 + S.charAt(i) - '0';
                if (first > Integer.MAX_VALUE) break;
                path.add((int) first);
                if (S.charAt(i + 1) != 0) {
                    second = 0;
                    for (int j = i + 1; j < len - 1; j++) {
                        second = second * 10 + S.charAt(j) - '0';
                        if (second > Integer.MAX_VALUE) break;
                        path.add((int) second);
                        dfs(S, j + 1, path, res);
                        if (!res.isEmpty()) break out;
                        path.remove(1);
                    }
                } else {
                    path.add(0);
                    dfs(S, i + 2, path, res);
                    if (!res.isEmpty()) break;
                    path.remove(1);
                }
                path.remove(0);
            }
        } else {
            path.add(0);
            if (S.charAt(1) != '0') {
                for (int j = 1; j < len; j++) {
                    second = second * 10 + S.charAt(j) - '0';
                    if (second > Integer.MAX_VALUE) break;
                    path.add((int) second);
                    dfs(S, j + 1, path, res);
                    if (!res.isEmpty()) break;
                    path.remove(1);
                }
            } else {
                path.add(0);
                dfs(S, 2, path, res);
                path.remove(1);
            }
            path.remove(0);
        }

        return res.isEmpty() ? new LinkedList<>() : res.get(0);
    }

    /**
     *
     * @param S 使用的字符串
     * @param index 本次搜索开始的位置
     * @param path 已经保存的数列
     * @param res  结果集
     */
    public static void dfs(String S, int index, List<Integer> path, List<List<Integer>> res) {
        if (index == S.length()) {
            res.add(new LinkedList(path));
            return;
        }

        int size = path.size();
        int target = path.get(size - 1) + path.get(size - 2);
        long cur = 0;
        for (int i = index; i < S.length(); i++) {
            cur = cur * 10 + S.charAt(i) - '0';
            if (cur == target && (i + 1 == S.length() || S.charAt(i + 1) != 0)) {
                path.add((int) cur);
                dfs(S, i + 1, path, res);
                if (!res.isEmpty()) break;
                path.remove(size);
            } else if (cur > target) {
                break;
            }
        }
    }

    public static void main(String[] args) {
        String s = "214748364721474836422147483641";
        List<Integer> res = splitIntoFibonacci(s);
    }
}
