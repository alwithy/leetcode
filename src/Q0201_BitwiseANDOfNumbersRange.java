public class Q0201_BitwiseANDOfNumbersRange {
    public static int rangeBitwiseAnd1(int m, int n) {
        if (m == n) {
            return m;
        }
        int res = m & n;
        //若n - m >= 2 ^ i，则二进制位的第i位一定为0
        for (int i = 1; i < 31 && (1 << i) <= n - m; i++) {
            res &= ~(1 << i);
        }
        return res;
    }

    public static int rangeBitwiseAnd(int m, int n) {
        //官方题解
        int shift = 0;
        // 找到公共前缀
        while (m < n) {
            m >>= 1;
            n >>= 1;
            ++shift;
        }
        return m << shift;
    }

    public static void main(String[] args) {
        int m = 3;
        int n = 6;
        System.out.println(rangeBitwiseAnd(m, n));
    }
}
