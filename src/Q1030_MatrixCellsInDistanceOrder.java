public class Q1030_MatrixCellsInDistanceOrder {
    public static int[][] allCellsDistOrder(int R, int C, int r0, int c0) {
        int[][] res = new int[R * C][2];
        int index = 1;
        res[0][0] = r0;
        res[0][1] = c0;
        int distance = 1;
        while (index < res.length) {
            for (int i = 0; i <= distance; i++) {
                int j = distance - i;
                if (help(R, C, r0 + i, c0 + j)) {
                    res[index][0] = r0 + i;
                    res[index][1] = c0 + j;
                    index++;
                }
                if (help(R, C, r0 + i, c0 - j) && j != 0) {
                    res[index][0] = r0 + i;
                    res[index][1] = c0 - j;
                    index++;
                }
                if (help(R, C, r0 - i, c0 + j) && i != 0) {
                    res[index][0] = r0 - i;
                    res[index][1] = c0 + j;
                    index++;
                }
                if (help(R, C, r0 - i, c0 - j) && i != 0 && j != 0) {
                    res[index][0] = r0 - i;
                    res[index][1] = c0 - j;
                    index++;
                }
            }
            distance++;
        }
        return res;
    }

    public static boolean help(int R, int C, int curR, int curC) {
        return curR >= 0 && curR < R && curC >= 0 && curC < C;
    }

    public static void main(String[] args) {
        int[][] res = allCellsDistOrder(2, 3, 1, 2);
    }
}
