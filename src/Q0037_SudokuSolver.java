public class Q0037_SudokuSolver {
    int[][] rows = new int[9][10];
    int[][] columns = new int[9][10];
    int[][] boxes = new int[9][10];

    char[][] board;

    boolean solved = false;

    private boolean couldPlace(int d, int row, int col) {
        // 看能否放数字d在[row][col]
        int index = (row/3)*3 + col/3;
        return rows[row][d] + columns[col][d] + boxes[index][d] == 0;
    }

    private void placeNum(int d, int row, int col) {
        // 把数字d放在[row][col]
        int index = (row/3)*3 + col/3;
        rows[row][d]++;
        columns[col][d]++;
        boxes[index][d]++;
        board[row][col] = (char) (d + '0');
    }

    private void removeNum(int d, int row, int col) {
        // 把数字d从[row][col]删除
        int index = (row/3)*3 + col/3;
        rows[row][d]--;
        columns[col][d]--;
        boxes[index][d]--;
        board[row][col] = '.';
    }

    private void placeNextNum(int row, int col) {
        // 从[row][col]出发寻找下一个空白的格子
        if (col == 8 && row == 8) {
            solved = true;
        } else {
            if (col == 8) {
                // 去下一行
                backtrack(row + 1, 0);
            } else {
                backtrack(row, col + 1);
            }
        }
    }

    private void backtrack(int row, int col) {
        // 回溯算法
        if (board[row][col] == '.') {
            // 若格子为空,则枚举可以放入的数字并放入
            for (int i = 1; i <= 9; i++) {
                if (couldPlace(i, row, col)) {
                    placeNum(i, row, col);
                    placeNextNum(row, col);
                    if (!solved) removeNum(i, row, col);
                }
            }
        } else {
            placeNextNum(row, col);
        }
    }


    public void solveSudoku(char[][] board) {
        this.board = board;

        // 初始化rows, columns, boxes
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                if (board[i][j] != '.') {
                    int num = board[i][j] - '0';
                    placeNum(num, i, j);
                }
            }
        }
        backtrack(0, 0);
    }
}
