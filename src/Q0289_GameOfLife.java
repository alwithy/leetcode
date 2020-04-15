public class Q0289_GameOfLife {
    public static void gameOfLife(int[][] board) {
        //使用额外的状态。1表示依然存活，-1表示目前存活但下回合会死亡
        // 2表示目前死亡但下回合会复活
        int[] neighbors = {0, 1, -1};
        int rows = board.length;
        int cols = board[0].length;
        for (int row = 0; row < rows; row++) {
            for (int col = 0; col < cols; col++) {
                //记录周围存活细胞的数量
                int liveNeighbors = 0;

                //遍历周围细胞
                for (int i = 0; i < 3; i++) {
                    for (int j = 0; j < 3; j++) {
                        //i,j同时为0则是这个细胞自身
                        if (!(neighbors[i] == 0 && neighbors[j] == 0)) {
                            if (row + neighbors[i] >= 0
                                    && row + neighbors[i] < rows
                                    && col + neighbors[j] >= 0
                                    && col + neighbors[j] < cols
                                    && Math.abs(board[row + neighbors[i]][col + neighbors[j]]) == 1) {
                                liveNeighbors++;
                            }
                        }
                    }
                }

                //如果这个细胞目前存活
                if (board[row][col] == 1) {
                    if (liveNeighbors < 2 || liveNeighbors > 3) {
                        board[row][col] = -1;
                    }
                } else {
                    //如果这个细胞目前死亡
                    if (liveNeighbors == 3) {
                        board[row][col] = 2;
                    }
                }
            }
        }

        //再次遍历，更新状态
        for (int row = 0; row < rows; row++) {
            for (int col = 0; col < cols; col++) {
                if (board[row][col] == -1) {
                    board[row][col] = 0;
                } else if (board[row][col] == 2) {
                    board[row][col] = 1;
                }
            }
        }
    }

    public static void main(String[] args) {
        int[][] board = {{0,1,0},
                         {0,0,1},
                         {1,1,1},
                         {0,0,0}};
        gameOfLife(board);
    }
}
