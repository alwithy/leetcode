public class Q0793_PreimageSizeofFactorialZeroesFunction {
    public static int preimageSizeFZF(int k) {
        // 二分搜索法
        long l = 0;
        long r = Long.MAX_VALUE;
        if (k > help(r) || k < 0) return 0;
        while (l < r) {
            long mid = l + ((r - l) >> 1);
            if (help(mid) > k) {
                r = mid - 1;
            } else {
                l = mid;
                if (r == l + 1) break;
            }
        }

        return help(l) == k ? 5 : 0;
    }

    public static long help(long n) {
        long cur = 5;
        long res = 0;
        while (cur <= n) {
            res += n/cur;
            if (Long.MAX_VALUE/5 < cur) break;
            cur *= 5;
        }

        return res;
    }

    public static void main(String[] args) {
        System.out.println(preimageSizeFZF(31));
    }
}
