public class Q0048_RotateImage {
    public void rotate(int[][] matrix) {
        if (matrix.length <= 1) {
            return;
        }
        int len = matrix.length;
        //把矩阵切成len/2个环，分别解决
        //(n,n)为每个环的起点位置
        for (int n = 0; n < len/2; n++) {
            //curLen为本环每一块的长度，一环被分为四块
            //顺时针方向分别为a,b,c,d
            int curLen = len - 1 - 2 * n;

            //a与d交换
            for (int i = 0; i < curLen; i++) {
                swap(matrix, n + curLen - i, n,
                        n, n + i);
            }

            //a已经到了d的位置，再与c交换
            for (int i = 0; i < curLen; i++) {
                swap(matrix, n + curLen - i, n,
                        n + curLen, n + curLen - i);
            }

            //a到了c的位置，最后与b交换
            for (int i = 0; i < curLen; i++) {
                swap(matrix, n + curLen, n + curLen - i,
                        n + i, n + curLen);
            }
        }
    }

    //交换matrix[i][j] 和 matrix[k][l]
    public static void swap(int[][] matrix,
                            int i, int j,
                            int k, int l) {
        int temp = matrix[i][j];
        matrix[i][j] = matrix[k][l];
        matrix[k][l] = temp;
    }
}
