public class Q0172_FactorialTrailingZeroes {
    public int trailingZeroes(int n) {
        int cur = 5;
        int res = 0;
        while (cur <= n) {
            res += n/cur;
            if (Integer.MAX_VALUE/5 < cur) break;
            cur *= 5;
        }

        return res;
    }
}
