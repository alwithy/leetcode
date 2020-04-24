public class Q0835_ImageOverlap {
    //暴力法
    public int largestOverlap(int[][] A, int[][] B) {
        if (A == null || B == null || A.length != B.length
            || A.length < 1) {
            return 0;
        }
        int n = A.length;
        //将数组A固定，(i,j)是A中的点
        //移动B，偏移量(r,c),其中-n + 1 <= r,c <= n - 1
        //即，A中(i,j)与B中(i + r, j + c)重叠
        //每移动一次就遍历数组A和B,cur保留最近的重叠值
        //max保留最大的重叠值
        int cur = 0;
        int max = 0;
        for (int r = -n + 1; r <= n - 1; r++) {
            for (int c = -n + 1; c <= n - 1; c++) {
                cur = 0;
                //遍历数组A
                for (int i = 0; i < n; i++) {
                    for (int j = 0; j < n; j++) {
                        if (i + r >= 0 && i + r < n
                        && j + c >= 0 && j + c < n
                        && A[i][j] == 1
                        && B[i + r][j + c] == 1) {
                            cur++;
                        }
                    }
                }
                max = Math.max(max,cur);
            }
        }
        return max;
    }
}
