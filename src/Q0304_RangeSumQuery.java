public class Q0304_RangeSumQuery {

    /**
     * Your NumMatrix object will be instantiated and called as such:
     * NumMatrix obj = new NumMatrix(matrix);
     * int param_1 = obj.sumRegion(row1,col1,row2,col2);
     */
    static class NumMatrix {
        private int[][] sum;

        public NumMatrix(int[][] matrix) {
            if (matrix.length == 0 || matrix[0].length == 0) {
                sum = new int[0][0];
                return;
            }
            int m = matrix.length, n = matrix[0].length;
            //cSum[i + 1][j + 1]表示[0][j]到[i][j]之和
            int[][] cSum = new int[m + 1][n + 1];
            for (int i = 1; i < m + 1; i++) {
                for (int j = 1; j < n + 1; j++) {
                    cSum[i][j] = matrix[i - 1][j - 1] + cSum[i - 1][j];
                }
            }
            //sum[i + 1][j + 1]表示[0][0]到[i][j]的子矩阵所有数字之和
            sum = new int[m + 1][n + 1];
            for (int i = 1; i < m + 1; i++) {
                int rSum = 0;
                for (int j = 1; j < n + 1; j++) {
                    sum[i][j] = sum[i - 1][j - 1] + rSum + cSum[i - 1][j] + matrix[i - 1][j - 1];
                    rSum += matrix[i - 1][j - 1];
                }
            }
        }

        public int sumRegion(int row1, int col1, int row2, int col2) {
            return sum[row2 + 1][col2 + 1]
                    - sum[row1][col2 + 1]
                    - sum[row2 + 1][col1]
                    + sum[row1][col1];
        }
    }

    public static void main(String[] args) {
        int[][] arr = {
                {3, 0, 1, 4, 2},
                {5, 6, 3, 2, 1},
                {1, 2, 0, 1, 5},
                {4, 1, 0, 1, 7},
                {1, 0, 3, 0, 5}
        };
        NumMatrix nm = new NumMatrix(arr);
        int[] a1 = {2, 1, 4, 3};
        int[] a2 = {1, 1, 2, 2};
        int[] a3 = {1, 2, 2, 4};
        System.out.println(nm.sumRegion(2, 1, 4, 3));
        System.out.println(nm.sumRegion(1, 1, 2, 2));

    }
}
