public class Q0766_ToeplitzMatrix {
    //没有限制的情况
    public boolean isToeplitzMatrix1(int[][] matrix) {
        if (matrix.length <= 1) {
            return true;
        }
        //二维矩阵中每个元素的位置为(row,column)
        int rows = matrix.length;
        int columns = matrix[0].length;
        int row,column;
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                row = i;
                column = j;
                while (row + 1 < rows && column + 1 < columns) {
                    if (matrix[++row][++column] != matrix[i][j]) {
                        return false;
                    }
                }
            }
        }
        return true;
    }
}
