public class Q1004_MaxConsecutiveOnes {
    public int longestOnes(int[] a, int k) {
        if (a == null || a.length == 0) return 0;
        if (k > a.length) return a.length;

        int l = -1;
        int r = 0;
        // 滑动窗口,l和r为左右边界
        // r在窗口中，l不在
        int res = 0;
        while (r < a.length) {
            if (a[r] == 0) k--;
            while (k < 0) {
                if (a[++l] == 0) k++;
            }
            while (r + 1 < a.length && a[r + 1] == 1) r++;
            res = Math.max(res, r++ - l);
        }

        return res;
    }
}
