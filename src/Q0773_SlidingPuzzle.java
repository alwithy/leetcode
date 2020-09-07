import java.util.Deque;
import java.util.HashSet;
import java.util.LinkedList;

public class Q0773_SlidingPuzzle {
    static int[][] tar = {{1,2,3}, {4,5,0}};
    static int[] moveI = {1, -1, 0, 0};
    static int[] moveJ = {0, 0, 1, -1};

    public static int slidingPuzzle(int[][] board) {
        int res = -1;
        Deque<int[][]> deque = new LinkedList<>();
        Deque<Integer> times = new LinkedList<>();
        HashSet<Integer> moved = new HashSet<>();
        int[][] cur = new int[2][3];
        for (int i = 0; i < 2; i++) {
            for (int j = 0; j < 3; j++) {
                cur[i][j] = board[i][j];
            }
        }
        // times代表当前移动的次数
        deque.add(cur);
        times.add(0);
        int time;
        while (!deque.isEmpty()) {
            cur = deque.poll();
            time = times.poll();
            moved.add(help(cur));
            if (check(cur)) {
                if (res < 0) {
                    res = time;
                } else {
                    res = Math.min(time, res);
                }
                break;
            }
            int zeroI = 0;
            int zeroJ = 0;
            for (int i = 0; i < 2; i++) {
                for (int j = 0; j < 3; j++) {
                    if (cur[i][j] == 0) {
                        zeroI = i;
                        zeroJ = j;
                    }
                }
            }

            for (int i = 0; i < 4; i++) {
                int nextI = zeroI + moveI[i];
                int nextJ = zeroJ + moveJ[i];
                if (nextI >= 0 && nextI < 2
                        && nextJ >= 0 && nextJ < 3) {
                    int[][] next = getNext(cur, zeroI, zeroJ, nextI, nextJ);
                    if (!moved.contains(help(next))) {
                        deque.add(next);
                        times.add(time + 1);
                    }
                }
            }
        }

        return res;
    }

    private static boolean check(int[][] cur) {
        for (int i = 0; i < 2; i++) {
            for (int j = 0; j < 3; j++) {
                if (cur[i][j] != tar[i][j]) return false;
            }
        }
        return true;
    }

    private static int help(int[][] cur) {
        int res = 0;
        for (int i = 0; i < 2; i++) {
            for (int j = 0; j < 3; j++) {
                res = res * 10 + cur[i][j];
            }
        }

        return res;
    }

    private static int[][] getNext(int[][] cur, int zeroI, int zeroJ,
                                   int nextI, int nextJ) {
        int[][] next = new int[2][3];
        for (int i = 0; i < 2; i++) {
            for (int j = 0; j < 3; j++) {
                next[i][j] = cur[i][j];
            }
        }

        int temp = next[nextI][nextJ];
        next[zeroI][zeroJ] = temp;
        next[nextI][nextJ] = 0;

        return next;
    }

    public static void main(String[] args) {
        int[][] arr = {{1,2,3}, {4,0,5}};
        System.out.println(slidingPuzzle(arr));
    }
}
