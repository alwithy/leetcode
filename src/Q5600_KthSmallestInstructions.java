public class Q5600_KthSmallestInstructions {
    // num[i][j]表示c_i^j
    static int[][] num = new int[100][100];

    public static String kthSmallestPath(int[] destination, int k) {
        StringBuilder res = new StringBuilder();
        int m = destination[1]; // H的数量
        int n = destination[0]; // V的数量
        while (m > 0 && n > 0) {
            int cur = getNum(m + n - 1, n);
            if (k > cur) {
                res.append("V");
                n--;
                k -= cur;
            } else {
                res.append("H");
                m--;
            }
        }
        while (m > 0) {
            res.append("H");
            m--;
        }
        while (n > 0) {
            res.append("V");
            n--;
        }
        return res.toString();
    }

    // 返回c_m^n
    public static int getNum(int m, int n) {
        if (n == 0 || m == n) return 1;
        if (num[m][n] != 0) return num[m][n];
        // 计算c_m^n（m个里选n个）
        num[m][n] = getNum(m - 1, n - 1) + getNum(m - 1, n);
        num[m][m - n] = num[m][n];
        return num[m][n];
    }
}
