public class Q0661_ImageSmoother {
    public int[][] imageSmoother(int[][] M) {
        int[][] res = new int[M.length][M[0].length];
        int[] neighbors = {0,1,-1};
        int count;
        for (int i = 0; i < M.length; i++) {
            for (int j = 0; j < M[0].length; j++) {
                //求每个点周围点的数量以及灰度和
                count = 0;
                for (int k = 0; k < 3; k ++) {
                    for (int l = 0; l < 3; l++) {
                        if ( i + neighbors[k] >= 0
                            && i + neighbors[k] < M.length
                            && j + neighbors[l] >= 0
                            && j + neighbors[l] < M[0].length) {
                            res[i][j] +=
                                    M[i + neighbors[k]][j + neighbors[l]];
                            count++;
                        }
                    }
                }
                res[i][j] /= count;
            }
        }
        return res;
    }
}
