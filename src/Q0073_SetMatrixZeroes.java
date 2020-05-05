public class Q0073_SetMatrixZeroes {
    public static void setZeroes(int[][] matrix) {
        if (matrix == null || matrix.length < 1
        || matrix[0] == null || matrix[0].length < 1) {
            return;
        }
        //第一次遍历整个矩阵，每遇到一个零就把对应的行列的第一个元素设为0
        //第二次遍历第一行和第一列，对应元素设为0
        //isCol记录首列是否需要置0
        boolean isCol = false;
        for (int i = 0; i < matrix.length; i++) {
            if (matrix[i][0] == 0) {
                isCol = true;
            }

            for (int j = 1; j < matrix[0].length; j++) {
                if (matrix[i][j] == 0) {
                    matrix[0][j] = 0;
                    matrix[i][0] = 0;
                }
            }
        }

        for (int i = 1; i < matrix.length; i++) {
            for (int j = 1; j < matrix[0].length; j++) {
                if (matrix[i][0] == 0 || matrix[0][j] == 0) {
                    matrix[i][j] = 0;
                }
            }
        }

        if (matrix[0][0] == 0) {
            for (int j = 0; j < matrix[0].length; j++) {
                matrix[0][j] = 0;
            }
        }

        if (isCol) {
            for (int i = 0; i < matrix.length; i++) {
                matrix[i][0] = 0;
            }
        }
    }

    public static void main(String[] args) {
        int[][] matrix = {
                {1,2,1},
                {0,5,2},
        };
        setZeroes(matrix);
    }
}
