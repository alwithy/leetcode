package vivo_2020;


import java.util.HashMap;

public class Q1 {
    private static int res;

    public static int solution (int m, int n) {
        // 最少m个键，最多n个键，dfs算法解决
        res = 0;
        if (n == 0 || m > n) return res;
        boolean[][] isVisited = new boolean[3][3];
        dfs(Math.max(1, m), Math.min(9, n), 0, -1, -1, isVisited);

        return res;
    }

    /**
     *
     * @param m
     * @param n
     * @param lastI 上一次访问的按键横坐标
     * @param lastJ 上一次访问的按键纵坐标
     * @param hasVisited 已有按键数
     */
    private static void dfs(int m,
                     int n,
                     int hasVisited,
                     int lastI,
                     int lastJ,
                     boolean[][] isVisited) {
        if (hasVisited >= m) {
            res++;
            if (hasVisited == n) {
                return;
            }
        }

        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (!isVisited[i][j]) {
                    if (hasVisited > 0) {
                        int midI = i + lastI;
                        int midJ = j + lastJ;
                        if (midI % 2 == 0 && midJ % 2 == 0
                                && !isVisited[midI/2][midJ/2]) {
                            continue;
                        }
                    }
                    isVisited[i][j] = true;
                    dfs(m, n, hasVisited + 1, i, j, isVisited);
                    isVisited[i][j] = false;
                }
            }
        }
    }

    public static void main(String[] args) {
        System.out.println(solution(4, 4));
    }
}
