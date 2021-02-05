public class Q1208_GetEqualSubstringsWithinBudget {
    public int equalSubstring(String s, String t, int maxCost) {
        //滑动窗口法
        //窗口范围[l..r]
        int l = 0, r = 0;
        int curCost = 0;
        int res = 0;
        while (r < s.length()) {
            int rCost = Math.abs(s.charAt(r) - t.charAt(r));
            curCost += rCost;
            while (curCost > maxCost && l < r) {
                curCost -= Math.abs(s.charAt(l) - t.charAt(l));
                l++;
            }
            int curLen = rCost > maxCost ? 0 : r - l + 1;
            res = Math.max(curLen, res);
            r++;
        }

        return res;
    }
}
