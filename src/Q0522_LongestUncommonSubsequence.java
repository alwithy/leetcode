public class Q0522_LongestUncommonSubsequence {
    public int findLUSlength(String[] strs) {
        // 关键点是，如果strs[i]中有部分是它独有的，那整个strs[i]就必然是特殊序列
        int res = -1;
        for (int i = 0; i < strs.length; i++) {
            int j = 0;
            for (; j < strs.length; j++) {
                if (i == j) continue;
                if (isSubsequence(strs[i], strs[j])) {
                    break;
                }
            }

            if (j == strs.length) {
                res = Math.max(strs[i].length(), res);
            }
        }
        return res;
    }

    private boolean isSubsequence(String x, String y) {
        // 判断x是否是y的子串
        int i = 0;
        int j = 0;
        for (; i < x.length() && j < y.length(); j++) {
            if (x.charAt(i) == y.charAt(j)) i++;
        }

        return i == x.length();
    }
}
