import java.util.ArrayList;
import java.util.List;

public class Q0131_PalindromePartitioning {
    public List<List<String>> partition(String s) {
        List<List<String>> res = new ArrayList<>();
        int len = s.length();
        //dp[i][j]表示s[i..j]是否是回文
        boolean[][] dp = new boolean[len][len];
        for (int i = len - 1; i >= 0; i--) {
            dp[i][i] = true;
            for (int j = i + 1; j < len; j++) {
                dp[i][j] = s.charAt(i) == s.charAt(j)
                        && (i + 1 == j || dp[i + 1][j - 1]);
            }
        }

        dfs(0, s, dp, new ArrayList<>(), res);
        return res;
    }

    public void dfs(int start, String s, boolean[][] dp, List<String> path, List<List<String>> res) {
        if (start == s.length()) {
            res.add(new ArrayList<>(path));
            return;
        }

        for (int i = start; i < s.length(); i++) {
            if (dp[start][i]) {
                String cur = s.substring(start, i + 1);
                path.add(cur);
                dfs(i + 1, s, dp, path, res);
                path.remove(path.size() - 1);
            }
        }
    }
}
