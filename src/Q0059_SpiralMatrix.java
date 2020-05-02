public class Q0059_SpiralMatrix {
    public int[][] generateMatrix(int n) {
        if (n == 1) {
            return new int[][]{{1}};
        }
        int[][] res = new int[n][n];
        int cur = 1;
        int curLength;
        //将方阵切成环，一次循环解决一个环
        for (int i = 0; i < n/2; i++) {
            curLength = n - 2 * i;

            for (int j = 0; j < curLength - 1; j++) {
                res[i][i + j] = cur++;
            }

            for (int j = 0; j < curLength - 1; j++) {
                res[i + j][i + curLength - 1] = cur++;
            }

            for (int j = 0; j < curLength - 1; j++) {
                res[i + curLength - 1][i + curLength - 1 - j] = cur++;
            }

            for (int j = 0; j < curLength - 1; j++) {
                res[i + curLength - 1 - j][i] = cur++;
            }
        }

        if (cur == n * n) {
            res[n/2 + 1][n/2 + 1] = cur;
        }

        return res;
    }
}
