public class Q0091_DecodeWays {
    public int numDecodings1(String s) {
        int res = 0;
        if (s == null || s.length() == 0) return res;
        // dfs算法解决,较慢
        return dfs(s,0);
    }

    /**
     *
     * @param s
     * @param begin 本次搜索的起点
     * @return
     */
    private int dfs(String s,
                    int begin) {
        if (begin == s.length()) {
            return 1;
        }

        int cur = s.charAt(begin) - '0';
        if (cur == 0) {
            return 0;
        }

        if (begin < s.length() - 1) {
            int next = s.charAt(begin + 1) - '0';
            if (10 * cur + next <= 26) {
                return dfs(s, begin + 1) + dfs(s, begin + 2);
            }
        }

        return dfs(s, begin + 1);
    }

    public static int numDecodings2(String s) {
        if (s == null || s.length() == 0) return 0;
        if (s.length() == 1) return 1;
        // dp算法解决,比第一种快很多
        // dp[i]代表以s[0]开头，s[i]结尾的子序列的编码方式数量
        // 对每一个字母s[i]，查看它是否能与上一个字母组合编码
        int[] dp = new int[s.length()];
        int last = s.charAt(0) - '0';
        if (last == 0) return 0;
        dp[0] = 1;
        int cur;

        for (int i = 1; i < s.length(); i++) {
            cur = s.charAt(i) - '0';
            if (cur > 0) {
                dp[i] += dp[i - 1];
            } else if (last > 2 || last < 1) {
                // 防止出现类似"1270"的数据
                return 0;
            }

            if (10 * last + cur >= 10 && 10 * last + cur <= 26) {
                if (i == 1) {
                    dp[i]++;
                } else {
                    dp[i] += dp[i - 2];
                }
            }
            last = cur;
        }


        return dp[s.length() - 1];
    }

    public static void main(String[] args) {
        String s = "110";
        System.out.println(numDecodings2(s));
    }
}
