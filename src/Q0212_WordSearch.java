import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;

public class Q0212_WordSearch {
    static int[] moveI = {1, -1, 0, 0};
    static int[] moveJ = {0, 0, 1, -1};
    static Node root;

    public static List<String> findWords(char[][] board, String[] words) {
        root = new Node();
        for (String word : words) {
            addWord(word, root);
        }

        int cols = board.length;
        int rows = board[0].length;
        boolean[][] visited = new boolean[cols][rows];
        HashSet<String> set = new HashSet<>();
        for (int i = 0; i < cols; i++) {
            for (int j = 0; j < rows; j++) {
                if (root.children.containsKey(board[i][j])) {
                    visited[i][j] = true;
                    dfs(i, j, board, visited, root.children.get(board[i][j]), set);
                    visited[i][j] = false;
                }
            }
        }

        List<String> res = new ArrayList<>();
        for (String word : words) {
            if (set.contains(word)) {
                res.add(word);
            }
        }

        return res;
    }

    public static void dfs(int i, int j, char[][] board, boolean[][] visited, Node node, HashSet<String> set) {
        if (node.word != null) {
            set.add(node.word);
            removeWord(node.word, root);
        }

        //依次向上下左右四个方向走
        for (int k = 0; k < 4; k++) {
            int nextI = i + moveI[k];
            int nextJ = j + moveJ[k];

            if (canMove(nextI, nextJ, board, visited, node)) {
                visited[nextI][nextJ] = true;
                dfs(nextI, nextJ, board, visited,
                        node.children.get(board[nextI][nextJ]), set);
                visited[nextI][nextJ] = false;
            }
        }
    }

    public static boolean canMove(int i, int j, char[][] board, boolean[][] visited, Node node) {
        return i >= 0 && i < board.length && j >= 0 && j < board[0].length //在范围内
                && !visited[i][j] //未访问过
                && node.children.containsKey(board[i][j]); //node有对应的child节点
    }

    //前缀树节点
    static class Node {
        HashMap<Character, Node> children;
        String word;//该节点对应的单词
        int num;//通过该节点的单词数量

        public Node() {
            children = new HashMap<>();
            word = null;
        }
    }

    public static void addWord(String word, Node root) {
        if (word == null || word.length() == 0) {
            return;
        }
        Node node = root;
        node.num++;
        for (int i = 0; i < word.length(); i++) {
            char c = word.charAt(i);
            if (!node.children.containsKey(c)) {
                node.children.put(c, new Node());
            }
            node = node.children.get(c);
            node.num++;
        }
        node.word = word;
    }

    public static void removeWord(String word, Node root) {
        removeWord(0, word, root);
    }

    public static void removeWord(int index, String word, Node node) {
        if (index == word.length()) {
            node.num--;
            node.word = null;
            return;
        }
        char c = word.charAt(index);
        Node child = node.children.get(c);
        removeWord(index + 1, word, child);
        if (child.num == 0) {
            node.children.remove(c);
        }
    }

    public static void main(String[] args) {
        char[][] board = {{'a'}};
        String[] words = {"a"};
        List<String> res = findWords(board, words);
    }
}
