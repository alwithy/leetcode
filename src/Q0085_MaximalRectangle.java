public class Q0085_MaximalRectangle {
    public int maximalRectangle(char[][] matrix) {
        if (matrix == null || matrix.length == 0) return 0;
        int rows = matrix.length;
        int cols = matrix[0].length;
        int[][] width = new int[rows][cols];

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                width[i][j] = matrix[i][j] - '0';
                if (width[i][j] > 0 && j - 1 >= 0) {
                    width[i][j] += width[i][j - 1];
                }
            }
        }

        int[][] dp = new int[rows][cols];
        int res = 0;
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (width[i][j] == 0) continue;
                int curWidth = width[i][j];
                int max = curWidth;

                for (int l = i; l >= 0; l--) {
                    curWidth = Math.min(curWidth, width[l][j]);
                    if (curWidth == 0) break;
                    max = Math.max(max, curWidth * (i - l + 1));
                }

                res = Math.max(res, max);
            }
        }

        return res;
    }
}
