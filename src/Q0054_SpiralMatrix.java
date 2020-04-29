import java.util.ArrayList;
import java.util.List;

public class Q0054_SpiralMatrix {
    public static List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> res = new ArrayList<>();
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            return res;
        }
        //类似第48题，把矩阵切成环，把环分成四块解决
        int rows = matrix.length;
        int cols = matrix[0].length;
        //row,col对应当前环的宽和长
        int row,col;
        int n = 0;
        for (; n < Math.min(rows, cols)/2; n++) {
            row = rows - 2 * n;
            col = cols - 2 * n;

            for (int i = 0; i < col - 1; i++) {
                res.add(matrix[n][n + i]);
            }

            for (int i = 0; i < row - 1; i++) {
                res.add(matrix[n + i][n + col - 1]);
            }

            for (int i = 0; i < col - 1; i++) {
                res.add(matrix[n + row - 1][n + col - 1 - i]);
            }

            for (int i = 0; i < row - 1; i++) {
                res.add(matrix[n + row - 1 - i][n]);
            }
        }

        //此时的row和col记录还没扫描的行数和列数
        //只有剩一行，剩一列，剩一个点这三种情况
        row = rows - 2 * n;
        col = cols - 2 * n;
        if (row > 1 && col == 1) {
            for (int i = 0; i < row; i++) {
                res.add(matrix[n + i][n]);
            }
        } else if (col > 1 && row == 1) {
            for (int i = 0; i < col; i++) {
                res.add(matrix[n][n + i]);
            }
        } else if (row == 1 && col == 1) {
            res.add(matrix[n][n]);
        }

        return res;
    }

    public static void main(String[] args) {
        int[][] matrix = {
                {2,3,4},
                {5,6,7},
                {8,9,10},
                {11,12,13},
                {14,15,16}
        };
        List<Integer> res = spiralOrder(matrix);
    }
}
