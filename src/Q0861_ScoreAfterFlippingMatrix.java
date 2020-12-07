public class Q0861_ScoreAfterFlippingMatrix {
    public int matrixScore(int[][] A) {
        int res = 0;
        int m = A.length;
        int n = A[0].length;
        int base = (int)Math.pow(2, n - 1);
        boolean[] changed = new boolean[m];
        //第一列
        for (int i = 0; i < m; i++) {
            res += base;
            changed[i] = A[i][0] == 0;
        }
        //剩余列
        int count, cur;
        for (int j = 1; j < n; j++) {
            base /= 2;
            count = 0;//count记录1的数量
            for (int i = 0; i < m; i++) {
                if (changed[i]) {
                    cur = Math.abs(A[i][j] - 1);
                } else {
                    cur = A[i][j];
                }
                count += cur == 1? 1 : 0;
            }
            count = Math.max(m - count, count);
            res += base * count;
        }
        return res;
    }
}
