import java.util.LinkedList;
import java.util.List;

public class Q0514_FreedomTrail {
    public int findRotateSteps(String ring, String key) {
        // m记录ring中同一个字母的最多出现次数
        int m = 0;
        List<Integer>[] chs = new List[26];
        for (int i = 0; i < ring.length(); i++) {
            int cur = ring.charAt(i) - 'a';
            if (chs[cur] == null) {
                chs[cur] = new LinkedList<>();
            }
            chs[cur].add(i);
            m = Math.max(m, chs[cur].size());
        }
        //dp[i][j]表示到达key第i个字符，并且位于ring中同一个字符的第j个的代价
        int len = ring.length();
        int[][] dp = new int[key.length() + 1][m];
        int curChar = key.charAt(0) - 'a';
        for (int i = 0; i < chs[curChar].size(); i++) {
            int curIndex = chs[curChar].get(i);
            dp[1][i] = getMinDistance(curIndex, 0, len);
        }
        int lastChar;
        for (int i = 2; i < dp.length; i++) {
            curChar = key.charAt(i - 1) - 'a';
            lastChar = key.charAt(i - 2) - 'a';
            for (int j = 0; j < chs[curChar].size(); j++) {
                dp[i][j] = Integer.MAX_VALUE;
                for (int k = 0; k < chs[lastChar].size(); k++) {
                    dp[i][j] = Math.min(dp[i][j],
                            dp[i - 1][k]
                                    + getMinDistance(chs[curChar].get(j), chs[lastChar].get(k), len));
                }
            }
        }
        int res = Integer.MAX_VALUE;
        for (int i = 0; i < m; i++) {
            if (dp[key.length()][i] > 0) {
                res = Math.min(res, dp[key.length()][i]);
            }
        }
        return res;
    }

    public int getMinDistance(int i, int j, int len) {
        return Math.min(Math.abs(j - i), len - Math.abs(j - i)) + 1;
    }
}
