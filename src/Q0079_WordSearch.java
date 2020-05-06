import java.util.HashSet;

public class Q0079_WordSearch {
    public static boolean exist(char[][] board, String word) {
        if (board == null || board.length < 1
        || board[0] == null || board[0].length < 1) {
            return false;
        }
        char[] words = word.toCharArray();
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (existCore
                        (board, i, j, words, 0, new HashSet<>())) {
                    return true;
                }
            }
        }

        return false;
    }

    /**
     *
     * @param board 搜索使用的字典
     * @param row 字典中元素横坐标
     * @param col 字典中元素纵坐标
     * @param words 搜索用的单词
     * @param begin 本次搜索的单词元素的索引
     * @param used 保存字典中使用过的元素的坐标，编码方式为201 * row + col
     * @return
     */
    private static boolean existCore(char[][] board,
                                     int row,
                                     int col,
                                     char[] words,
                                     int begin,
                                     HashSet<Integer> used) {
        if (begin == words.length) {
            return true;
        } else if (row < 0 || row >= board.length
                || col < 0 || col >= board[0].length
                || board[row][col] != words[begin]) {
            return false;
        }

        used.add(201 * row + col);

        // 尝试下一步走board[row + 1][col]
        if (!used.contains(201 * (row + 1) + col)) {
            used.add(201 * (row + 1) + col);
            if (existCore(board, row + 1, col, words,
                    begin + 1, used)) {
                return true;
            }
            used.remove(201 * (row + 1) + col);
        }

        // board[row - 1][col]
        if (!used.contains(201 * (row - 1) + col)) {
            used.add(201 * (row - 1) + col);
            if (existCore(board, row - 1, col, words,
                    begin + 1, used)) {
                return true;
            }
            used.remove(201 * (row - 1) + col);
        }

        // board[row][col + 1]
        if (!used.contains(201 * row + col + 1)) {
            used.add(201 * row + col + 1);
            if (existCore(board, row, col + 1, words,
                    begin + 1, used)) {
                return true;
            }
            used.remove(201 * row + col + 1);
        }

        // board[row][col - 1]
        if (!used.contains(201 * row + col - 1)) {
            used.add(201 * row + col - 1);
            if (existCore(board, row, col - 1, words,
                    begin + 1, used)) {
                return true;
            }
            used.remove(201 * row + col - 1);
        }

        return false;
    }

    public static void main(String[] args) {
        char[][] board = {{'a','a'}};
        System.out.println(exist(board, "aaa"));
    }
}
