import java.util.HashSet;

public class Q0036_ValidSudoku {
    public boolean isValidSudoku(char[][] board) {
        HashSet<Character>[] help = new HashSet[9];
        for (HashSet<Character> set : help) {
            set = new HashSet<>();
        }

        // 横排
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                if (board[i][j] != '.') {
                    if (help[i].contains(board[i][j])) return false;
                    help[i].add(board[i][j]);
                }
            }
        }
        for (HashSet<Character> set : help) set.clear();
        // 竖排
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                if (board[i][j] != '.') {
                    if (help[j].contains(board[i][j])) return false;
                    help[j].add(board[i][j]);
                }
            }
        }
        for (HashSet<Character> set : help) set.clear();
        // 方块
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                if (board[i][j] != '.') {
                    int cur = i/3 * 3 + j/3;
                    if (help[cur].contains(board[i][j])) return false;
                    help[cur].add(board[i][j]);
                }
            }
        }

        return true;
    }
}
