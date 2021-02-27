public class Q0395_LongestSubstring {
    public int longestSubstring(String s, int k) {
        //分治法，使用出现次数小于k的字符分割字符串
        return dfs(s, 0, s.length() - 1, k);
    }

    public int dfs(String s, int l, int r, int k) {
        //统计字符数
        int[] ch = new int[26];
        for (int i = l; i <= r; i++) {
            ch[s.charAt(i) - 'a']++;
        }

        //找到出现次数小于k大于0的字符
        char split = 0;
        for (int i = 0; i < 26; i++) {
            if (ch[i] > 0 && ch[i] < k) {
                split = (char) (i + 'a');
            }
        }

        if (split == 0) {
            return r - l + 1;
        }

        int i = l;
        int res = 0;
        while (i <= r) {
            while (i <= r && s.charAt(i) == split) {
                i++;
            }
            if (i > r) {
                break;
            }
            int start = i;
            while (i <= r && s.charAt(i) != split) {
                i++;
            }
            int len = dfs(s, start, i - 1, k);
            res = Math.max(len, res);
        }

        return res;
    }
}
